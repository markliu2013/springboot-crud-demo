package com.zfwhub.springboot.request;

import javax.validation.constraints.NotEmpty;

public class AccountTransferRequest {
    
    @NotEmpty
    private String from;
    
    @NotEmpty
    private String to;
    
    private double money;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "AccountTransferRequest [from=" + from + ", to=" + to + ", money=" + money + "]";
    }

}
