package com.zfwhub.springboot.query;

public class EmployeeQuery {

    private String no;
    private String name;
    private String job;
    private Integer departmentId;
    private Integer managerId;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "EmployeeQuery [no=" + no + ", name=" + name + ", job=" + job + ", departmentId=" + departmentId + ", managerId=" + managerId + "]";
    }
    
}
