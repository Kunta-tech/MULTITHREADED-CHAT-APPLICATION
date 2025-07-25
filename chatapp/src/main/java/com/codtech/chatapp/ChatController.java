package com.codtech.chatapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Controller
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final List<ChatMessage> chatHistory = new CopyOnWriteArrayList<>();

    public ChatController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }
    public List<ChatMessage> getChatHistory() {
        return chatHistory;
    }

    @MessageMapping("/chat") // receives message from client
    public void receiveMessage(ChatMessage message) {
        message.setTime(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        chatHistory.add(message);
        messagingTemplate.convertAndSend("/topic/messages", message); // broadcast to all
    }
}
