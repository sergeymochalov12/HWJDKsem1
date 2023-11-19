package net.ddns.wakhsavior.repositories;

import java.util.ArrayList;
import java.util.List;

public class ChatRepositories {
   private final List<String> messages;

    public ChatRepositories() {
        this.messages = new ArrayList<>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addMessage (String message){
        messages.add(message);
    }
}
