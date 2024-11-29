import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    
    private static Random random = new Random();
    private static Map<Integer,Boolean> results = new HashMap<>();
    private static int count = 3;
    
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            game(i);
        }

        int win = 0;
        for (Map.Entry<Integer, Boolean> entry: results.entrySet()){
            if (entry.getValue()){
                win++;
            }
        }
        
        System.out.println("Количество побед игрока = " + win);
    }

    private static void game(int num) {
        int winning = random.nextInt(count);
        int firstDoor = random.nextInt(count);
        int emptyDoor = -1;
        int secondDoor = -1;

        for (int i = 0; i <count; i++) {
            if (i != winning && i != firstDoor){
               emptyDoor = i;
            }
        }

        for (int i = 0; i < count; i++) {
            if (i != emptyDoor && i != firstDoor){
               secondDoor = i;
            }
        }

        results.put(num, winning == secondDoor);
    }
}
