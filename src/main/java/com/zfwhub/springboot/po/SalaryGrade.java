package com.zfwhub.springboot.po;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SalaryGrade {

    private Integer id;
    private Integer grade; // 1, 2, 3...
    private Double fromSalary; // include
    private Double toSalary; // include

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Double getFromSalary() {
        return fromSalary;
    }

    public void setFromSalary(Double fromSalary) {
        this.fromSalary = fromSalary;
    }

    public Double getToSalary() {
        return toSalary;
    }

    public void setToSalary(Double toSalary) {
        this.toSalary = toSalary;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((grade == null) ? 0 : grade.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SalaryGrade other = (SalaryGrade) obj;
        if (grade == null) {
            if (other.grade != null)
                return false;
        } else if (!grade.equals(other.grade))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SalaryGrade [id=" + id + ", grade=" + grade + ", fromSalary=" + fromSalary + ", toSalary=" + toSalary + "]";
    }

}
