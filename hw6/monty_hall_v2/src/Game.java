import java.util.ArrayList;
import java.util.List;

public class Game {
    private static int id = 0;
    private int gameNumber;
    private Studio studio;
    private int attempts;
    private Door prizeDoor;
    private List<Door> playerChoices = new ArrayList<>();
    private List<Door> openedDoors = new ArrayList<>();

    public Game(int doors) {
        this.studio = new Studio(doors);
        this.attempts = doors - 1;
        setGameNumber();
        setPrizeDoor();
        // System.out.println(studio.getDoors());
    }

    private void setGameNumber() {
        gameNumber = ++id;
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            Round round = new Round(studio, i + 1, i == attempts - 1);
            round.play();
            playerChoices.add(round.getPlayerChoice());
            openedDoors.add(round.getOpenedDoor());
        }
    }

    private void setPrizeDoor() {
        prizeDoor = studio.getDoors().getPrizeDoor();
    }

    public int[] getResult() {
        /*
        первый элемент:
            1 - победа (угадал, где приз)
            0 - поражение
        второй элемент:
            1 - изменил решение
            0 - не менял решение
        */
        int[] res = new int[2];
        res[0] = prizeDoor.equals(playerChoices.getLast()) ? 1 : 0;
        res[1] = playerChoices.getLast().equals(playerChoices.getFirst()) ? 0 : 1;
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(
            String.format("\nИгра %d (приз - %s)", gameNumber, prizeDoor)
        );
        for (int i = 0; i < attempts; i++) {
            sb.append(String.format("\nРаунд %d:", i + 1));
            sb.append(String.format("\n\tвыбрана - %s", playerChoices.get(i)));
            sb.append(String.format("\n\tоткрыта - %s", openedDoors.get(i)));
        }
        return sb.toString();
    }

    
}
