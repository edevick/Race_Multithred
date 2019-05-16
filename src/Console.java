import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class Console {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Horse> horseList = new ArrayList<>();

    public static List<Horse> getInformationAboutHorses() {
        System.out.println("Enter count of horses...");
        int count = scanner.nextInt();
        Main.START = new CountDownLatch(count + 2);
        for (int i = 1; i <= count; i++) {
            System.out.println("Enter name of horse number " + i);
            Horse horse = new Horse(new Scanner(System.in).nextLine(), i);
            horseList.add(horse);
            new Thread(horse).start();

        }
        return horseList;
    }

    public static void fillInformationAboutPlayersBets() {
        scanner.nextLine();
        for (Horse horse : horseList
        ) {
            System.out.println("Enter player name, who bet to horse number " + horse.getNumber() + " (" + horse
                    .getName() + ").");
            String name = scanner.nextLine();
            while (!name.equals("")) {
                horse.doBet(name);
                name = scanner.nextLine();
            }
        }

    }
}
