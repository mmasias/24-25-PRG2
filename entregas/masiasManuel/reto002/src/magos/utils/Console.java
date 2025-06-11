package magos.utils;

import java.util.Scanner;

public class Console {

    private static final Console instance = new Console();
    private final Scanner scanner;

    private Console() {
        this.scanner = new Scanner(System.in);
    }

    public static Console getInstance() {
        return instance;
    }

    public void write(String message) {
        System.out.print(message);
    }

    public void writeln(String message) {
        System.out.println(message);
    }

    public String readString(String prompt) {
        this.write(prompt);
        return this.scanner.nextLine();
    }
}
