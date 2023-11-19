package net.ddns.wakhsavior;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
Создать простейшее окно управления сервером (по сути, любым), содержащее две кнопки
(JButton) – запустить сервер и остановить сервер. Кнопки должны просто логировать нажатие
(имитировать запуск и остановку сервера, соответственно) и выставлять внутри интерфейса
соответствующее булево isServerWorking.
 */
public class ServerRun extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("Start Server");
    JButton btnStop = new JButton("Stop Server");
    JPanel panel = new JPanel();
    JTextArea textArea = new JTextArea();
    boolean isServerWorking;

    ServerRun() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("TicTacToe");
        setResizable(false);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!isServerWorking) {
                    isServerWorking = true;
                }
                textArea.setText("Статус сервера: " + isServerWorking);
                System.out.println("Статус сервера: " + isServerWorking);
            }
        });
        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    isServerWorking = false;
                }
                textArea.setText("Статус сервера: " + isServerWorking);
                System.out.println("Статус сервера: " + isServerWorking);
            }
        });
        setLayout(new GridLayout(2, 2));
        add(btnStart);
        add(btnStop);
        add(panel);
        panel.add(textArea);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ServerRun();
    }
}
