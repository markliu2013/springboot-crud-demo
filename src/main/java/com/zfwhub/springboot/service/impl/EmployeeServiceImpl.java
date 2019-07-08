package com.zfwhub.springboot.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zfwhub.springboot.dto.EmployeeDto;
import com.zfwhub.springboot.po.Department;
import com.zfwhub.springboot.po.Employee;
import com.zfwhub.springboot.query.EmployeeQuery;
import com.zfwhub.springboot.repository.EmployeeRepository;
import com.zfwhub.springboot.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDto> query(EmployeeQuery employeeQuery, Pageable page) {
        Employee employeeForExample = new Employee();
        BeanUtils.copyProperties(employeeQuery, employeeForExample);
        if (employeeQuery.getDepartmentId() != null) {
            Department department = new Department(employeeQuery.getDepartmentId());
            employeeForExample.setDepartment(department);
        }
        if (employeeQuery.getManagerId() != null) {
            Employee manager = new Employee(employeeQuery.getManagerId());
            employeeForExample.setManager(manager);
        }
        Example<Employee> example = Example.of(employeeForExample);
        Page<Employee> employees = employeeRepository.findAll(example, page);
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        for (Employee employee : employees) {
            EmployeeDto employeeDto = new EmployeeDto();
            BeanUtils.copyProperties(employee, employeeDto);
            Employee manager = employee.getManager();
            if (manager != null) {
                employeeDto.setManagerId(manager.getId());
                employeeDto.setManagerName(manager.getName());
            }
            Department department = employee.getDepartment();
            if (department != null) {
                employeeDto.setDepartmentId(department.getId());
                employeeDto.setDepartmentName(department.getName());
            }
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

}
