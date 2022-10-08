package com.usa.reto3.reto3.controllers;

import com.usa.reto3.reto3.model.Client;
import com.usa.reto3.reto3.service.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})


@RestController
@RequestMapping("/api/Client")

public class ClientController {
    @Autowired
    private ClientServices clientServices;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientServices.getAll();
    }

    @GetMapping("/{id}") // localhost:8080/api/Category/21
    public Optional<Client> getClient(@PathVariable("id") int id){

        return clientServices.getClient(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Client save (@RequestBody Client client){
        return clientServices.save(client);
    }
}
