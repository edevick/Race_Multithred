import java.util.concurrent.CountDownLatch;

public class Main {
    public static CountDownLatch START = new CountDownLatch(1000);
    static final int trackLength = 1000;
    static Horse horseWin = null;

    public static void main(String[] args) throws InterruptedException {
        Console.getInformationAboutHorses();
        System.out.println("Start the game!");
        Console.fillInformationAboutPlayersBets();
        Thread.sleep(1000);
        START.countDown();

        System.out.println("GO!!!");
        START.countDown();


        while (horseWin == null) {
            Thread.sleep(500);
        }

        System.out.print("Players, who won: ");
        for (String player : horseWin.getPlayers()) {
            System.out.println(player);
        }


    }
}
