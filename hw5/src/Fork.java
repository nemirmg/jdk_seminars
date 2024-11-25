public class Fork {
    private static int id;
    private int number;

    public Fork() {
        setNumber();
    }

    private void setNumber() {
        number = ++id;
    }

    public int getNumber() {
        return number;
    }
}