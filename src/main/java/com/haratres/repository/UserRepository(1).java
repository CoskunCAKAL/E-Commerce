package com.haratres.repository;

import com.haratres.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByMail(String mail);

}
