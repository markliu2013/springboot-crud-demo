package com.zfwhub.springboot.service.impl;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zfwhub.springboot.dto.AccountDto;
import com.zfwhub.springboot.po.Account;
import com.zfwhub.springboot.repository.AccountRepository;
import com.zfwhub.springboot.service.AccountService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class AccountServiceImplTest {
    
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    @Test
    @Rollback(true)
    public void testTransferNormal() {
        
        List<Account> entities = new ArrayList<>();
        Account account1 = new Account("A1", 1000.0);
        Account account2 = new Account("B1", 1000.0);
        entities.add(account1);
        entities.add(account2);
        accountRepository.saveAll(entities);
        
        AccountDto from = new AccountDto("A1");
        AccountDto to = new AccountDto("B1");
        accountService.transfer(from, to, 100);
        
        Optional<Account> account3 = accountRepository.findById(account1.getId());
        Optional<Account> account4 = accountRepository.findById(account2.getId());
        assertEquals(new Double(900.0), account3.get().getMoney());
        assertEquals(new Double(1100.0), account4.get().getMoney());
        
    }

}
