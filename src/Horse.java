import java.util.ArrayList;
import java.util.List;

public class Horse implements Runnable {

    private String name;
    private int number;
    private List<String> players;

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public Horse(String name, int number) {
        this.name = name;
        this.number = number;
        players = new ArrayList<>();
    }

    public List<String> getPlayers() {
        return players;
    }

    public void doBet(String whoBet) {
        players.add(whoBet);
    }

    @Override
    public void run() {
        System.out.println("Horse #" + number + " (" + name + ") " + "come to start.");
        Main.START.countDown();
        int lengthToRun = Main.trackLength;
        long dist = (long) Math.random() * 20 + 30;
        long rest = (long) Math.random() * 100 + 300;
        long curDist = dist;
        int currentPosition = 0;
        try {
            Main.START.await();
            while (lengthToRun > 0) {
                currentPosition++;
                if (curDist == 0) {
                    Thread.sleep(rest);
                    curDist = dist;
                }
                curDist--;
                lengthToRun--;
                System.out.println(name + " " + currentPosition + "/1000");
                if (lengthToRun == 0) {
                    Main.horseWin = this;
                    System.out.println(name + ": FINISH");
                }

            }

        } catch (InterruptedException ex) {
            System.out.println(ex.getStackTrace());
        }

    }
}
