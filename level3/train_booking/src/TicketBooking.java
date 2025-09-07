public class TicketBooking {
    private final SystemManager systemManager;
    private final char source;
    private final char destination;
    private final int seats;

    public TicketBooking(char source, char destination, int seats) {
        this.systemManager = SystemManager.getInstance();
        this.source = source;
        this.destination = destination;
        this.seats = seats;
    }

    private void bookTicket() {
        if (systemManager.checkSeatsAvailability(source, destination, seats)) {
            Ticket newTicket = new Ticket(source, destination, seats, Status.Booked);
            systemManager.addToBookedTickets(newTicket);
            Message.send("Ticket Booked! PNR : " + newTicket.getPnr());
            systemManager.decreaseAvailableSeats(source, destination, seats);
        } else if (systemManager.getWaitingListSeats() + seats <= systemManager.getTotalWaitingListSeats()){
            WaitingListManager.getInstance().waitingListEntry(source, destination, seats);
        } else {
            Message.send("No tickets available from " + source + " to " + destination);
        }
    }

    protected void execute() {
        this.bookTicket();
    }
}
