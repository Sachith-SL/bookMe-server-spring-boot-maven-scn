package com.sachith.server.repository;

import com.sachith.server.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {
    public List<Slot> findByAvailable(Boolean isAvailable);
}
