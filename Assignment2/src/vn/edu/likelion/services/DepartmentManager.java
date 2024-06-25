package vn.edu.likelion.services;

import vn.edu.likelion.model.NhanVien;
import vn.edu.likelion.model.PhongBan;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/*
 * DepartmentManager - Manage departments
 */
public class DepartmentManager {
    private List<PhongBan> departments = new ArrayList<>();
    private int departmentIdCounter = 1;
    private int employeeIdCounter = 1;
    private Scanner scanner = new Scanner(System.in);

    public void addDepartment(String departmentName, int expectEmployees) {
        // Check duplicate Phong ban
        for (PhongBan existingDepartment : departments) {
            if (existingDepartment.getDepartmentName().equalsIgnoreCase(departmentName)) {
                System.out.println("Tên phòng ban đã tồn tại!");
                return;
            }
        }
            PhongBan department = new PhongBan(String.valueOf(departmentIdCounter++), departmentName, expectEmployees);
            departments.add(department);
            System.out.println("Đã thêm phòng ban: " + department.getDepartmentName() + " thành công!");
    }

     /*
      * Get list of department
      */
    public List<PhongBan> getDepartments() {
        return departments;
    }

    /*
     * deleteDepartment - Delete a department
     */
    public void deleteDepartment(String departmentId) {
        PhongBan departmentToRemove = null;
        for (PhongBan department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                departmentToRemove = department;
                break;
            }
        }

