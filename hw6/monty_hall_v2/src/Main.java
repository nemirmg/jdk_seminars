import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final int COUNT = 1000;
    private static final int DOORS = 3;
    private static Map<Integer, int[]> result = new HashMap<>();

    private static void getStat() {
        int winsWithChanging = 0;
        int winsNoChanging = 0;
        for (Map.Entry<Integer, int[]> item : result.entrySet()) {
            if (item.getValue()[1] == 0) {
                winsNoChanging += item.getValue()[0];
            } else {
                winsWithChanging += item.getValue()[0];
            }
        }
        int wins = winsWithChanging + winsNoChanging;
        double winsPerc = wins * 1. / COUNT * 100;
        double wwcPerc = winsWithChanging * 1. / wins * 100;
        double wncPerc = winsNoChanging * 1. / wins * 100;
        System.out.println(String.format("\n============\nВсего побед: %d (%.1f%% от всех попыток)", wins, winsPerc));
        System.out.println("в том числе");
        System.out.println(String.format("\tкогда изменил первоначальное решение: %d - %.1f%% от всех побед)", winsWithChanging, wwcPerc));
        System.out.println(String.format("\tкогда не менял первоначальное решение: %d - %.1f%% от всех побед)", winsNoChanging, wncPerc));
    }

    public static void main(String[] args) {
        for (int i = 0; i < COUNT; i++) {
            Game game = new Game(DOORS);
            game.start();
            System.out.println(game);
            result.put(i, game.getResult());
        }

        getStat();
    }
}