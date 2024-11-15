package server.server;

import java.util.ArrayList;
import java.util.List;

import server.client.ClientController;
import server.client.ClientView;

public class ServerController {
    private boolean work;
    private ServerView serverView;
    private ClientView clientView;
    private Repository repository = new FileStorage();
    private List<ClientController> clientList = new ArrayList<>();

    public void setServerView(ServerView serverView) {
        this.serverView = serverView;
    }

    public void setClientView(ClientView clientView) {
        this.clientView = clientView;
    }

    public boolean connectUser(ClientController clientController){
        if (!work){
            return false;
        }
        clientList.add(clientController);
        return true;
    }

    public void disconnectUser(ClientController clientController){
        clientList.remove(clientController);
        if (clientController != null){
            clientController.disconnectedFromServer();
        }
    }

    public void startServer(){
        if (work){
            appendLog("Сервер уже был запущен");
        } else {
            work = true;
            appendLog("Сервер запущен!");
        }
    }

    public void stopServer(){
        if (!work){
            appendLog("Сервер уже был остановлен");
        } else {
            work = false;
            while (!clientList.isEmpty()){
                disconnectUser(clientList.get(clientList.size() - 1));
            }
            appendLog("Сервер остановлен!");
        }
    }
    
    public void message(String text){
        if (!work){
            return;
        }
        appendLog(text);
        answerAll(text);
        saveInLog(text);
    }

    private void appendLog(String text){
        serverView.showMessage(text + "\n");
    }

    private void answerAll(String text){
        for (ClientController clientController: clientList){
            clientController.answerFromServer(text);
        }
    }

    public String getHistory() {
        return repository.load();
    }
    
    private void saveInLog(String text) {
        repository.save(text);
    }
}
