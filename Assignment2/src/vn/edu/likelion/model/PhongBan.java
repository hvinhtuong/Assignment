package vn.edu.likelion.model;

import vn.edu.likelion.services.IDepartment;

import java.util.ArrayList;
import java.util.List;

public class PhongBan implements IDepartment {
    private String departmentId;
    private String departmentName;
    private int expectEmployees;
    private List<NhanVien> employees = new ArrayList<>();

    public PhongBan(String departmentId, String departmentName, int expectEmployees) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.expectEmployees = expectEmployees;
    }

     /*
      * addEmployee - Add employee to department
      */
    public void addEmployee(NhanVien employee) {
        if (employees.size() < 3) {
            employees.add(employee);
        } else {
            System.out.println("Phòng ban đã đủ số lượng nhân viên tối đa (3 người).");
        }
    }

     /*
      * removeEmployee - Remove employee
      */
    public void removeEmployee(NhanVien employee) {
        employees.remove(employee);
    }

    /*
     * totalEmployees - Get total employee
     */
    public int totalEmployees() {
        return employees.size();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public int getExpectEmployees() {
        return expectEmployees;
    }

    @Override
    public List<NhanVien> getEmployees() {
        return employees;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public void setExpectEmployees(int expectEmployees) {
        this.expectEmployees = expectEmployees;
    }

     /*
      * Show department information
      */
    @Override
    public String toString() {
        return "PhongBan{" +
                "departmentId='" + departmentId + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", expectedEmployees='" + expectEmployees + '\'' +
                ", employees=" + employees +
                '}';
    }
}
