package ru.vadimio.FileManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vadimio.FileManager.entities.Role;
import ru.vadimio.FileManager.repository.RoleRepository;

import java.util.List;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> findAll(){ return (List<Role>) roleRepository.findAll();}
}
