package com.usa.reto3.reto3.repository;

import com.usa.reto3.reto3.model.Admin;
import com.usa.reto3.reto3.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ScoreRepository {
    @Autowired
    private ScoreCRUDRepository scoreCRUDRepository;

    public List<Score> getAll(){
        return (List<Score>) scoreCRUDRepository.findAll();
    }

    public Optional<Score> getScore(int id){
        return scoreCRUDRepository.findById(id);
    }

    public Score save(Score score){
        return scoreCRUDRepository.save(score);
    }

    public void delete(Score score){
        scoreCRUDRepository.delete(score);
    }
}
