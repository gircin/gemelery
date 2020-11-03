import java.util.Scanner;

public class Gemstone {
    private Form form;
    private Color color;

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
     */
    private enum Form {
        // ---------------DIAMETER----------------
        // TODO: calculate and change this form!
        PEARL("Pearl"),
        // ------------WIDTH, HEIGHT--------------
        ROUND("Round"), //
        SQUARE("Square"),
        TRIANGLE("Triangle"),
        // --------LENGTH, WIDTH, HEIGHT----------
        OVAL("Oval"), //
        CABOCHON("Cabochon"),
        BAGUETTE("Baguette"),
        PEAR("Pear"),
        MARQUES("Marques"),
        HEART("Heart"),
        AMBER("Amber");

        final String name;

        Color[] possibleColors;
        double[] sizes;

        Form(String name) {
            this.name = name;
            switch (this.name) {
                case "Pearl":
                    sizes = new double[]{0.0};
                    break;
                // ---------------------------------------
                case "Round":
                case "Square":
                case "Triangle":
                    sizes = new double[]{0.0, 0.0};
                    break;
                // ---------------------------------------
                case "Oval":
                case "Cabochon":
                case "Baguette":
                case "Pear":
                case "Marques":
                case "Heart":
                case "Amber":
                    sizes = new double[]{0.0, 0.0, 0.0};
                    break;
                default:
                    throw new IllegalArgumentException("Exception in Form constructor");
            }
            switch (this.name) {
                case "Amber":
                    possibleColors = new Color[]{Color.ORANGE};
                    break;
                case "Pearl":
                    possibleColors = new Color[]
                            {Color.WHITE, Color.PINK, Color.ORANGE,
                             Color.VIOLET, Color.GREY, Color.BLACK};
                    break;
                case "Triangle":
                    possibleColors = new Color[]
                            {Color.WHITE, Color.PINK, Color.VIOLET, Color.NAVY,
                             Color.YELLOW, Color.BLACK, Color.BROWN};
                    break;
                case "Marques":
                    possibleColors = new Color[]
                            {Color.WHITE, Color.RED, Color.PINK, Color.LIGHT_PINK,
                             Color.VIOLET, Color.NAVY, Color.YELLOW, Color.BLACK,
                             Color.BROWN};
                    break;
                case "Heart":
                    possibleColors = new Color[]{Color.WHITE};
                    break;
                case "Oval":
                    possibleColors = new Color[]
                            {Color.WHITE, Color.RED, Color.PINK, Color.LIGHT_PINK,
                             Color.VIOLET, Color.NAVY, Color.BLUE, Color.GREEN,
                             Color.YELLOW, Color.BLACK, Color.BROWN};
                    break;
                case "Baguette":
                case "Square":
                case "Cabochon":
                case "Pear":
                    possibleColors = new Color[]
                            {Color.WHITE, Color.RED, Color.PINK, Color.VIOLET,
                             Color.NAVY, Color.GREEN, Color.YELLOW, Color.BLACK,
                             Color.BROWN};
                    break;
                case "Round":
                    possibleColors = new Color[]
                            {Color.WHITE, Color.RED, Color.PINK, Color.LIGHT_PINK,
                             Color.VIOLET, Color.NAVY, Color.BLUE, Color.GREEN,
                             Color.YELLOW,  Color.BLACK, Color.BROWN, Color.ORANGE};
                    break;
            }
        }
    }

    // TODO: dedicated method for get the list of forms, colors, sizes
    public void setForm(){
        int gemFormNumber;
        Form[] gemForms = Form.values();
        boolean isIncorrectInput = false;
        // initializes output of the gem's types list and gem's number enter request
        do {
            // if thrown exception, this text will be not printing
            if (!isIncorrectInput) {
                System.out.print("Select one of the options for the gemstone form by entering a number:\n");
            }
            int newLineCounter = 0;
            for (Form f : gemForms) {
                System.out.print((f.ordinal()) + 1 + ". " + f.name + "\t\t\t\t");
                newLineCounter++;
                if (newLineCounter % 3 == 0 || newLineCounter == gemForms.length)
                    System.out.print("\n");
            }
            // number entering request
            Scanner scanner = new Scanner(System.in);
            try {
                gemFormNumber = scanner.nextInt();
            } catch (Exception e) {
                System.err.print("Enter the NUMBER to select the appropriate option\n");
                gemFormNumber = 0;
                isIncorrectInput = true;
            }
        } while (gemFormNumber < 1 || gemFormNumber > gemForms.length);
        form = gemForms[gemFormNumber - 1];
    }
    public Form getForm() { return form; } // maybe not necessary
    public String getFormName() { return getForm().name; }
    public double[] getSizes() { return getForm().sizes; }
    public Color[] getPossibleColors() { return getForm().possibleColors; }
    public void setSizes() {
        String[] dimensionsName;
        int dimensionsQuantity = getSizes().length;
        switch (dimensionsQuantity) {
            case 1: {
                dimensionsName = new String[]{"DIAMETER"};
                break;
            }
            case 2: {
                dimensionsName = new String[]{"WIDTH", "HEIGHT"};
                break;
            }
            case 3: {
                dimensionsName = new String[]{"LENGTH", "WIDTH", "HEIGHT"};
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value of dimensionsName array: "
                                                + dimensionsQuantity);
        }
        boolean isIncorrectInput = false;
        for (int i = 0; i < dimensionsQuantity; i++) {
            do {
                Scanner scanner = new Scanner(System.in);
                if (!isIncorrectInput) {
                    System.out.println("Enter " + dimensionsName[i] + " as a decimal number in millimeters:");
                }
                try {
                    form.sizes[i] = scanner.nextDouble();
                    if (form.sizes[i] > 60.0) {
                        System.err.println("You can not set a size more than 60 mm");
                        form.sizes[i] = 0;
                    }
                    isIncorrectInput = false;
                } catch (Exception e) {
                    System.err.print("Enter a DECIMAL number to set a " + dimensionsName[i] + "\n" +
                            "Use a comma as a delimiter\n");
                    form.sizes[i] = 0;
                    isIncorrectInput = true;
                }
            } while (form.sizes[i] < 0.1);
        }
    }


