package net.ddns.wakhsavior.service;

import net.ddns.wakhsavior.repositories.ChatRepositories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StartFinishService {

    private final ChatRepositories chatRepositories;

    public StartFinishService(ChatRepositories chatRepositories) {
        this.chatRepositories = chatRepositories;
    }

    public void finish() {
        File file = new File("saveChat.txt");
        try (FileWriter fileWriter = new FileWriter(file)) {
            for (String s : chatRepositories.getMessages()) {
                fileWriter.write(" " +s + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }


    public void start() {
        int count = 0;
        int MAX_MESSAGE = 100;
        try (FileReader fileReader = new FileReader("saveChat.txt")) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while (bufferedReader.read() != -1 && count < MAX_MESSAGE) {
                chatRepositories.addMessage(bufferedReader.readLine());
                count++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
