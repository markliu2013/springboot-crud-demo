package com.zfwhub.springboot.service;

import com.zfwhub.springboot.dto.AccountDto;

public interface AccountService {
    
    boolean transfer(AccountDto from, AccountDto to, double money);
    
    boolean transfer(AccountDto to, double money);

}
