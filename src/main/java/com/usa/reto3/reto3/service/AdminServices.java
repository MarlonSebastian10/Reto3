package com.usa.reto3.reto3.service;

import com.usa.reto3.reto3.model.Admin;
import com.usa.reto3.reto3.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServices {
    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAll() {
        return adminRepository.getAll();
    }
    public Optional<Admin> getAdmin(int id) {
        return adminRepository.getAdmin(id);
    }

    public Admin save(Admin admin){
        if(admin.getIdAdmin() == null){
            return adminRepository.save(admin);
        }else {
            Optional<Admin> adminEncontrado = getAdmin(admin.getIdAdmin());
            if(adminEncontrado.isEmpty()){
                return adminRepository.save(admin);
            }else {
                return admin;
            }
        }
    }

    public Admin update (Admin admin){
        if(admin.getIdAdmin() != null){
            Optional<Admin> adminEncontrado = getAdmin(admin.getIdAdmin());
            if(!adminEncontrado.isEmpty()){
                if(admin.getPassword()!= null){
                    adminEncontrado.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!= null){
                    adminEncontrado.get().setName(admin.getName());
                }
                return adminRepository.save(adminEncontrado.get());
            }
        }
        return admin;
    }

    public boolean delete(int id){
        Boolean respuesta = getAdmin(id).map(elemento ->{
            adminRepository.delete(elemento);
            return true;
        }).orElse(false);

        return respuesta;
    }
}
