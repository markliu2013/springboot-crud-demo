package com.zfwhub.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfwhub.springboot.domain.Department;
import com.zfwhub.springboot.dto.DepartmentDto;
import com.zfwhub.springboot.dto.DtoUtils;
import com.zfwhub.springboot.repository.DepartmentRepository;
import com.zfwhub.springboot.service.DepartmentService;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto add(DepartmentDto departmentDto) {
        Department department = new Department();
        DtoUtils.convertToPo(departmentDto, department);
        departmentRepository.save(department);
        return departmentDto;
    }

    @Override
    @Transactional(readOnly=true)
    public List<DepartmentDto> getAll() {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            DepartmentDto departmentDto = new DepartmentDto();
            DtoUtils.convertToDto(department, departmentDto);
            departmentDtos.add(departmentDto);
        }
        return departmentDtos;
    }

    @Override
    public DepartmentDto getByName(String name) {
        Department department = departmentRepository.findByName(name);
        DepartmentDto departmentDto = new DepartmentDto();
        DtoUtils.convertToDto(department, departmentDto);
        return departmentDto;
    }

}
