package vn.edu.likelion.services;

import vn.edu.likelion.model.NhanVien;

import java.util.List;

public interface IDepartment {
    String getDepartmentId();
    String getDepartmentName();
    List<NhanVien> getEmployees();
}

