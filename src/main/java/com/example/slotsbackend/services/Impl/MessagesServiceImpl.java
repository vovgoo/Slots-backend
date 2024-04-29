package com.example.slotsbackend.services.Impl;

import com.example.slotsbackend.models.Message;
import com.example.slotsbackend.repository.MessageRepository;
import com.example.slotsbackend.services.MessageService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class MessagesServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    private final JedisPool jedisPool;

    private final ObjectMapper objectMapper;

    @Override
    public List<Message> getMessages() {
        try (Jedis jedis = jedisPool.getResource()) {
            String raw = jedis.get("messages");
            if(raw != null) {
                return objectMapper.readValue(raw, new TypeReference<>() {});
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        List<Message> messages = messageRepository.findAll();

        try (Jedis jedis = jedisPool.getResource()) {
            String json = objectMapper.writeValueAsString(messages);
            jedis.setex("messages", 120, json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return messages;
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
