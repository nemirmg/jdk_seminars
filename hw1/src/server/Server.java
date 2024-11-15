package server;

public class Server {
    private final String SERVER_ON = "Сервер запущен!";
    private final String SERVER_OFF = "Сервер выключен!";
    private boolean working = false;

    public boolean isWorking() {
        return working;
    }

    public void start() {
        working = true;
    }

    public void stop() {
        working = false;
    }

    public String getStatus() {
        return isWorking() ? SERVER_ON : SERVER_OFF;
    }
}
