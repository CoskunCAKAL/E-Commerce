package com.haratres.service.impl;

import com.haratres.entity.User;
import com.haratres.repository.UserRepository;
import com.haratres.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final UserRepository accountRepository;

@Override
    public List<User> getAllAccount(){
        return accountRepository.findAll();
    }

    @Override
    public User getAccountById(Long id) {
        return accountRepository.findById(id).get();
    }

    @Override
    public User findByUserMail(String mail) {
        return accountRepository.findByMail(mail);
    }

    @Override
    public User saveAccount(User account) {
        accountRepository.save(account);
        return account;
    }

    @Override
    public void deleteAccount(User account) {
        accountRepository.delete(account);
    }
}
