package com.zfwhub.springboot.endpoint;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zfwhub.springboot.dto.BaseResponse;
import com.zfwhub.springboot.dto.EmployeeDto;
import com.zfwhub.springboot.dto.ResponseSuccess;
import com.zfwhub.springboot.query.EmployeeQuery;
import com.zfwhub.springboot.service.EmployeeService;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    @GetMapping("/employees")
    public BaseResponse query(@RequestParam(required=false, name="q") String q, Pageable page) throws JsonParseException, JsonMappingException, IOException {
        EmployeeQuery employeeQuery = new EmployeeQuery();
        if (q != null) {
           employeeQuery = new ObjectMapper().readValue(q, EmployeeQuery.class);
        }
        List<EmployeeDto> employeeDtos = employeeService.query(employeeQuery, page);
        ResponseSuccess<List<EmployeeDto>> response = new ResponseSuccess<>();
        response.setData(employeeDtos);
        return response;
    }
    
    @GetMapping("/initData")
    public BaseResponse initData() {
        employeeService.initData();
        return new BaseResponse(true);
    }
    
    

}
