package com.codtech.chatapp;
import lombok.Data;

@Data
public class ChatMessage {
    private String sender;
    private String content;
    private String time;
}
