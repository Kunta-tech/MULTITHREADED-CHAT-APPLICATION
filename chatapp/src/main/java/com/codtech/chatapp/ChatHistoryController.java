package com.codtech.chatapp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatHistoryController {
    private final ChatController chatController;

    public ChatHistoryController(ChatController chatController) {
        this.chatController = chatController;
    }

    @GetMapping("/history")
    public List<ChatMessage> getChatHistory() {
        return chatController.getChatHistory();
    }
}
