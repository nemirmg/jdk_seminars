import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Studio studio = new Studio(3, 1);
        System.out.println(studio);
    }

    //    static Random random;
//    static Map<Integer,Boolean> results;
//    static int count;
//
//    public static void main(String[] args) {
//
//        random = new Random();
//        results = new HashMap<>();
//        count = 3;
//
//
//        for (int i = 0; i < 1000; i++) {
//            game(i);
//        }
//
//
//        int vic = 0;
//        for (Map.Entry<Integer, Boolean> entry: results.entrySet()){
//            if (entry.getValue()){
//                vic++;
//            }
//        }
//        System.out.println("Количество побед игрока = " + vic);
//    }
//
//    private static void game(int num) {
//        int winning = random.nextInt(count);
//        int firstDoor = random.nextInt(count);
//        int emptyDoor = -1;
//        int secondDoor = -1;
//
//
//        for (int i = 0; i <count; i++) {
//            if (i != winning && i != firstDoor){
//                emptyDoor = i;
//            }
//        }
//
//
//        for (int i = 0; i < count; i++) {
//            if (i != emptyDoor && i != firstDoor){
//                secondDoor = i;
//            }
//        }
//
//        results.put(num, winning == secondDoor);
//    }
}
