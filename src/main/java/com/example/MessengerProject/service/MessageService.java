package com.example.MessengerProject.service;

import com.example.MessengerProject.DatabaseClass;
import com.example.MessengerProject.models.Message;

import java.util.*;

public class MessageService {
    public static MessageService instance;
    Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        System.out.println("created");
        messages.put(1L, new Message(1L, "Hello World", "Hung"));
        messages.put(2L, new Message(2L, "Hello Jersey", "Hung"));
    }

    public static MessageService getInstance() {
        if (instance == null) {
            instance = new MessageService();
        }
        return instance;
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year) {
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Message message : messages.values()) {
            cal.setTime(message.getCreated());
            if (cal.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }
        }
        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {
        start--;
        List<Message> list = new ArrayList<>(messages.values());
        if (start + size > list.size()) return new ArrayList<>();
        return list.subList(start, start + size);
    }

    public Message getMessage(Long id) {
        if (messages.containsKey(id)) {
            return messages.get(id);
        }
        return null;
    }

    public Message addMessage(Message message) {
        int index = messages.size();
        index++;
        message.setId(index);
        messages.put((long) index, message);
        return message;
    }

    public Message updateMessage(Message message) {
        messages.replace(message.getId(), message);
        return message;
    }

    public Message removeMessage(Long id) {
        if (messages.containsKey(id)) {
            return messages.remove(id);
        }
        return null;
    }
}
