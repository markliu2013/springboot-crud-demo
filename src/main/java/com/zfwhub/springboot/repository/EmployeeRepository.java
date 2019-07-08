package com.zfwhub.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zfwhub.springboot.po.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
