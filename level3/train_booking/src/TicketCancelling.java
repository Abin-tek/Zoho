public class TicketCancelling {
    private final SystemManager systemManager;
    private final int pnr;
    private final int seatsToCancel;

    public TicketCancelling(int pnr, int seatsToCancel) {
        this.systemManager = SystemManager.getInstance();
        this.pnr = pnr;
        this.seatsToCancel = seatsToCancel;
    }

    private void cancelTicket() {
        Ticket ticket = systemManager.getTicket(pnr);
        WaitingListManager waitingListManager = WaitingListManager.getInstance();
        if (ticket == null) {
            Message.send("Ticket with PNR " + pnr + " not found!");
        } else if (ticket.getStatus() == Status.Canceled) {
            Message.send("Ticket with PNR " + pnr + " already cancelled");
        } else if (ticket.getStatus() == Status.WaitingList) {
            waitingListManager.waitingListRemoval(pnr, seatsToCancel, ticket);
        } else if (ticket.getSeats() < seatsToCancel) {
            Message.send("Cannot cancel " + seatsToCancel + " seats!");
        } else {
            int bookedSeats = ticket.getSeats();
            char source = ticket.getSource();
            char destination = ticket.getDestination();

            if (bookedSeats > seatsToCancel) {
                ticket.setSeats(bookedSeats - seatsToCancel);
                systemManager.storePartiallyCancelledSeats(pnr, seatsToCancel);
                Message.send("Partially Cancelled Ticket! PNR: " + pnr);
            } else if (bookedSeats == seatsToCancel) {
                systemManager.processCancellation(pnr, ticket);
                Message.send("Cancelled Ticket! PNR: " + pnr);
            }

            systemManager.increaseAvailableSeats(source, destination, seatsToCancel);
            waitingListManager.processWaitingList();
        }
    }

    protected void execute() {
        this.cancelTicket();
    }
}
