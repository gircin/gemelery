/ ** This exception is thrown if after changing the number of enumerations of forms
 * of the GemForm class, no corresponding changes were made to the constructor of the GemSize class.
 * The GemSize constructor uses GemForm enumerations to define the number of sides to measure.
 * The formsQuantity constant from the GemForm class is used the length of the enumeration array of its class.
 * The same constant in the GemSize class is set manually in the code,
 * to ensure that the constructor is changed.
 * /
public class ConstructorNotChangedException extends RuntimeException {
    public ConstructorNotChangedException(String message) {
        super(message);
    }
}
