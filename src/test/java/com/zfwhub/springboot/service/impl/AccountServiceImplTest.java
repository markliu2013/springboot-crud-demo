package com.zfwhub.springboot.service.impl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zfwhub.springboot.Application;
import com.zfwhub.springboot.dto.AccountDto;
import com.zfwhub.springboot.repository.AccountRepository;
import com.zfwhub.springboot.service.AccountService;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(classes=Application.class)
@Transactional
public class AccountServiceImplTest {
    
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
    }

    @Before
    @Rollback(false)
    public void setUp() throws Exception {
//        List<Account> entities = new ArrayList<>();
//        Account account1 = new Account("A", 1000.0);
//        Account account2 = new Account("B", 1000.0);
//        Account account3 = new Account("C", 1000.0);
//        entities.add(account1);
//        entities.add(account2);
//        entities.add(account3);
//        accountRepository.saveAll(entities);
    }

    @Test
    public void testTransfer() {
        AccountDto from = new AccountDto("A");
        AccountDto to = new AccountDto("B");
        accountService.transfer(from, to, 100);
    }

}
