package com.zfwhub.springboot.service.impl;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.zfwhub.springboot.dto.DepartmentDto;
import com.zfwhub.springboot.po.Department;
import com.zfwhub.springboot.repository.DepartmentRepository;
import com.zfwhub.springboot.service.DepartmentService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DepartmentServiceImplTest {
    
    @Autowired
    private DepartmentService departmentService;
    
    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void testAdd() {
        DepartmentDto dto = new DepartmentDto("Test1", "Test2");
        DepartmentDto dto2 = departmentService.add(dto);
        Optional<Department> department = departmentRepository.findById(dto2.getId());
        assertEquals(dto.getName(), department.get().getName());
        assertEquals(dto.getLocation(), department.get().getLocation());
    }

}
