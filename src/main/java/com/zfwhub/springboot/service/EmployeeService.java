package com.zfwhub.springboot.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.zfwhub.springboot.dto.EmployeeDto;
import com.zfwhub.springboot.query.EmployeeQuery;

public interface EmployeeService {
    
    List<EmployeeDto> query(EmployeeQuery employeeQuery, Pageable page);

}
