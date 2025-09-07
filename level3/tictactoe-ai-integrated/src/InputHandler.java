import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc = new Scanner(System.in);

    public static char getUserInput() {
        return sc.next().toUpperCase().charAt(0);
    }
}
