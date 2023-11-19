package net.ddns.wakhsavior;

import net.ddns.wakhsavior.repositories.ChatRepositories;
import net.ddns.wakhsavior.service.StartFinishService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
Создать окно клиента чата. Окно должно содержать JtextField для ввода логина, пароля,
IP-адреса сервера, порта подключения к серверу, область ввода сообщений, JTextArea
область просмотра сообщений чата и JButton подключения к серверу и отправки сообщения в чат.
Желательно сразу сгруппировать компоненты, относящиеся к серверу сгруппировать на JPanel
сверху экрана, а компоненты, относящиеся к отправке сообщения – на JPanel снизу
 */
public class Chat extends JFrame{

    private final ChatRepositories chatRepositories;

    private static final int WINDOW_HEIGHT = 600;
    private static final int WINDOW_WIDTH = 700;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnSend = new JButton("Отправить.");
    JLabel lblLogin = new JLabel("Login:");
    JLabel lblPassword = new JLabel("Password:");
    JLabel lblIP = new JLabel("IP:");
    JLabel lblMessage = new JLabel("Сообщение:");
    JTextField txtFieldLogin = new JTextField();
    JTextField txtFieldPassword = new JTextField();
    JTextField txtFieldIP = new JTextField();
    JTextField txtFieldMessage = new JTextField();
    JTextArea areaMessage = new JTextArea();

    JPanel panServer = new JPanel(new GridLayout(6, 2));
    JPanel panClient = new JPanel(new GridLayout(4, 1));
    String login;
    String password;
    String IP;
    String message;
    Chat(ChatRepositories chatRepositories,StartFinishService startFinishService){
        this.chatRepositories = chatRepositories;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                startFinishService.finish();
                super.windowClosing(e);
            }
        });
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("ChatWindow");
        setResizable(false);
        panServer.add(lblLogin);
        panServer.add(txtFieldLogin);
        panServer.add(lblPassword);
        panServer.add(txtFieldPassword);
        panServer.add(lblIP);
        panServer.add(txtFieldIP);
        panClient.add(lblMessage);
        panClient.add(areaMessage);
        panClient.add(txtFieldMessage);
        panClient.add(btnSend);
        for(String s: chatRepositories.getMessages()){
            areaMessage.append(s + "\n");
        }
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             setMessage();
            }
        });
        txtFieldMessage.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                   setMessage();
                }
            }
        });
        setLayout(new GridLayout(2,1));
        add(panServer);
        add(panClient);
        setVisible(true);
    }
    public void setMessage (){
        message = txtFieldLogin.getText() + ": " + txtFieldMessage.getText();
        areaMessage.append(message + "\n");
        chatRepositories.addMessage(message);

    }

    public static void main(String[] args) {
        ChatRepositories chatRepositories1 = new ChatRepositories();
        StartFinishService startFinishService = new StartFinishService(chatRepositories1);
        startFinishService.start();
        new Chat(chatRepositories1,startFinishService);

    }
}
