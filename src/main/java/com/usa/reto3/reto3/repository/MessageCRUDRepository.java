package com.usa.reto3.reto3.repository;

import com.usa.reto3.reto3.repository.MessageCRUDRepository;
import com.usa.reto3.reto3.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCRUDRepository extends CrudRepository<Message, Integer> {
}
