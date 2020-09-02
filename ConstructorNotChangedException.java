package gem;

/** Данное исключение генерируется, если после изменения количества перечислений форм
 * класса GemForm соответствующе изменения не внесены в конструктор класса GemSize.
 * Конструктор GemSize использует перечисления GemForm для определения количества измеряемых сторон.
 * Константа formsQuantity из класса GemForm используется длиной массив перечислений своего класса,
 * а такая же константа в классе GemSize устанавливается в коде вручную,
 * чтоб гарантировать изменение конструктора.
 */
public class ConstructorNotChangedException extends RuntimeException {
    public ConstructorNotChangedException(String message) {
        super(message);
    }
}