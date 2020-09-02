package gem;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Данный класс представляет абстрактные параметры камней,
 * которые нужны для вычисления веса.
 * Есть три базовых параметра - ширина, длина, высота.
 * Однако для некоторых камней нет смысла измерять все три параметра.
 * Например, для бусин (жемчуга) актуальна только ширина, она же диаметр.
 * Круглые, треугольные, квадратные камни имеют одинаковую длину и ширину, поэтому
 * достаточно указать только ширину.
 *
 * В базовой версии размер сторон будет указываться как целое число int, в миллиметрах.
 * Если возникнет необходимость, то можно будет изменить на double.
 * Значение стороны должно быть в пределах от 1 до 60 включительно
 */
class GemSize {
    private String[] dimensionsName;
    private int[] gemsSizes;

    // TODO: геттер для получения отладочной информации
    public String getSizes() {
        return Arrays.toString(gemsSizes);
    }
    // константа для контроля изменений типов форм камней и конструктора данного класса
    public static final int formsQuantity = 9;

    /** Конструктор принимает переменную формы камня
     * и согласно ей определяет сколько параметров будет содержать камень.
     * Количество параметров - длина массива gemsSizes.
     * Сами параметры хранятся в массиве, по-умолчанию их значение равно 0
     *
     * ВАЖНО!!! При изменении списка форм камней его нужно вносить в данный конструктор.
     * Для отслеживания количества форм введены константы в этом классе и классе GemForm.
     * В классе GemForm константа вычисляется при инициализации программы. Её значение равно
     * количеству переменных форм.
     * В данном классе константа инициализируется вручную и изменяется вручную при внесении
     * изменений в конструктор.
     * Константы сравниваются при инициализации конструктора и в случае их различия будет
     * сгенерировано собственное unchecked-исключение ConstructorNotChangedException с комментарием
     */
    GemSize(GemForm gemForm) {
        // сравнение констант и генерация исключения
        if (formsQuantity != GemForm.formsQuantity)
            throw new ConstructorNotChangedException(
                    "Количество форм камней в классе GemForm" +
                    " не соответствует таковому в конструкторе GemDimensions");
        switch (gemForm) {
            case SPHERE: // бусины только диаметр
                gemsSizes = new int[]{0};
                break;
            case ROUND:
            case CUBE:
            case TRIANGLE: // круглые, квадратные, треугольные - ширина и высота
                gemsSizes = new int[]{0, 0};
                break;
            case OVAL:
            case CABOCHON:
            case BAGUETTE:
            case MARQUIS:
            case HEART:  // овалы, кабошоны, багеты, маркизы, сердца - длина, ширина и высота
                gemsSizes = new int[]{0, 0, 0};
                break;
        }
        // инициализирует ввод размеров камня
        enterGemsSize();
    }

    /** Данный метод подключает ввод из консоли и
     * инициализирует вывод списка соответствующих параметров.
     * Так же метод выполняет проверку этих параметров на соответствие размерам от 1 до 60
     * и сохраняет размеры сторон в массив gemsSizes
     * Метод приватный, т.к. используется в основном вызываемом метод enterGemsSize
     */
    private void sizeInput() {
        boolean isIncorrectInput = false;
        for (int i = 0; i < gemsSizes.length; i++) {
            do {
                Scanner scanner = new Scanner(System.in);
                if (!isIncorrectInput)
                    System.out.println("Укажите " + dimensionsName[i] + " в миллиметрах целым числом:");
                try {
                    gemsSizes[i] = scanner.nextInt();
                    if (gemsSizes[i] > 60) {
                        System.err.println("Нельзя указывать размер более 60 мм");
                        gemsSizes[i] = 0;
                    }
                } catch (Exception e) {
                    System.err.print("Введите ЧИСЛО, чтоб указать " + dimensionsName[i] + "\n");
                    gemsSizes[i] = 0;
                    isIncorrectInput = true;
                    continue;
                }
             } while (gemsSizes[i] < 1); // изменить значение массива размеров по-умолчанию на 0 и тут тоже на 0
        }
    }

    /** Основной метод, который выводит запрос определяемых в нём сторон.
     * Проверяет размер массива, который был инициализирован конструктором
     * и использует метод sizeInput() для ввода данных из консоли в этот массив
     *
     * Данный метод вызывается в конструкторе текущего класса
     * для получения размеров камня.
     */
    public void enterGemsSize() {
        int dimensionsQuantity = gemsSizes.length;
        switch (dimensionsQuantity) {
            case 1: {
                dimensionsName = new String[]{"ДИАМЕТР"};
                sizeInput();
                break;
            }
            case 2: {
                dimensionsName = new String[]{"ШИРИНУ", "ВЫСОТУ"};
                sizeInput();
                break;
            }
            case 3: {
                dimensionsName = new String[]{"ДЛИНУ", "ШИРИНУ", "ВЫСОТУ"};
                sizeInput();
                break;
            }
        }
    }
}
