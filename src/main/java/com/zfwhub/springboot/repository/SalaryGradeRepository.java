package com.zfwhub.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.zfwhub.springboot.po.SalaryGrade;

@Repository
public interface SalaryGradeRepository extends JpaRepository<SalaryGrade, Integer> {
    
    @Query("select s from SalaryGrade s where :salary between s.fromSalary and s.toSalary")
    List<SalaryGrade> findFirstGradeBySalary(Double salary);

}
