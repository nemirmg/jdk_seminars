import java.util.concurrent.CountDownLatch;

public class Philosopher implements Runnable {
    private final int MEAL_NUMBER = 3;
    private final int SLEEP_MIN = 500;
    private final int SLEEP_MAX = 1000;
    private int eatingCount;
    private String name;
    private Fork leftFork;
    private Fork rightFork;
    private CountDownLatch cdl;

    public Philosopher(String name, Fork leftFork, Fork rightFork, CountDownLatch cdl) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.cdl = cdl;
    }

    public void think() {
        try {
            System.out.println(name + " размышляет...");
            Thread.sleep(getRandom(SLEEP_MIN, SLEEP_MAX));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void eat() {
        try {
            System.out.println(++eatingCount + " приём пищи у " + name);
            Thread.sleep(getRandom(SLEEP_MIN, SLEEP_MAX));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private long getRandom(int min, int max) {
        return Math.round(Math.random() * (max - min) + max);
    }

    @Override
    public void run() {
        while (eatingCount < MEAL_NUMBER) {
            think();

            synchronized(leftFork) {
                synchronized(rightFork) {
                    System.out.println(name + " взял вилку " + leftFork.getNumber() + " в левую руку");
                    System.out.println(name + " взял вилку " + rightFork.getNumber() + " в правую руку");

                    eat();

                    System.out.println(name + " положил вилку " + leftFork.getNumber() + " левой рукой");
                    System.out.println(name + " положил вилку " + rightFork.getNumber() + " правой рукой");
                }
            }
        }
        System.out.println(name + " поел!");
        cdl.countDown();
    }
}
