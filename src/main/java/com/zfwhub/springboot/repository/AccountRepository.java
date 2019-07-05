package com.zfwhub.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.zfwhub.springboot.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    
    @Modifying(clearAutomatically = true)
    @Query("UPDATE Account a SET a.money = a.money+:money WHERE a.name = :name")
    int inreaseMoney(@Param("name") String name, @Param("money") double money);

}
