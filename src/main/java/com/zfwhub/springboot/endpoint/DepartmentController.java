package com.zfwhub.springboot.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zfwhub.springboot.dto.DepartmentDto;
import com.zfwhub.springboot.dto.Response;
import com.zfwhub.springboot.service.DepartmentService;

@RestController
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping(path="/departments")
    public Response<List<DepartmentDto>> getAll() {
        List<DepartmentDto> departmentDtos = departmentService.getAll();
        Response<List<DepartmentDto>> response = new Response<>();
        response.setData(departmentDtos);
        return response;
    }
    
    @PostMapping(path="/departments")
    public Response<DepartmentDto> add(@RequestBody DepartmentDto departmentDto) {
        departmentService.add(departmentDto);
        Response<DepartmentDto> response = new Response<>();
        return response;
    }
    
    @GetMapping(path="/departments/{name}")
    public Response<DepartmentDto> getByName(@RequestBody String name) {
        DepartmentDto departmentDto = departmentService.getByName(name);
        Response<DepartmentDto> response = new Response<>();
        response.setData(departmentDto);
        return response;
    }
    

}
