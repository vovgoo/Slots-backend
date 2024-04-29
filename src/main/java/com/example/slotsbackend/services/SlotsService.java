package com.example.slotsbackend.services;

import com.example.slotsbackend.models.Slot;

import java.util.List;

public interface SlotsService {
    List<Slot> findAllSlots();
}
