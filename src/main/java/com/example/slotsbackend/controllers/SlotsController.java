package com.example.slotsbackend.controllers;

import com.example.slotsbackend.models.Slot;
import com.example.slotsbackend.services.SlotsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/slots")
public class SlotsController {

    private final SlotsService slotsService;

    @GetMapping("/getSlots")
    public List<Slot> getAllSlots() {
        return slotsService.findAllSlots();
    }

}
