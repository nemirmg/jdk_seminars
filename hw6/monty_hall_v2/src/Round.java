public class Round {
    private int roundId;
    private boolean finalRound;
    private Door playerChoice;
    private Door openedDoor;
    private Doors doors;

    public Round(Studio studio, int roundId, boolean finalRound) {
        this.roundId = roundId;
        this.finalRound = finalRound;
        this.doors = studio.getDoors();
    }

    private Door getRandomDoor() {
        return doors.getRandomClosed();
    }

    private void setPlayerChoice() {
        playerChoice = getRandomDoor();
    }

    private void openDoor() {
        if (!finalRound) {
            openedDoor = doors.getRandomClosed(playerChoice);
        } else {
            openedDoor = doors.getFinalClosedDoor(playerChoice);
        }
        openedDoor.setOpened(true);
    }

    public Door getOpenedDoor() {
        return openedDoor;
    }

    public Door getPlayerChoice() {
        return playerChoice;
    }

    public void play() {
        setPlayerChoice();
        openDoor();
    }

    @Override
    public String toString() {
        return "Раунд " + roundId;
    }

    
}
