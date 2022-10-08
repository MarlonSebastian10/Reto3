package com.usa.reto3.reto3.repository;

import com.usa.reto3.reto3.model.Admin;
import com.usa.reto3.reto3.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {
    @Autowired
    private MessageCRUDRepository messageCRUDRepository;

    public List<Message> getAll(){
        return (List<Message>) messageCRUDRepository.findAll();
    }
    public Optional<Message> getMessage(int id){
        return messageCRUDRepository.findById(id);
    }

    public Message save(Message message){
        return messageCRUDRepository.save(message);
    }

    public void delete(Message message){
        messageCRUDRepository.delete(message);
    }
}
