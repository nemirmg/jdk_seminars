import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Doors {
    private Door[] doors;
    private Door prizeDoor;
    private Random r = new Random();

    public Doors(int doors) {
        this.doors = new Door[doors];
    }

    public void setDoors() {
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door(i + 1);
        }
    }

    public void putPrize(int winNum) {
        prizeDoor = doors[winNum];
        prizeDoor.setPrize(true);
    }

    public Door getPrizeDoor() {
        return prizeDoor;
    }
    
    private Door[] getClosed() {
        List<Door> closed = new ArrayList<>();
        for (Door door : doors) {
            if (!door.isOpened()) {
                closed.add(door);
            }
        }
        return closed.toArray(new Door[0]);
    }

    public Door getFinalClosedDoor(Door playerChoice) {
        Door[] closeDoors = getClosed();
        for (Door door : closeDoors) {
            if (!door.equals(playerChoice)) return door;
        }
        return null;
    }

    public Door getRandomClosed() {
        Door[] closeDoors = getClosed();
        if (closeDoors.length != 0) {
            int random = r.nextInt(closeDoors.length);
            return closeDoors[random];
        } else {
            return null;
        }
    }

    public Door getRandomClosed(Door door) {
        Door[] closeDoors = getClosed();
        if (closeDoors.length != 0) {
            List<Door> readyToOpen = new ArrayList<>();
            for (int i = 0; i < closeDoors.length; i++) {
                if (!closeDoors[i].equals(door) && !closeDoors[i].equals(prizeDoor)) {
                    readyToOpen.add(closeDoors[i]);
                }
            }
            closeDoors = readyToOpen.toArray(new Door[0]);
            int random = r.nextInt(closeDoors.length);
            return closeDoors[random];
        } else {
            return null;
        }
    }
        
    public Door get(int index) {
        return doors[index];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Door door : doors) {
            sb.append(String.format("\n\tДверь %d %s", door.getNumber(), door.toString()));
        }
        return sb.toString();
    }

    
}
