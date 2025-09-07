public class WaitingListManager {
    private static WaitingListManager instance;
    private final SystemManager systemManager;

    private WaitingListManager() {
        this.systemManager = SystemManager.getInstance();
    }

    protected static WaitingListManager getInstance() {
        if (instance == null)
            instance = new WaitingListManager();
        return instance;
    }

    public void waitingListEntry(char source, char destination, int seats) {
        TicketWaiting ticketWaiting = new TicketWaiting(source, destination, seats);
        ticketWaiting.execute();
    }

    public void waitingListRemoval(int pnr, int seatsToCancel, Ticket ticket) {
        int bookedSeats = ticket.getSeats();

        if (bookedSeats > seatsToCancel) {
            ticket.setSeats(bookedSeats - seatsToCancel);
            Message.send("Partially cancelled ticket in WL with PNR: " + pnr);
        } else {
            systemManager.waitingListTickets.remove(pnr);
            Message.send("Cancelled ticket in WL with PNR: " + pnr);
        }

        systemManager.setWaitingListSeats(systemManager.getWaitingListSeats() - seatsToCancel);
    }

    public void processWaitingList() {
        for (Ticket ticketInWaitingList : systemManager.waitingListTickets.values()) {
            char source = ticketInWaitingList.getSource();
            char destination = ticketInWaitingList.getDestination();
            int seats = ticketInWaitingList.getSeats();

            if (systemManager.checkSeatsAvailability(source, destination, seats)) {
                systemManager.decreaseAvailableSeats(source, destination, seats);
                systemManager.setWaitingListSeats(systemManager.getWaitingListSeats() - seats);
                updateTicketToBookingList(ticketInWaitingList);
            }
        }
    }

    private void updateTicketToBookingList(Ticket ticketInWaitingList) {
        int pnr = ticketInWaitingList.getPnr();
        ticketInWaitingList.setStatus(Status.Booked);
        systemManager.addToBookedTickets(ticketInWaitingList);
        systemManager.waitingListTickets.remove(pnr);
        Message.send("Booking Confirmed from WL! PNR: " + pnr);
    }
}
