package com.usa.reto3.reto3.controllers;

import com.usa.reto3.reto3.model.Score;
import com.usa.reto3.reto3.service.ScoreServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

@RestController
@RequestMapping("/api/Score")
public class ScoreController {

    @Autowired
    private ScoreServices scoreServices;

    @GetMapping("/all")
    public List<Score> getAll(){
        return scoreServices.getAll();
    }
    @PostMapping("/save")
    public Score save(@RequestBody Score score){
        return scoreServices.save(score);
    }
}
