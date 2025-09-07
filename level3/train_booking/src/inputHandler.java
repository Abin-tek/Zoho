import java.util.InputMismatchException;
import java.util.Scanner;

public class inputHandler {
    private final Scanner sc;

    public inputHandler() {
        this.sc = new Scanner(System.in);
    }

    protected int getOption() {
        Menu menu = Menu.getInstance();
        menu.listMenu();
        System.out.print("Choose any one: ");
        return numberInput();
    }

    private int numberInput() {
        while (true) { // Keep looping until a valid number is entered
            try {
                int num = sc.nextInt();
                if (notValid(num))
                    throw new InputMismatchException();
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                sc.nextLine(); // Clear the invalid token
            }
        }
    }

    private char sourceStationInput() {
        while (true) {
            try {
                char station = sc.next().toUpperCase().charAt(0);
                if (station < 'A' || station > 'D')
                    throw new InputMismatchException();
                return station;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid station");
            }
        }
    }

    private char destinationStationInput(char source) {
        while (true) {
            try {
                char station = sc.next().toUpperCase().charAt(0);
                if (station < 'B' || station > 'E' || station == source)
                    throw new InputMismatchException();
                return station;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid station");
            }
        }
    }

    public String getBookingDetails() {
        System.out.print("Enter Source: ");
        char source = sourceStationInput();
        System.out.print("Enter Destination: ");
        char destination = destinationStationInput(source);
        System.out.print("Enter Seats: ");
        int seats = numberInput();

        return source + "." + destination + "." + seats;
    }

    protected String getCancellingDetails() {
        System.out.print("Enter Ticket ID (PNR): ");
        int pnr = numberInput();
        System.out.print("Enter Seats: ");
        int seats = numberInput();

        return pnr + "." + seats;
    }

    private boolean notValid(int num) {
        return num <= 0;
    }
}
