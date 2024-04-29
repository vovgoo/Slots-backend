package com.example.slotsbackend.models;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "slot")
@Data
@Entity
public class Slot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String image;
}
