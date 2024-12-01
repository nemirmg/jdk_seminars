import java.util.Random;

public class Studio {
    private Doors doors;
    private int variants;
    
    public Studio(int variants) {
        this.variants = variants;
        createDoors();
    }

    private int getWinNum() {
        return new Random().nextInt(variants);
    }

    private void createDoors() {
        doors = new Doors(variants);
        doors.setDoors();
        doors.putPrize(getWinNum());
    }

    public Doors getDoors() {
        return doors;
    }

    @Override
    public String toString() {
        return "Студия:" + doors.toString();
    }
}
