package com.haratres.repository;


import com.haratres.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<Role, Integer> {


    Role findByName(String name);
}
