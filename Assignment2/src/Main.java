import vn.edu.likelion.services.DepartmentManager;

import javax.swing.text.StyledEditorKit;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static DepartmentManager departmentManager = new DepartmentManager();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.print("====================================================");
            System.out.print("\n===================== LIKELION =====================");
            System.out.println("\n======= QUẢN LÝ NHÂN VIÊN CỦA CÁC PHÒNG BAN ========");
            System.out.println("====================================================");
            System.out.printf("%-30s %-30s\n", "1. Xem danh sách phòng ban", "6. Cập nhật phòng ban");
            System.out.printf("%-30s %-30s\n", "2. Xem chi tiết phòng ban", "7. Xóa phòng ban");
            System.out.printf("%-30s %-30s\n", "3. Xem danh sách nhân viên", "8. Thêm nhân viên");
            System.out.printf("%-30s %-30s\n", "4. Xem chi tiết nhân viên", "9. Cập nhật nhân viên");
            System.out.printf("%-30s %-30s\n", "5. Thêm phòng ban", "10. Xóa nhân viên");
            System.out.println("                      0. Thoát");
            System.out.print("Vui lòng chọn: ");

            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập số.");
                continue;
            }
            scanner.nextLine();

            switch (choice) {
                case 1:// Show department list
                    departmentManager.listDepartments();
                    break;
                case 2:// Show department detail via Id
                    System.out.print("Nhập ID phòng ban: ");
                    String departmentIdToDetail = scanner.nextLine();
                    if (departmentManager.getDepartmentById(departmentIdToDetail) != null) {
                        departmentManager.detailDepartment(departmentIdToDetail);
                    } else {
                        System.out.println("Phòng ban không tồn tại.");
                    }
                    break;
                case 3:// Show employee list
                    departmentManager.listEmployees();
                    break;
                case 4:// Show employee detail via Id
                    System.out.print("Nhập ID nhân viên: ");
                    String employeeIdToDetail = scanner.nextLine();
                    if (departmentManager.getEmployeeById(employeeIdToDetail) != null) {
                        departmentManager.detailEmployee(employeeIdToDetail);
                    } else {
                        System.out.println("Nhân viên không tồn tại.");
                    }
                    break;
                case 5: // Add department
                    if (departmentManager.getDepartments().size() >= 5) {
                        System.out.println("Bạn chỉ có thể thêm tối đa 5 phòng ban.");
                    } else {
                        System.out.print("Nhập tên phòng ban: ");
                        String departmentName = scanner.nextLine();

                        int expectEmployees;
                        while (true) {
                            System.out.print("Nhập số lượng nhân viên dự kiến (tối đa 3): ");
                            try {
                                expectEmployees = scanner.nextInt();
                                if (expectEmployees >= 0 && expectEmployees <= 3) {
                                    break;
                                } else {
                                    System.out.println("Số lượng nhân viên dự kiến phải từ 0 đến 3.");
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Số lượng nhân viên không hợp lệ. Vui lòng nhập số:");
                                scanner.next();
                            }
                        }
                        scanner.nextLine();

                        departmentManager.addDepartment(departmentName, expectEmployees);
                    }
                    break;
                case 6: // Update department
                    System.out.print("Nhập ID phòng ban cần cập nhật: ");
                    String departmentIdToUpdate = scanner.nextLine();
                    if (departmentManager.getDepartmentById(departmentIdToUpdate) != null) {
                        departmentManager.updateDepartment(departmentIdToUpdate);
                    } else {
                        System.out.println("Phòng ban không tồn tại.");
                    }
                    break;
                case 7: // Delete department
                    System.out.print("Nhập ID phòng ban cần xóa: ");
                    String departmentIdToDelete = scanner.nextLine();
                    if (departmentManager.getDepartmentById(departmentIdToDelete) != null) {
                        departmentManager.deleteDepartment(departmentIdToDelete);
                    } else {
                        System.out.println("Phòng ban không tồn tại.");
                    }
                    break;
                case 8: // Add employee via department Id
                    System.out.print("Nhập ID phòng ban để thêm nhân viên: ");
                    String departmentIdToAddEmployee = scanner.nextLine();
                    if (departmentManager.getDepartmentById(departmentIdToAddEmployee) != null) {
                        departmentManager.addEmployee(departmentIdToAddEmployee);
                    } else {
                        System.out.println("Phòng ban không tồn tại.");
                    }
                    break;
                case 9: // Update employee
                    System.out.print("Nhập ID nhân viên cần cập nhật: ");
                    String employeeIdToUpdate = scanner.nextLine();
                    if (departmentManager.getEmployeeById(employeeIdToUpdate) != null) {
                        departmentManager.updateEmployee(employeeIdToUpdate);
                    } else {
                        System.out.println("Nhân viên không tồn tại.");
                    }
                    break;
                case 10: // Delete employee
                    System.out.print("Nhập ID nhân viên cần xóa: ");
                    String employeeIdToDelete = scanner.nextLine();
                    if (departmentManager.getEmployeeById(employeeIdToDelete) != null) {
                        departmentManager.deleteEmployee(employeeIdToDelete);
                    } else {
                        System.out.println("Nhân viên không tồn tại.");
                    }
                    break;
                case 0:
                    System.out.println("Kết thúc chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}