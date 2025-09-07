public class TicketWaiting {
    private final SystemManager systemManager;
    private final char source;
    private final char destination;
    private final int seats;

    public TicketWaiting(char source, char destination, int seats) {
        this.systemManager = SystemManager.getInstance();
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    private void addToWaitingList() {
        Ticket newTicket = new Ticket(source, destination, seats, Status.WaitingList);
        int pnr = newTicket.getPnr();
        systemManager.waitingListTickets.put(pnr, newTicket);
        systemManager.setWaitingListSeats(systemManager.getWaitingListSeats() + seats);

        Message.send("Added to Waiting List! PNR: " + pnr);
    }

    public void execute() {
        this.addToWaitingList();
    }
}
