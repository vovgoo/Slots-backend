package com.example.slotsbackend.services.Impl;

import com.example.slotsbackend.models.Message;
import com.example.slotsbackend.repository.MessageRepository;
import com.example.slotsbackend.services.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class MessagesServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    @Override
    public List<Message> getMessages() {
        return messageRepository.findAll();
    }

    @Override
    public ResponseEntity<Message> saveMessage(Message message) {
        try {
            Message savedMessage = messageRepository.save(message);

            return ResponseEntity.ok(savedMessage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
