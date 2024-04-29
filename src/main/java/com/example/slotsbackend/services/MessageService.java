package com.example.slotsbackend.services;

import com.example.slotsbackend.models.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface MessageService {

    List<Message> getMessages();

    ResponseEntity<Message> saveMessage(Message message);

}
