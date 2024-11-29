import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Studio {
    private List<Door> doors;
    private int variants;
    private int prizes;
    private HashSet<Integer> winNums = new HashSet<>();
    public Studio(int variants, int prizes) {
        this.variants = variants;
        this.prizes = prizes;
        setDoors();
    }

    private void setWinNums() {
        while (winNums.size() < prizes) {
            int random = getRandom();
            winNums.add(random);
        }
    }

    private int getRandom() {
        return new Random().nextInt(variants);
    }

    private void setDoors() {
        this.doors = new ArrayList<Door>();
        for (int i = 0; i < variants; i++) {
            doors.add(new Door());
        }
        setWinNums();
        for (Integer num : winNums) {
            doors.get(num).setPrize(true);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Студия:");
        for (int i = 0; i < doors.size(); i++) {
            sb.append("\n\tдверь " + i + " " + doors.get(i).toString());
        }
        return sb.toString();
    }
}
