package com.usa.reto3.reto3.repository;

import com.usa.reto3.reto3.model.Admin;
import com.usa.reto3.reto3.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClientRepository{
    @Autowired
    private ClientCRUDRepository clientCRUDRepository;

    public List<Client> getAll(){
        return (List<Client>) clientCRUDRepository.findAll();
    }
    public Optional<Client> getClient(int id){
        return clientCRUDRepository.findById(id);// String
    }

    public Client save(Client client){
        return clientCRUDRepository.save(client);
    }

    public void delete(Client client){
        clientCRUDRepository.delete(client);
    }
}
