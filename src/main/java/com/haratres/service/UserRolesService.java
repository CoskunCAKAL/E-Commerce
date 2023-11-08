package com.haratres.service;


import com.haratres.entity.Role;

import java.util.List;

public interface UserRolesService {
    void save(Role role);


    void deleteAll();

    List<Role> findAll();

    Role findRoleById(int id);

    Role findRoleByName(String name);

}
