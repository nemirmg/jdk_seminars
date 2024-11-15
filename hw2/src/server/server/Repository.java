package server.server;

public interface Repository {
    void save(String text);
    String load();
}
