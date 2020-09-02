package gem;

import java.util.Scanner;

/**
 * Основной класс, который должен инкапсулировать всю информацию о камне (вставке).
 *
 * Создание объекта инициализирует пользовательский консольный интерфейс для выбора формы и размера камня
 * ---------- в дальнейшем и цвета --------------------
 */
class Gem {
    private GemForm gemForm;
    // TODO в релизе сделать приватным
    public GemForm getGemForm() { return gemForm; }

    private GemSize gemSize;
    // TODO в релизе сделать приватным
    public GemSize getGemSize() { return gemSize; }

     /** Данный метод создаёт поток ввода из консоли,
      * для выбора формы камня.
      * Каждое название формы пронумеровано и выбор нужной совешается вводом соответствующей цифры.
      *
      * Метод генерирует два исключения:
      * - InputMismatchException если введена не цифра и
      * - ArrayIndexOutOfBoundException когда после неверно
      * введённого значения метод пытается получить доступ за предел массива форм камней.
      * Исключения "проглатываются", формируется предупреждающее сообщение-инструкция
      * и переменная, которая указывает на индекс массива форм камней обнуляется,
      * после чего предлагается выбрать форму снова
      */
    private GemForm choseForm(){
        int gemFormNumber = 0; // хранит значение формы камня
        GemForm[] gemForms = GemForm.values(); // создаёт массив всех типов камней
        boolean isIncorrectInput = false; // отслеживает генерацию исключения

        // инициализирует вывод списка с запросом введения номера формы камня
        do {
            // если исключение было сгенерировано, то этот текст не будет напечатан
            if (!isIncorrectInput) {
                System.out.print("Выберите один из вариантов форм камней, введя цифру:\n");
            }
            // перебирает все формы камней, по три в ряд
            // это можно делать как-то красивее, но я не хочу, т.к. собираюсь переделать консольный интерфейс
            int newLineCounter = 0;
            for (GemForm f : gemForms) {
                System.out.print((f.ordinal()) + 1 + ". " + f.ruName + "\t\t");
                newLineCounter++;
                if (newLineCounter % 3 == 0 || newLineCounter == gemForms.length)
                    System.out.println("");
            }
            // запрашивает ввод символа в консоль
            Scanner scanner = new Scanner(System.in);
            try {
                gemFormNumber = scanner.nextInt();
            } catch (Exception e) {
                System.err.print("Введите ЦИФРУ для выбора соответствующего варианта\n");
                gemFormNumber = 0;
                isIncorrectInput = true;
                continue;
            }
        } while (gemFormNumber < 1 || gemFormNumber > gemForms.length);
        return gemForms[gemFormNumber - 1];
    }

    /** Создание объекта инициализирует запуск методов, которые
     * открывают поток ввода в консоль для выбора формы, размеров и цвета камня
     */
    Gem() {
        // вызов метода выбора формы и присвоение значения
        gemForm = choseForm();
        // создание нового объекта параметра GemSize, с передачей в него объекта формы.
        // Создание объекта GemSize инициалзирует ввод данных о его размере в консоль
        gemSize = new GemSize(getGemForm());
    }
}
