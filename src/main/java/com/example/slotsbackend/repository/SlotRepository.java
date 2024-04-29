package com.example.slotsbackend.repository;

import com.example.slotsbackend.models.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

}
