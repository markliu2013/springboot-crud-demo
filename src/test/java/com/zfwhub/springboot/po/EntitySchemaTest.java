package com.zfwhub.springboot.po;


import java.time.LocalDate;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.zfwhub.springboot.Application;
import com.zfwhub.springboot.po.Department;
import com.zfwhub.springboot.po.Employee;
import com.zfwhub.springboot.po.SalaryGrade;

// https://ajayiyengar.com/2017/07/08/testing-jpa-entities-in-a-spring-boot-application/
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@ContextConfiguration(classes=Application.class)
@Transactional
public class EntitySchemaTest {
    
    @Autowired
    private TestEntityManager entityManager;
    
    @Test
    @Rollback(false)
    public void initData() {
        
        Department department1 = new Department("Accounting", "New York");
        Department department2 = new Department("Research", "Dallas");
        Department department3 = new Department("Sales", "Chicago");
        Department department4 = new Department("Operations", "Boston");
        entityManager.persist(department1);
        entityManager.persist(department2);
        entityManager.persist(department3);
        entityManager.persist(department4);
        
        SalaryGrade salaryGrade1 = new SalaryGrade(1, 700d, 1200d);
        SalaryGrade salaryGrade2 = new SalaryGrade(2, 1201d, 1400d);
        SalaryGrade salaryGrade3 = new SalaryGrade(3, 1401d, 2000d);
        SalaryGrade salaryGrade4 = new SalaryGrade(4, 2001d, 3000d);
        SalaryGrade salaryGrade5 = new SalaryGrade(5, 3001d, 9999d);
        entityManager.persist(salaryGrade1);
        entityManager.persist(salaryGrade2);
        entityManager.persist(salaryGrade3);
        entityManager.persist(salaryGrade4);
        entityManager.persist(salaryGrade5);
        
        Employee employee9 = new Employee("7839", "King", "President", null, LocalDate.of(1981, 3, 2), 5000d, null, department1);
        entityManager.persist(employee9);
        Employee employee4 = new Employee("7566", "Jones", "Manager", employee9, LocalDate.of(1981, 2, 4), 2975d, null, department2);
        entityManager.persist(employee4);
        Employee employee13 = new Employee("7902", "Ford", "Analyst", employee4, LocalDate.of(1981, 7, 10), 3000d, null, department2);
        entityManager.persist(employee13);
        Employee employee6 = new Employee("7698", "Blake", "Manager", employee9, LocalDate.of(1981, 1, 5), 2850d, null, department3);
        entityManager.persist(employee6);
        Employee employee1 = new Employee("7369", "Smith", "Clerk", employee13, LocalDate.of(1980, 12, 17), 800d, null, department2);
        entityManager.persist(employee1);
        Employee employee2 = new Employee("7499", "Allen", "Salesman", employee6, LocalDate.of(1981, 2, 20), 1600d, 300d, department3);
        entityManager.persist(employee2);
        Employee employee3 = new Employee("7521", "Ward", "Salesman", employee6, LocalDate.of(1981, 2, 22), 1250d, 500d, department3);
        entityManager.persist(employee3);
        Employee employee5 = new Employee("7654", "Martin", "Salesman", employee6, LocalDate.of(1981, 9, 28), 1250d, 1400d, department3);
        entityManager.persist(employee5);
        Employee employee7 = new Employee("7782", "Clark", "Manager", employee9, LocalDate.of(1981, 7, 13), 2450d, null, department1);
        entityManager.persist(employee7);
        Employee employee8 = new Employee("7788", "Scott", "Analyst", employee4, LocalDate.of(1981, 2, 4), 3000d, null, department2);
        entityManager.persist(employee8);
        Employee employee10 = new Employee("7844", "Turner", "Salesman", employee6, LocalDate.of(1981, 4, 2), 1500d, 0d, department3);
        entityManager.persist(employee10);
        Employee employee11 = new Employee("7876", "Adams", "Clerk", employee8, LocalDate.of(1981, 5, 1), 1100d, null, department2);
        entityManager.persist(employee11);
        Employee employee12 = new Employee("7900", "James", "Clerk", employee6, LocalDate.of(1981, 6, 20), 950d, null, department3);
        entityManager.persist(employee12);
        Employee employee14 = new Employee("7934", "Miller", "Clerk", employee7, LocalDate.of(1981, 8, 22), 1300d, null, department1);
        entityManager.persist(employee14);
        
    }
    
    

}
