package com.usa.reto3.reto3.service;

import com.usa.reto3.reto3.model.Client;
import com.usa.reto3.reto3.model.Computer;
import com.usa.reto3.reto3.repository.ComputerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerServices {
    @Autowired
    private ComputerRepository computerRepository;

    public List<Computer> getAllComputers() {
        return computerRepository.getAll();
    }

    public Optional<Computer> getComputer(int id) {
        return computerRepository.getComputer(id);
    }

    public Computer save(Computer computer) {
        if (computer.getId() == null) {
            return computerRepository.save(computer);
        } else {
            Optional<Computer> computerEncotrado = getComputer(computer.getId());
            if (computerEncotrado.isEmpty()) {
                return computerRepository.save(computer);
            } else {
                return computer;
            }
        }
    }

    public Computer update(Computer computer) {
        if (computer.getId() != null) {
            Optional<Computer> computerEncontrado = getComputer(computer.getId());
            if (!computerEncontrado.isEmpty()) {
                if (computer.getName() != null) {
                    computerEncontrado.get().setName(computer.getName());
                }
                if (computer.getBrand() != null) {
                    computerEncontrado.get().setBrand(computer.getBrand());
                }
                if (computer.getYear() != null) {
                    computerEncontrado.get().setYear(computer.getYear());
                }
                if (computer.getDescription() != null) {
                    computerEncontrado.get().setDescription(computer.getDescription());
                }
                if (computer.getCategory() != null) {
                    computerEncontrado.get().setCategory(computer.getCategory());
                }
                return computerRepository.save(computerEncontrado.get());
            }
        }
        return computer;
    }
    public boolean delete(int id){
        Boolean respuesta = getComputer(id).map(elemento ->{
            computerRepository.delete(elemento);
            return true;
        }).orElse(false);
        return respuesta;
    }
}
