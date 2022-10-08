package com.usa.reto3.reto3.repository;

import com.usa.reto3.reto3.model.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComputerRepository {
    @Autowired
    private ComputerCRUDRepository computerCRUDRepository;

    public List<Computer> getAll(){
        return (List<Computer>) computerCRUDRepository.findAll();
    }

    public Optional<Computer> getComputer(int id){
        return computerCRUDRepository.findById(id);
    }

    public Computer save(Computer computer){

        return computerCRUDRepository.save(computer);
    }

    public void delete(Computer computer){

        computerCRUDRepository.delete(computer);
    }
}
