package com.zfwhub.springboot.dto;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zfwhub.springboot.domain.Department;

public class DepartmentDtoTest {

    @Test
    public void test() {
        Department department = new Department("a", "b");
        DepartmentDto departmentDto = new DepartmentDto();
        DtoUtils.convertToDto(department, departmentDto);
        assertEquals(department.getName(), departmentDto.getName());
    }

}
