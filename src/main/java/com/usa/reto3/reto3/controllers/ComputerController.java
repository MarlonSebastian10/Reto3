package com.usa.reto3.reto3.controllers;

import com.usa.reto3.reto3.model.Computer;
import com.usa.reto3.reto3.service.ComputerServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/api/Computer")
public class ComputerController {

    @Autowired
    private ComputerServices computerServices;

    @GetMapping("/all")
    public List<Computer> getAllComputers(){
        return computerServices.getAllComputers();
    }

    @GetMapping("/{id}") // localhost:8080/api/Category/21
    public Optional<Computer> getComputer(@PathVariable("id") int id){
        return computerServices.getComputer(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Computer insertComputer(@RequestBody Computer computer){
        return computerServices.save(computer);
    }
}
