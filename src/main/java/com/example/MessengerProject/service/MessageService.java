package com.example.MessengerProject.service;

import com.example.MessengerProject.DatabaseClass;
import com.example.MessengerProject.models.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageService {

    Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1L, "Hello World", "Hung"));
        messages.put(2L, new Message(2L, "Hello Jersey", "Hung"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public Message getMessage(Long id) {
        if (messages.containsKey(id)) {
            return messages.get(id);
        }
        else return null;
    }

    public Message addMessage(Message message) {
        if (message != null) {
            messages.put(message.getId(), message);
        }
        return message;
    }

    public Message updateMessage(Message message) {
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(Long id) {
        if (messages.containsKey(id)) {
           return messages.remove(id);
        }
        return null;
    }
}
