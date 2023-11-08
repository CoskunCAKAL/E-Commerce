package com.haratres.service;

import com.haratres.entity.User;

import java.util.List;

public interface AccountService {

    List<User> getAllAccount();

    User getAccountById(Long id);

    User findByUserMail(String mail);

    User saveAccount(User account);

    void deleteAccount(User account);


}
