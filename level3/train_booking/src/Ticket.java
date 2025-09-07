public class Ticket {
    private static int pnrGenerator=0;
    private final int pnr;
    private final char source;
    private final char destination;
    private int seats;
    private Status status;

    public Ticket(char source, char destination, int seats, Status status) {
        this.pnr = ++pnrGenerator;
        this.source = source;
        this.destination = destination;
        this.seats = seats;
        this.status = status;

    }

    public int getPnr() {
        return pnr;
    }

    public char getSource() {
        return source;
    }

    public char getDestination() {
        return destination;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PNR " + pnr +
                ", " + source +
                " to " + destination +
                ", Seat Nos: " + seats +
                ", " + status;
    }
}
