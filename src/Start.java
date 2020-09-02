import java.io.*;

public class Start {
    public static void main(String[] args) throws IOException {
        Gem gem = new Gem();

        // Next is the debug code that allows to check the correctness of the entered data.
        // I know about IDEA debugging tools, just not used to using them comfortably :)
        // we recognize the gem's form
        System.out.println(gem.getGemForm());
        // we recognize the gem's sizes
        System.out.println(gem.getGemSize().getSizes());
    }
}
