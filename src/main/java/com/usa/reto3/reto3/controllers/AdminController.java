package com.usa.reto3.reto3.controllers;

import com.usa.reto3.reto3.model.Admin;
import com.usa.reto3.reto3.service.AdminServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminServices adminServices;

    // /api/Admin/all
    @GetMapping("/all")
    public List<Admin> getAll(){

        return  adminServices.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int id){
        return adminServices.getAdmin(id);
    }

    // /api/Admin/save
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return adminServices.save(admin);
    }
}

