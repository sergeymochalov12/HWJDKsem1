package net.ddns.wakhsavior.repositories;

import java.util.ArrayList;
import java.util.List;

public class ChatRepositories {
   private List<String> messages;

    public ChatRepositories() {
        this.messages = new ArrayList<>();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessagesMessages(List<String> messages) {
        this.messages = messages;
    }

    public void addMessage (String message){
        messages.add(message);
    }
}
