public class Door implements Comparable<Door> {
    private int doorNumber;
    private boolean prize = false;
    private Boolean opened = false;

    public Door(int doorNumber) {
        this.doorNumber = doorNumber;;
    }

    public int getNumber() {
        return doorNumber;
    }

    public boolean isPrize() {
        return prize;
    }

    public void setPrize(boolean prize) {
        this.prize = prize;
    }

    public Boolean isOpened() {
        return opened;
    }

    public void setOpened(Boolean opened) {
        this.opened = opened;
    }

    @Override
    public String toString() {
        return "Дверь " + doorNumber;
        // return "[Приз: " + prize + ", Открыта: " + opened + "]";
    }

    @Override
    public int compareTo(Door o) {
        return this.opened.compareTo(o.opened);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Door door = (Door) o;
        if (doorNumber != door.doorNumber) return false;
        if (prize != door.prize) return false;
        return opened == door.opened;
    }

    @Override
    public int hashCode() {
        int total = 31;
        total = total * 31 + doorNumber;
        total = total * 31 + (prize ? 1 : 0);
        total = total * 31 + (opened ? 1 : 0);
        return total;
    }

    
}
