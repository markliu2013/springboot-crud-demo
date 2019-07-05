package com.zfwhub.springboot.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zfwhub.springboot.dto.AccountDto;
import com.zfwhub.springboot.dto.Response;
import com.zfwhub.springboot.request.AccountTransferRequest;
import com.zfwhub.springboot.service.AccountService;

@RestController
public class AccountController {
    
    @Autowired
    private AccountService accountService;
    
    @PostMapping(path="/accounts/transfer")
    public Response<Object> transfer(@RequestBody @Valid AccountTransferRequest accountTransferRequest) {
        accountService.transfer(new AccountDto(accountTransferRequest.getFrom()), new AccountDto(accountTransferRequest.getTo()), accountTransferRequest.getMoney());
        Response<Object> response = new Response<>();
        return response;
    }

}
