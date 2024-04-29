package com.example.slotsbackend.controllers;

import com.example.slotsbackend.models.Message;
import com.example.slotsbackend.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/messages")
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/saveMessage")
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    @GetMapping("/getMessages")
    public List<Message> getAllMessages() {
        return messageService.getMessages();
    }
}
