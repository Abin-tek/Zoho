
public class Operator {
    private final inputHandler inputHandler;
    private TimeoutTimer timer;

    public Operator() {
        this.inputHandler = new inputHandler();
    }

    protected void start() {
        while (true) {
            int option = inputHandler.getOption();
            switch (option) {
                case 1 -> {
                    startTimer();

                    String[] details = inputHandler.getBookingDetails().split("\\.");

                    if (!timer.isAlive()) {
                        Message.send("Booking Terminated: Time expired...");
                        continue;
                    } else {
                        killThread(timer);
                    }

                    char source = details[0].charAt(0);
                    char destination = details[1].charAt(0);
                    int seats = Integer.parseInt(details[2]);
                    TicketBooking ticketBooking = new TicketBooking(source, destination, seats);
                    ticketBooking.execute();

                }
                case 2 -> {
                    startTimer();

                    String[] details = inputHandler.getCancellingDetails().split("\\.");

                    if (!timer.isAlive()) {
                        Message.send("Canceling Terminated: Time expired...");
                        continue;
                    } else {
                        killThread(timer);
                    }

                    int pnr = Integer.parseInt(details[0]);
                    int seats = Integer.parseInt(details[1]);
                    TicketCancelling ticketCancelling = new TicketCancelling(pnr, seats);
                    ticketCancelling.execute();
                }
                case 3 -> SystemManager.getInstance().printChart();
                case 4 -> {
                    Message.send("Thank you! Happy Journey...");
                    return;
                }
                default -> Message.send("Option not found! try again..");
            }
        }
    }

    private void startTimer() {
        timer = new TimeoutTimer(1);
        timer.start();
        Delay.by100Ms();
    }

    private static void killThread(TimeoutTimer cancelingTimer) {
        cancelingTimer.interrupt();
        try {
            cancelingTimer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
