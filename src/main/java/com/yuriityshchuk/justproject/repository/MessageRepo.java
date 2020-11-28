package com.yuriityshchuk.justproject.repository;

import com.yuriityshchuk.justproject.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepo extends JpaRepository<Message, Long> {
    List<Message> findByMessage(String username);
}
