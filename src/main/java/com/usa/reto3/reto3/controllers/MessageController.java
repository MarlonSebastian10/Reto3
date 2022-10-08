package com.usa.reto3.reto3.controllers;

import com.usa.reto3.reto3.model.Message;
import com.usa.reto3.reto3.service.MessageServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/api/Message")

public class MessageController {
    @Autowired
    private MessageServices messageServices;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageServices.getAll();
    }

    @GetMapping("/{id}") // localhost:8080/api/Category/21
    public Optional<Message> getMessage(@PathVariable("id") int id){
        return messageServices.getMessage(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save (@RequestBody Message message){
        return messageServices.save(message);
    }
}
