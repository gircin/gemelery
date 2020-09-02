import java.util.Scanner;

/**
 * Main class, wich will contain all gem's (jevelery's inserts) data
 * Creating class object initialize user's console interface to entering gem's forms and sizes
 * ---------- gem's colors in next relises --------------------
 */
class Gem {
    private GemForm gemForm;
    // TODO: will delete in realise. Only for debug
    public GemForm getGemForm() { return gemForm; }

    private GemSize gemSize;
    // TODO: will delete in realise. Only for debug
    public GemSize getGemSize() { return gemSize; }

     /** This method creates an input stream from the console,
      * to select the gem's form.
      * Each form name is numbered and the choice of the desired one is made by entering the correct number.
      *
      * The method will can throws two exceptions:
      * - InputMismatchException if a non-digit is entered
      * - ArrayIndexOutOfBoundException when after invalid's
      * entered value, the method tries to access outside the gem's form array.
      * Exceptions are "swallowed", generating warning message.
      * Variable that pointing on the array's index is resets and offered to select the gem's form again
      */
    private GemForm choseForm(){
        int gemFormNumber = 0; // contains gem's form number value
        GemForm[] gemForms = GemForm.values(); // creates gem's form enumerations array
        boolean isIncorrectInput = false; // tracks exception thrown

        // initializes output of the gem's types list and gem's number enter request
        do {
            // if thrown exception, this text will bo not printing
            if (!isIncorrectInput) {
                System.out.print("Выберите один из вариантов форм камней, введя цифру:\n");
            }
            // iterates the gem's formes array and prints by three on the line
            // it is can make better, but I don't want, cause I plan remake console's interface to other
            int newLineCounter = 0;
            for (GemForm f : gemForms) {
                System.out.print((f.ordinal()) + 1 + ". " + f.ruName + "\t\t");
                newLineCounter++;
                if (newLineCounter % 3 == 0 || newLineCounter == gemForms.length)
                    System.out.println("");
            }
            // number entering request
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

    /** Creating an object will initialize methods, which
     * open console's input stream for choosing gems form, size and color
     */
    Gem() {
        // method for choosing gem's form
        gemForm = choseForm();
        // creating new GemSize object that takes a existing gem's form object
        // object creating also initializes console's input of the gem's size
        gemSize = new GemSize(getGemForm());
    }
}
