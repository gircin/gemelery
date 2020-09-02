/** This enum contain gem forms
 * (or hereinafter - types of inserts in jewelery).
 * The form of the gem influences its measured parameters:
 * WIDTH, LENGTH, HEIGHT
 *
 * Also, the gem's form determine of calculating method its volume, which is needed for
 * calculating the weight of the stone
 * Stone weight = Volume * Density
 * OR
 * The second option for calculating the weight of a stone can be using existing tables,
 * which contain the data of the measure gems with their size, color and weight.
 *
 * The best option would be to use an integrated approach,
 * i.e. finding of the weight of the gem according to the table, when it contains correct data (+- 1 mm),
 * and if there is no data in the table, then the volume and weight are calculated by the formula.
 *
 * This class contain data for a limited list of forms only.
 * To find out the size of a certain gem's form, an object of this class
 * is passed to the GemSize class
 */
enum GemForm {
    // TODO: add links to gem's form pic
    ROUND("Round"),
    SPHERE("Perl"),
    OVAL("Oval"),
    CABOCHON("Cabouchon"),
    BAGUETTE("Baguette"),
    MARQUIS("Marquis"),
    SQUARE("Square"),
    HEART("Heart"),
    TRIANGLE("Triangre");
    //ANOTHER("Another");

    //TODO pic type, like a favicon or something like
    // it is a text description for easiest debug
    String ruName;
    GemForm(String pic) {
        this.ruName = pic;
    }

    @Override
    public String toString() {
        return ruName;
    }

    // Constant that is initialized when the class is loaded
    // Created to track changes in the number of forms
    public static final int formsQuantity = values().length;
}
