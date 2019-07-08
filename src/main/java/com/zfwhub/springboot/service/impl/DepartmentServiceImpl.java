package com.zfwhub.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfwhub.springboot.dto.DepartmentDto;
import com.zfwhub.springboot.po.Department;
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
        BeanUtils.copyProperties(departmentDto, department);
        departmentRepository.save(department);
        departmentDto.setId(department.getId());
        return departmentDto;
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        List<Department> departments = departmentRepository.findAll();
        for (Department department : departments) {
            DepartmentDto departmentDto = new DepartmentDto();
            BeanUtils.copyProperties(department, departmentDto);
            departmentDtos.add(departmentDto);
        }
        return departmentDtos;
    }

    @Override
    public DepartmentDto getById(Integer id) {
        DepartmentDto departmentDto = new DepartmentDto();
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            BeanUtils.copyProperties(department.get(), departmentDto);
            return departmentDto;
        } else {
            return null;
        }
    }

    @Override
    public DepartmentDto deleteById(Integer id) {
        DepartmentDto departmentDto = new DepartmentDto();
        Optional<Department> department = departmentRepository.findById(id);
        if (department.isPresent()) {
            departmentRepository.delete(department.get());
            BeanUtils.copyProperties(department.get(), departmentDto);
            return departmentDto;
        } else {
            return null;
        }
    }

}
