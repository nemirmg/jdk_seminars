package client;

import server.ServerWindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

public class ClientGUI extends JFrame {
    private final String BUTTON_SEND = "Send";
    private final String CONNECTED = "Вы успешно подключились!\n";
    private final String CONNECTION_FAILED = "Подключение не удалось!";
    private final String DISCONNECTED = "Вы были отключены от сервера!";

    public static final int WIDTH = 400;
    public static final int HEIGHT = 300;

    private ServerWindow serverWindow;
    private String login;

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("8189");
    private final JTextField tfLogin = new JTextField("ivan_igorevich");
    private final JPasswordField password = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("login");

    private final JTextArea log = new JTextArea();

    private final JPanel pannelBottom = new JPanel(new BorderLayout());
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton(BUTTON_SEND);


    public ClientGUI(ServerWindow serverWindow){
        this.serverWindow = serverWindow;

        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Chat client");
//        setLocation(serverWindow.getX() - 500, serverWindow.getY());
        setLocationRelativeTo(serverWindow);

        add(createTopPanel(), BorderLayout.NORTH);
        add(createTextArea());
        add(createBottomPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createTopPanel(){
        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(new JPanel());
        panelTop.add(tfLogin);
        panelTop.add(password);
        panelTop.add(btnLogin);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connectToServer();
            }
        });

        return panelTop;
    }

    private JScrollPane createTextArea(){
        log.setEditable(false);
        return new JScrollPane(log);
    }

    private Component createBottomPanel() {
        pannelBottom.add(tfMessage);
        pannelBottom.add(btnSend, BorderLayout.EAST);

        tfMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n'){
                    message();
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message();
            }
        });

        return pannelBottom;
    }

    public void answer(String text){
        appendToLog(text);
    }

    private void connectToServer() {
        if (serverWindow.connectClient(this)){
            appendToLog(CONNECTED);
            panelTop.setVisible(false);
            login = tfLogin.getText();
            String log = serverWindow.getLog();
            if (log != null){
                appendToLog(log);
            }
        } else {
            appendToLog(CONNECTION_FAILED);
        }
    }

    public void disconnectFromServer() {
        if (connected()) {
            serverWindow.disconnectClient(this);
        } else {
            panelTop.setVisible(true);
            appendToLog(DISCONNECTED);
        }
    }

    public void message(){
        if (connected()){
            String text = tfMessage.getText();
            if (!text.isEmpty()){
                serverWindow.message(login + ": " + text);
                tfMessage.setText("");
            }
        } else {
            appendToLog("Нет подключения к серверу");
        }

    }

    private void appendToLog(String text){
        log.append(text + "\n");
    }



    @Override
    protected void processWindowEvent(WindowEvent e) {
        if (e.getID() == WindowEvent.WINDOW_CLOSING){
            disconnectFromServer();
        }
        super.processWindowEvent(e);
    }

    private boolean connected() {
        return serverWindow.isClientConnected(this);
    }
}