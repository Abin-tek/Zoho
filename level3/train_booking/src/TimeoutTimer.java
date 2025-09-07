public class TimeoutTimer extends Thread {
    private final int maxTime;

    public TimeoutTimer(int maxTime) {
        this.maxTime = minToSec(maxTime);
    }

    @Override
    public void run() {
        int elapsedTime = 0;
        System.out.println("Timer started! enter details in " + secToMin(maxTime) + " minutes...");
        while (elapsedTime < maxTime) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
                System.out.println("Timer stopped...");
                return;
            }
            elapsedTime++;
            if ((elapsedTime % 10) == 0)
                System.out.println("\nRemaining Time: " + (maxTime - elapsedTime));
        }
            System.out.println("Time up...");
    }

    private int minToSec(int maxTime) {
        return maxTime * 60;
    }

    private int secToMin(int maxTime) {
        return maxTime / 60;
    }
}
