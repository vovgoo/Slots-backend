package com.example.slotsbackend.services.Impl;

import com.example.slotsbackend.models.Slot;
import com.example.slotsbackend.repository.SlotRepository;
import com.example.slotsbackend.services.SlotsService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
@AllArgsConstructor
@Primary
public class SlotsServiceImpl implements SlotsService {

    private final SlotRepository slotRepository;

    private final JedisPool jedisPool;

    private final ObjectMapper objectMapper;

    @Override
    public List<Slot> findAllSlots() {
        try (Jedis jedis = jedisPool.getResource()) {
            String raw = jedis.get("slots");
            if(raw != null) {
                return objectMapper.readValue(raw, new TypeReference<>(){});
            }
        } catch(JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        List<Slot> slots = slotRepository.findAll();

        try (Jedis jedis = jedisPool.getResource()) {
            String json = objectMapper.writeValueAsString(slots);
            jedis.setex("slots", 120, json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return slots;
    }
}
