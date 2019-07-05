package com.zfwhub.springboot.service;

import java.util.List;

import com.zfwhub.springboot.dto.DepartmentDto;

public interface DepartmentService {
    
    DepartmentDto add(DepartmentDto departmentDto);
    
    List<DepartmentDto> getAll();
    
    DepartmentDto getByName(String name);

}
