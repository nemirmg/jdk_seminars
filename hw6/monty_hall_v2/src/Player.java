public class Player {
    private int playerId;

    public Player(int playerId) {
        this.playerId = playerId;
    }

    @Override
    public String toString() {
        return "Игрок " + playerId;
    }
}
