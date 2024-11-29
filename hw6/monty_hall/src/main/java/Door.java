public class Door {
    private boolean prize = false;
    private boolean opened = false;

    public boolean isPrize() {
        return prize;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }

    public boolean isOpened() {
        return opened;
    }

    public void setOpened(boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return "[prize: " + prize + ", opened: " + opened + "]";
    }
}
