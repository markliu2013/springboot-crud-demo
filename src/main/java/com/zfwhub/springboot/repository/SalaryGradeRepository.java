package com.zfwhub.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zfwhub.springboot.po.SalaryGrade;

public interface SalaryGradeRepository extends JpaRepository<SalaryGrade, Integer> {

}