        if (departmentToRemove != null) {
            departments.remove(departmentToRemove);
            System.out.println("Đã xóa phòng ban: " + departmentToRemove.getDepartmentName() + " thành công!");
        } else {
            System.out.println("Không tìm thấy phòng ban có ID: " + departmentId);
        }
    }

     /*
      * detailDepartment - Show department detail
      */
    public void detailDepartment(String departmentId) {
        PhongBan department = getDepartmentById(departmentId);
        if (department == null) {
            System.out.println("Không tìm thấy phòng ban có ID: " + departmentId);
            return;
        }

        System.out.println("----------------------------------------------");
        System.out.println("----------PHÒNG: " + department.getDepartmentName() + "-------------------");
        System.out.println("----------------------------------------------");
        System.out.println("ID: " + department.getDepartmentId());
        System.out.println("Số lượng nhân viên: " + department.totalEmployees());
        if (department.totalEmployees() > 0) {
            System.out.println("\nDanh sách nhân viên:");
            for (IEmployee employee : department.getEmployees()) {
                System.out.println(" - " + employee.getEmployeeName() + " (ID: " + employee.getEmployeeId() + ")");
            }
        } else {
            System.err.println("Phòng ban chưa có nhân viên.");
        }
    }

    /*
     * addEmployee - Add an employee
     */
    public void addEmployee(String departmentId) {
        PhongBan phongBan = getDepartmentById(departmentId);
        if (phongBan == null) {
            System.err.println("Không tìm thấy phòng ban có ID: " + departmentId);
            return;
        }

        if (phongBan.totalEmployees() >= 3) {
            System.err.println("Phòng ban đã đủ số lượng nhân viên tối đa (3 người).");
            return;
        }

        System.out.print("Nhập tên nhân viên: ");
        String employeeName = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        LocalDateTime joinDate = LocalDateTime.now();

        NhanVien nhanVien = new NhanVien(String.valueOf(employeeIdCounter++), employeeName, age, joinDate, phongBan.getDepartmentName());
        phongBan.addEmployee(nhanVien);
        System.out.println("Đã thêm nhân viên thành công!");
    }


     /*
      * updateDepartment - Update department information
      */
    public void updateDepartment(String departmentId) {
        PhongBan department = getDepartmentById(departmentId);
        if (department == null) {
            System.err.println("Không tìm thấy phòng ban có ID: " + departmentId);
            return;
        }

        // Show old of department
        System.out.println("Thông tin phòng ban hiện tại:");
        System.out.println("Tên Phòng Ban: " + department.getDepartmentName());

        System.out.print("Nhập tên phòng ban mới: ");
        String newDepartmentName = scanner.nextLine();

        // CHeck duplicate new department
        for (PhongBan existingDepartment : departments) {
            if (existingDepartment.getDepartmentName().equalsIgnoreCase(newDepartmentName) &&
                    !existingDepartment.getDepartmentId().equals(departmentId)) {
                System.err.println("Tên phòng ban đã tồn tại!");
                return;
            }
        }

        department.setDepartmentName(newDepartmentName);
        System.out.println("Đã cập nhật thông tin phòng ban thành công!");
    }

     /*
      * updateEmployee - Update employee infor
      */
    public void updateEmployee(String employeeId) {
        NhanVien employee = getEmployeeById(employeeId);
        if (employee == null) {
            System.out.println("Không tìm thấy nhân viên có ID: " + employeeId);
            return;
        }

        // Show old of employee
        System.out.println("Thông tin nhân viên hiện tại:");
        System.out.println("Tên: " + employee.getEmployeeName());
        System.out.println("Tuổi: " + employee.getAge());

        //Type new infor
        System.out.print("Nhập tên mới (bỏ trống nếu không muốn thay đổi): ");
        String newEmployeeName = scanner.nextLine();
        if (!newEmployeeName.isEmpty()) {
            employee.setEmployeeName(newEmployeeName);
        }

        System.out.print("Nhập tuổi mới (bỏ trống nếu không muốn thay đổi): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.isEmpty()) {
            try {
                int newAge = Integer.parseInt(ageInput);
                employee.setAge(newAge);
            } catch (NumberFormatException e) {
                System.err.println("Tuổi không hợp lệ.");
            }
        }

        System.out.println("Đã cập nhật thông tin nhân viên thành công!");
    }

     /*
      * deleteEmployee - Delete employee
      */
    public void deleteEmployee(String employeeId) {
        NhanVien employeeToRemove = null;
        for (PhongBan department : departments) {
            for (NhanVien employee : department.getEmployees()) {
                if (employee.getEmployeeId().equals(employeeId)) {
                    employeeToRemove = (NhanVien) employee;
                    break;
                }
            }
            if (employeeToRemove != null) {
                department.removeEmployee(employeeToRemove);
                break;
            }
        }

        if (employeeToRemove != null) {
            System.out.println("Đã xóa nhân viên: " + employeeToRemove.getEmployeeName() + " thành công!");
        } else {
            System.err.println("Không tìm thấy nhân viên có ID: " + employeeId);
        }
    }

     /*
      * listDepartments - show list department
      */
    public void listDepartments() {
        if (departments.isEmpty()) {
            System.err.println("Hện tại không có phòng ban nào.");
            return;
        }

        System.out.println("STT | ID Phòng ban | Tên phòng ban | Số lượng nhân viên");
        System.out.println("---------------------------------------------------");
        for (int i = 0; i < departments.size(); i++) {
            PhongBan department = departments.get(i);
            System.out.printf("%-4d| %-12s | %-14s | %-18d\n",
                    i + 1, department.getDepartmentId(), department.getDepartmentName(), department.totalEmployees());
        }
    }

     /*
      * listEmployees - Show all employee order by department
      */
    public void listEmployees() {
        boolean hasEmployees = false;
        for (PhongBan department : departments) {
            if (!department.getEmployees().isEmpty()) {
                hasEmployees = true;
                break;
            }
        }

        if (!hasEmployees) {
            System.err.println("Không có nhân viên nào.");
            return;
        }

        System.out.println("STT | ID Nhân viên | Tên nhân viên | Tuổi | Thời gian tham gia | Phòng ban");
        System.out.println("---------------------------------------------------------------------");
        int stt = 1;
        for (PhongBan department : departments) {
            for (NhanVien employee : department.getEmployees()) {
                System.out.printf("%-4d| %-12s | %-14s | %-5d | %-13s | %s\n",
                        stt++, employee.getEmployeeId(), employee.getEmployeeName(), employee.getAge(),
                        employee.getJoinDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")), employee.getDepartmentName());
            }
        }
    }

     /*
      * detailEmployee - Show employee detail
      */
    public void detailEmployee(String employeeId) {
        NhanVien employee = getEmployeeById(employeeId);
        if (employee == null) {
            System.err.println("Không tìm thấy nhân viên có ID: " + employeeId);
            return;
        }

        System.out.println("----------------------------------------------");
        System.out.println("----------NHÂN VIÊN: " + employee.getEmployeeName() + "----------");
        System.out.println("----------------------------------------------");
        System.out.println("ID: " + employee.getEmployeeId());
        System.out.println("Tuổi: " + employee.getAge());
        System.out.println("Ngày tham gia: " + employee.getJoinDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        System.out.println("Phòng ban: " + employee.getDepartmentName());
    }

     /*
      * getEmployeeById - Get employee via Id
      */
    public NhanVien getEmployeeById(String employeeId) {
        for (PhongBan department : departments) {
            for (NhanVien employee : department.getEmployees()) {
                if (employee.getEmployeeId().equals(employeeId)) {
                    return employee;
                }
            }
        }
        return null;
    }

     /*
      * getDepartmentById - Get department via Id
      */
    public PhongBan getDepartmentById(String departmentId) {
        for (PhongBan department : departments) {
            if (department.getDepartmentId().equals(departmentId)) {
                return department;
            }
        }
        return null;
    }
}