    private enum Color {
        // 12-th total
        WHITE("White"),
        RED("Red"),
        PINK("Pink"),
        LIGHT_PINK("Light pink"),
        VIOLET("Violet"),// from magenta to violet
        NAVY("Navy"),
        BLUE("Blue"),
        GREEN("Green"),
        YELLOW("Yellow"),
        BLACK("Black"),
        BROWN("Brown"), // from creamy to brown
        ORANGE("Orange"),
        // only for pearl
        GREY("Silver grey");


        final String name;
        Color(String name) {
            this.name = name;
        }
    }

    public void setColor(){
        int gemColorNumber = 0;
        Color[] gemColors = this.getPossibleColors();
        boolean isIncorrectInput = false;
        if (getForm() == Form.AMBER) {
            color = Color.ORANGE;
        }
        do {

            if (!isIncorrectInput) {
                System.out.print("Select one of the options for the gem's color by entering a number:\n");
            }
            int newLineCounter = 0;
            for (int i = 0; i < gemColors.length; i++) {
                System.out.print((i + 1) + ". " + gemColors[i].name + "\t\t");
                newLineCounter++;
                if (newLineCounter % 3 == 0 || newLineCounter == gemColors.length)
                    System.out.print("\n");
            }
            Scanner scanner = new Scanner(System.in);
            try {
                gemColorNumber = scanner.nextInt();
            } catch (Exception e) {
                System.err.print("Enter the NUMBER to select the appropriate option\n");
                gemColorNumber = 0;
                isIncorrectInput = true;
            }
        } while (gemColorNumber < 1 || gemColorNumber > gemColors.length);
        color = gemColors[gemColorNumber - 1];
    }
    public Color getColor() { return color; } // maybe not necessary
    public String getColorName() { return getColor().name; }

    // TODO: add the densities for all of pairs form-color
    private double getDensity() {
        switch (form) {
            case AMBER: // done
                switch (color) {
                    case ORANGE:
                        return 1.0; // it is the only one right density for now
                }

            case PEARL:
                switch (color) {
                    case BROWN:
                    case WHITE:
                    case PINK:
                    case ORANGE:
                    case VIOLET:
                    case GREY:
                    case BLACK:
                        return 1.0; // test density
                }

            case ROUND:
            case SQUARE:
            case TRIANGLE:
            case OVAL:
            case CABOCHON:
            case BAGUETTE:
            case PEAR:
            case MARQUES:
            case HEART:
                return 1.0; // test density
            default:
                throw new IllegalArgumentException("Something wrong with density define in switch-case block");
        }
    }

    // done
    private double getVolume() {
        double d, l, w, h;
        d = l = w = h = 1.0;
        switch (getSizes().length) {
            case 1:
                d = getSizes()[0];
                break;
            case 2:
                w = getSizes()[0];
                h = getSizes()[1];
                break;
            case 3:
                l = getSizes()[0];
                w = getSizes()[1];
                h = getSizes()[2];
                break;
        }
        switch (getForm()) {
            // just d
            // TODO: change formula!
            case PEARL:
                return Math.pow(d, 3) * 0.0018;
            // only w and h
            case ROUND:
            case TRIANGLE:
                return w * w * h * 0.0018;
            case SQUARE:
                return w * w * h * 0.0024;
            // l, w, h
            case OVAL:
            case CABOCHON:
                return Math.pow(((l + w) / 2), 2) * h * 0.002;
            case BAGUETTE:
                return l * w * h * 0.0026;
            case PEAR:
                return l * w * h * 0.0018;
            case MARQUES:
                return l * w * h * 0.0017;
            case HEART:
                return l * w * h * 0.0021;
            case AMBER:
                return l * w * h * 0.00065;
            default:
                throw new IllegalArgumentException("Something wrong with volume formula");
        }
    }
    // round to 2 digit after comma
    double getWeight() {
         return (getDensity() * getVolume());
    }

}