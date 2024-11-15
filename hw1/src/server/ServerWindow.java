package server;

import client.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServerWindow extends JFrame {
    private final String BUTTON_START = "Start";
    private final String BUTTON_STOP = "Stop";

    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private JButton btnStart = new JButton(BUTTON_START);
    private JButton btnStop = new JButton(BUTTON_STOP);
    private JTextArea log = new JTextArea();

    private Server server = new Server();
    private ActiveClients activeClients = new ActiveClients(server);
    private ChatLogger chatLogger = new ChatLogger();

    public ServerWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Chat server");

        add(createTextArea());
        add(createBottomPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JScrollPane createTextArea() {
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel(new GridLayout(1, 2));

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!server.isWorking()) {
                    server.start();
                }
                appendToLog(server.getStatus());
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (server.isWorking()) {
                    disconnectAllClients();
                    server.stop();
                }
                appendToLog(server.getStatus());
            }
        });

        bottomPanel.add(btnStart);
        bottomPanel.add(btnStop);

        return bottomPanel;
    }

    public boolean connectClient(ClientGUI clientGUI){
        return activeClients.add(clientGUI);
    }

    public boolean isClientConnected(ClientGUI clientGUI){
        return activeClients.isInList(clientGUI);
    }

    public void disconnectClient(ClientGUI clientGUI){
        activeClients.remove(clientGUI);
    }

    public void disconnectAllClients(){
        activeClients.removeAll();
    }

    public void appendToLog(String text) {
        log.append(text + "\n");
    }

    public void message(String text){
        if (!server.isWorking()) {
            return;
        }
        text += "";
        appendToLog(text);
        answerAll(text);
        saveChatToFile(text);
    }

    private void answerAll(String text){
        for (ClientGUI client: activeClients){
            client.answer(text);
        }
    }

    public String getLog() {
        return loadChatFromFile();
    }

    private void saveChatToFile(String text) {
        chatLogger.saveChatToFile(text);
    }

    private String loadChatFromFile() {
        return chatLogger.loadChatFromFile();
    }
}