package com.zfwhub.springboot.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfwhub.springboot.dto.AccountDto;
import com.zfwhub.springboot.repository.AccountRepository;
import com.zfwhub.springboot.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean transfer(AccountDto from, AccountDto to, double money) {
        accountRepository.inreaseMoney(from.getName(), money*(-1));
        accountRepository.inreaseMoney(to.getName(), money);
        return true;
    }

    @Override
    public boolean transfer(AccountDto to, double money) {
        return false;
    }

}
