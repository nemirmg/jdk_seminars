import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) {
        String[] phils = {"Платон", "Сократ", "Аристотель", "Демокрит", "Пифагор"};
        int size = phils.length;
        CountDownLatch cdl = new CountDownLatch(size);
        
        Fork[] forks = new Fork[size];
        for (int i = 0; i < size; i++) {
            forks[i] = new Fork();
        }
                
        Philosopher[] philosophers = new Philosopher[size];
        for (int i = 0; i < size; i++) {
            philosophers[i] = new Philosopher(phils[i], forks[i], forks[(i + 1) % size], cdl);
            new Thread(philosophers[i]).start();
        }

        try {
            cdl.await();
            System.out.println("Все философы поели!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
