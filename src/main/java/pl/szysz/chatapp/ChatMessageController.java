package pl.szysz.chatapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class ChatMessageController {

    // dostep do protokolu STOMP odbywa sie przez Endpoint "/chat"
    @MessageMapping("/chat")
    // gdzie to ma byc zapisane
    // messages - nazwa kolejki
    @SendTo("/topic/messages")
    // do tej metody javaScript bedzie ladowal wiadomosc
    public ChatMessage get(ChatMessage chatMessage){
        return chatMessage;
    }
}