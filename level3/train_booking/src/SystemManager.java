import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SystemManager {
    private static final int totalStations = 5;
    private static final int totalSeats = 8;
    private static final int totalWaitingListSeats = 2;
    private static SystemManager instance;
    protected final Map<Integer, Ticket> bookedTickets;
    protected final Map<Integer, Ticket> cancelledTickets;
    protected final ConcurrentHashMap<Integer, Ticket> waitingListTickets;
    protected final Map<Integer, Integer> partiallyCancelledSeats;
    private final int[] availableSeats;
    private int waitingListSeats;

    private SystemManager() {
        this.bookedTickets = new HashMap<>();
        this.cancelledTickets = new HashMap<>();
        this.waitingListTickets = new ConcurrentHashMap<>();
        this.partiallyCancelledSeats = new HashMap<>();
        this.availableSeats = new int[totalStations];
        Arrays.fill(availableSeats, totalSeats);
        this.waitingListSeats = 0;
    }

    protected static SystemManager getInstance() {
        if (instance == null)
            instance = new SystemManager();
        return instance;
    }

    protected void addToBookedTickets(Ticket ticket) {
        bookedTickets.put(ticket.getPnr(), ticket);
    }

    protected void decreaseAvailableSeats(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            availableSeats[i] -= seats;
        }

    }

    protected boolean checkSeatsAvailability(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            if (availableSeats[i] < seats)
                return false;
        }
        return true;
    }

    protected Ticket getTicket(int pnr) {
        if (bookedTickets.containsKey(pnr))
            return bookedTickets.get(pnr);
        else if (waitingListTickets.containsKey(pnr))
            return waitingListTickets.get(pnr);
        else
            return cancelledTickets.get(pnr);
    }

    protected void increaseAvailableSeats(char source, char destination, int seats) {
        for (int i = source - 'A'; i < destination - 'A'; i++) {
            availableSeats[i] += seats;
        }
    }

    protected void storePartiallyCancelledSeats(int pnr, int seats) {
        partiallyCancelledSeats.merge(pnr, seats, Integer::sum);
    }

    protected void processCancellation(int pnr, Ticket ticket) {
        Integer alreadyCancelledSeats = partiallyCancelledSeats.get(pnr);
        int seatsToAdd = alreadyCancelledSeats != null ? alreadyCancelledSeats : 0;
        ticket.setSeats(ticket.getSeats() + seatsToAdd);
        addToCancelledTickets(pnr, ticket);
    }

    private void addToCancelledTickets(int pnr, Ticket ticket) {
        ticket.setStatus(Status.Canceled);
        cancelledTickets.put(pnr, ticket);
        removeTickets(pnr);
    }

    private void removeTickets(int pnr) {
        bookedTickets.remove(pnr);
        waitingListTickets.remove(pnr);
    }

    protected int getWaitingListSeats() {
        return waitingListSeats;
    }

    protected void setWaitingListSeats(int waitingListSeats) {
        this.waitingListSeats = waitingListSeats;
    }

    protected int getTotalWaitingListSeats() {
        return totalWaitingListSeats;
    }

    protected void printChart() {
        System.out.println("\nTickets Booked:-");
        bookedTickets.values().forEach(System.out::println);

        System.out.println("\nTickets Cancelled:-");
        cancelledTickets.values().forEach(System.out::println);

        System.out.println("\nTickets in Waiting List:-");
        waitingListTickets.values().forEach(System.out::println);

        System.out.println("\nAvailable Seats : " + Arrays.toString(availableSeats));

        System.out.println("\n\t\t\tSEATS BOOKED");
        for (int i = 1; i <= totalSeats; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();
        for (char c = 'A'; c < 'A' + totalStations; c++) {
            System.out.print(c);
            int bookedSeats = totalSeats - availableSeats[c - 'A'];
            for (int i = 0; i < bookedSeats; i++) {
                System.out.print("\t*");
            }
            System.out.println();
        }
        System.out.println();
    }
}
