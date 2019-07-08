package com.zfwhub.springboot.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zfwhub.springboot.dto.BaseResponse;
import com.zfwhub.springboot.dto.DepartmentDto;
import com.zfwhub.springboot.dto.ResponseError;
import com.zfwhub.springboot.dto.ResponseSuccess;
import com.zfwhub.springboot.service.DepartmentService;

@RestController
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping("/departments")
    public BaseResponse getAll() {
        List<DepartmentDto> departmentDtos = departmentService.getAll();
        ResponseSuccess<List<DepartmentDto>> response = new ResponseSuccess<>();
        response.setData(departmentDtos);
        return response;
    }
    
    @PostMapping("/departments")
    public BaseResponse add(@RequestBody DepartmentDto departmentDto) {
        departmentService.add(departmentDto);
        ResponseSuccess<DepartmentDto> response = new ResponseSuccess<>();
        return response;
    }
    
    @GetMapping("/departments/{id}")
    public BaseResponse getById(@PathVariable("id") Integer id) {
        DepartmentDto departmentDto = departmentService.getById(id);
        if (departmentDto == null) {
            return new ResponseError(2);
        } else {
            return new ResponseSuccess<>(departmentDto);
        }
    }
    
    @DeleteMapping("/departments/{id}")
    public BaseResponse deleteById(@PathVariable("id") Integer id) {
        DepartmentDto departmentDto = departmentService.deleteById(id);
        if (departmentDto == null) {
            return new ResponseError(2);
        } else {
            return new ResponseSuccess<>(departmentDto);
        }
    }
    
}
