package gem;

import java.io.*;

public class Start {
    public static void main(String[] args) throws IOException {
        Gem gem = new Gem();

        // Код далее отладочный, позволяет получить корректность заполняемых данных
        // Я знаю про дебаг и брейкпоинты, просто пока не привык им комфортно пользоваться :)
        // узнаём форму камня
        System.out.println(gem.getGemForm());
        // узнаём количество параметров камня
        System.out.println(gem.getGemSize().getSizes());
    }
}


