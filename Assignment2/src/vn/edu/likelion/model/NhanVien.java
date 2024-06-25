package vn.edu.likelion.model;
import vn.edu.likelion.services.IEmployee;

import java.time.LocalDateTime;

public class NhanVien implements IEmployee {
    private String employeeId;
    private String employeeName;
    private int age;
    private LocalDateTime joinDate;
    private String departmentName;

    public NhanVien(String employeeId, String employeeName, int age, LocalDateTime joinDate, String departmentName) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.age = age;
        this.joinDate = joinDate;
        this.departmentName = departmentName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public int getAge() {
        return age;
    }

    public LocalDateTime getJoinDate() {
        return joinDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
}
