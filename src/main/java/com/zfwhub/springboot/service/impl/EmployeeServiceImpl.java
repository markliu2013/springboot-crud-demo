package com.zfwhub.springboot.service.impl;

import java.time.LocalDate;
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
import com.zfwhub.springboot.po.SalaryGrade;
import com.zfwhub.springboot.query.EmployeeQuery;
import com.zfwhub.springboot.repository.DepartmentRepository;
import com.zfwhub.springboot.repository.EmployeeRepository;
import com.zfwhub.springboot.repository.SalaryGradeRepository;
import com.zfwhub.springboot.service.EmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    
    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Autowired
    private SalaryGradeRepository salaryGradeRepository;
    
    @Autowired
    private DepartmentRepository departmentRepository;

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
            List<SalaryGrade> salaryGrades = salaryGradeRepository.findFirstGradeBySalary(employee.getSalary());
            if (salaryGrades.size() > 0) {
                employeeDto.setSalaryGrade(salaryGrades.get(0).getGrade());
            }
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    @Override
    public void initData() {
        Department department1 = new Department("Accounting", "New York");
        Department department2 = new Department("Research", "Dallas");
        Department department3 = new Department("Sales", "Chicago");
        Department department4 = new Department("Operations", "Boston");
        departmentRepository.save(department1);
        departmentRepository.save(department2);
        departmentRepository.save(department3);
        departmentRepository.save(department4);
        
        SalaryGrade salaryGrade1 = new SalaryGrade(1, 700d, 1200d);
        SalaryGrade salaryGrade2 = new SalaryGrade(2, 1201d, 1400d);
        SalaryGrade salaryGrade3 = new SalaryGrade(3, 1401d, 2000d);
        SalaryGrade salaryGrade4 = new SalaryGrade(4, 2001d, 3000d);
        SalaryGrade salaryGrade5 = new SalaryGrade(5, 3001d, 9999d);
        salaryGradeRepository.save(salaryGrade1);
        salaryGradeRepository.save(salaryGrade2);
        salaryGradeRepository.save(salaryGrade3);
        salaryGradeRepository.save(salaryGrade4);
        salaryGradeRepository.save(salaryGrade5);
        
        Employee employee9 = new Employee("7839", "King", "President", null, LocalDate.of(1981, 3, 2), 5000d, null, department1);
        employeeRepository.save(employee9);
        Employee employee4 = new Employee("7566", "Jones", "Manager", employee9, LocalDate.of(1981, 2, 4), 2975d, null, department2);
        employeeRepository.save(employee4);
        Employee employee13 = new Employee("7902", "Ford", "Analyst", employee4, LocalDate.of(1981, 7, 10), 3000d, null, department2);
        employeeRepository.save(employee13);
        Employee employee6 = new Employee("7698", "Blake", "Manager", employee9, LocalDate.of(1981, 1, 5), 2850d, null, department3);
        employeeRepository.save(employee6);
        Employee employee1 = new Employee("7369", "Smith", "Clerk", employee13, LocalDate.of(1980, 12, 17), 800d, null, department2);
        employeeRepository.save(employee1);
        Employee employee2 = new Employee("7499", "Allen", "Salesman", employee6, LocalDate.of(1981, 2, 20), 1600d, 300d, department3);
        employeeRepository.save(employee2);
        Employee employee3 = new Employee("7521", "Ward", "Salesman", employee6, LocalDate.of(1981, 2, 22), 1250d, 500d, department3);
        employeeRepository.save(employee3);
        Employee employee5 = new Employee("7654", "Martin", "Salesman", employee6, LocalDate.of(1981, 9, 28), 1250d, 1400d, department3);
        employeeRepository.save(employee5);
        Employee employee7 = new Employee("7782", "Clark", "Manager", employee9, LocalDate.of(1981, 7, 13), 2450d, null, department1);
        employeeRepository.save(employee7);
        Employee employee8 = new Employee("7788", "Scott", "Analyst", employee4, LocalDate.of(1981, 2, 4), 3000d, null, department2);
        employeeRepository.save(employee8);
        Employee employee10 = new Employee("7844", "Turner", "Salesman", employee6, LocalDate.of(1981, 4, 2), 1500d, 0d, department3);
        employeeRepository.save(employee10);
        Employee employee11 = new Employee("7876", "Adams", "Clerk", employee8, LocalDate.of(1981, 5, 1), 1100d, null, department2);
        employeeRepository.save(employee11);
        Employee employee12 = new Employee("7900", "James", "Clerk", employee6, LocalDate.of(1981, 6, 20), 950d, null, department3);
        employeeRepository.save(employee12);
        Employee employee14 = new Employee("7934", "Miller", "Clerk", employee7, LocalDate.of(1981, 8, 22), 1300d, null, department1);
        employeeRepository.save(employee14);
    }

}
