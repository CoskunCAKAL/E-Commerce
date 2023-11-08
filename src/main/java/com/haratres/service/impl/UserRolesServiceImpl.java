package com.haratres.service.impl;

import com.haratres.entity.Role;


import com.haratres.repository.UserRolesRepository;
import com.haratres.service.UserRolesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserRolesServiceImpl implements UserRolesService {

    private final UserRolesRepository userRolesRepository;


    @Override
    public void save(Role role) {
        userRolesRepository.save(role);
    }


    @Override
    public void deleteAll() {
        userRolesRepository.deleteAll();
    }

    @Override
    public List<Role> findAll() {
        return userRolesRepository.findAll();
    }

    @Override
    public Role findRoleById(int id) {
        return userRolesRepository.findById(id).get();
    }

    @Override
    public Role findRoleByName(String name) {
        return userRolesRepository.findByName(name);
    }
}
