package server;

import client.ClientGUI;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ActiveClients implements Iterable<ClientGUI> {
    private List<ClientGUI> activeClients = new ArrayList<>();
    private Server server;

    public ActiveClients(Server server) {
        this.server = server;
    }

    public boolean add(ClientGUI c) {
        if (server.isWorking()) {
            activeClients.add(c);
            return true;
        } else {
            return false;
        }
    }

    public boolean isInList(ClientGUI c) {
        return activeClients.contains(c);
    }

    public void remove(ClientGUI c){
        activeClients.remove(c);
        if (c != null){
            c.disconnectFromServer();
        }
    }

    public void removeAll(){
//        activeClients.clear();
        while (!activeClients.isEmpty()){
            remove(activeClients.get(activeClients.size()-1));
        }
    }

    @Override
    public Iterator<ClientGUI> iterator() {
        return activeClients.iterator();
    }
}
