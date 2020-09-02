/** This enum contain gem forms
 * (or hereinafter - types of inserts in jewelery).
 * The form of the gem influences its measured parameters will be determined:
 * Width Length Height
 *
 * Also, the form of calculating its volume, which is needed for
 * calculating the weight of the stone
 * Stone weight = Volume * Density
 * OR
 * The second option for calculating the weight of a stone can be using existing tables,
 * which contain the data of the measured stones with their size, color and weight.
 *
 * The best option would be to use an integrated approach,
 * i.e. finding of the weight of the stone according to the table, when it contains correct data (+- 1 mm),
 * and if there is no data in the table, then the volume and weight are calculated by the formula
 *
 * This class contain data for a limited list of forms only.
 * To find out the size of a certain gem's form, an object of this class
 * is passed to the GemSize class
 */
enum GemForm {
    ROUND("Круглый"),
    SPHERE("Бусина"), // maybe only perl?
    OVAL("Овал"),
    CABOCHON("Кабошон"),
    BAGUETTE("Багет"),
    MARQUIS("Маркиз"),
    CUBE("Квадрат"),
    HEART("Сердце"),
    TRIANGLE("Треугольник");
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
