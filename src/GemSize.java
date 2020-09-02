import java.util.Arrays;
import java.util.Scanner;

/**
 * This class represents size's parameters of stones,
 * which are needed to calculate the volume.
 * There are three basic parameters - width, length, height.
 * However, for some stones it makes no sense to measure all of this three.
 * For example, for beads (pearls), only the width is relevant, and this is a diameter.
 * Round, triangular, square gems has the same length and width, so
 * just can input the width.
 *
 * In the basic version, the size of the sides will be indicated as an int, in millimeters.
 * If necessary, it can be changed to double.
 * Side's value must be between 1 and 60 inclusive
 */
class GemSize {
    private String[] dimensionsName;
    private int[] gemsSizes;

    // TODO: delete getter for debugging information
    public String getSizes() {
        return Arrays.toString(gemsSizes);
    }
    // Constant to track changes in the types of forms and this class constructor
    public static final int formsQuantity = 9;

    /** The constructor takes a variable of the gem's form
     * and according to it defines how many parameters the gem will contain.
     * The number of parameters is the length of the gemsSizes array.
     * The parameters themselves are stored in an array, by default their value is 0
     *
     * WARNING!!! When changing the GemForm enum, changes must be also input into this constructor.
     * Constants that introduced in this class and the GemForm class may track the number of forms.
     * In the GemForm class, the constant is calculated during program initialization.
     * Its value is the amount of GemForm enum .
     * In this class, the constant is initialized and changed manually when introduced
     * changes to the constructor.
     * Constants are compared during constructor initialization, and if they differ, it will be
     * thrown its own unchecked ConstructorNotChangedException with comment
     */
    GemSize(GemForm gemForm) {
        // comparing constant values and throwing an exception
        if (formsQuantity != GemForm.formsQuantity)
            throw new ConstructorNotChangedException(
                    "The amount of gem's form in the GemForm class" +
                    " does not match that in the GemDimensions constructor");
        switch (gemForm) {
            case BEAD: // only a diameter for a beads 
                gemsSizes = new int[]{0};
                break;
            case ROUND:
            case SQUARE:
            case TRIANGLE: // round, square, triangle - width and height
                gemsSizes = new int[]{0, 0};
                break;
            case OVAL:
            case CABOCHON:
            case BAGUETTE:
            case MARQUIS:
            case HEART:  // oval, cabochon, baguette, marquis, heart - length, width and height
                gemsSizes = new int[]{0, 0, 0};
                break;
        }
        // initialization of input of gem's sizes
        enterGemsSize();
    }

    /** This method connect input from the console and
      * initializes the output of the list of matching parameters.
      * The method also checks these parameters for compliance with sizes from 1 to 60
      * and stores the sizes of the sides in the gemsSizes array
      * The method is private, because used in the main called enterGemsSize method
      */
    private void sizeInput() {
        boolean isIncorrectInput = false;
        for (int i = 0; i < gemsSizes.length; i++) {
            do {
                Scanner scanner = new Scanner(System.in);
                if (!isIncorrectInput)
                    System.out.println("Enter " + dimensionsName[i] + " as an integer number in millimeters:");
                try {
                    gemsSizes[i] = scanner.nextInt();
                    if (gemsSizes[i] > 60) {
                        System.err.println("You can not set a size more than 60 mm");
                        gemsSizes[i] = 0;
                    }
                } catch (Exception e) {
                    System.err.print("Enter an integer number to set a " + dimensionsName[i] + "\n");
                    gemsSizes[i] = 0;
                    isIncorrectInput = true;
                    continue;
                }
             } while (gemsSizes[i] < 1);
        }
    }

    /** The main classe's method that output the console's request for its defines gem's sizes.
      * Checks the array's size that was initialized by the constructor
      * and uses the sizeInput() method to input data from the console into this array
      *
      * This method is called in the constructor of the current class
      * to get the gem's sizes.
      */
    public void enterGemsSize() {
        int dimensionsQuantity = gemsSizes.length;
        switch (dimensionsQuantity) {
            case 1: {
                dimensionsName = new String[]{"DIAMETER"};
                sizeInput();
                break;
            }
            case 2: {
                dimensionsName = new String[]{"WIDTH", "HEIGHT"};
                sizeInput();
                break;
            }
            case 3: {
                dimensionsName = new String[]{"LENGTH", "WIDTH", "HEIGHT"};
                sizeInput();
                break;
            }
        }
    }
}
