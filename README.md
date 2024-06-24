# Ứng dụng Quản lý Nhân viên Java

Ứng dụng Java đơn giản để quản lý nhân viên và phòng ban.

## Tính năng

1.  **Quản lý phòng ban:**
    *   Xem danh sách phòng ban (STT, ID, tên, số lượng nhân viên).
    *   Xem chi tiết phòng ban (ID, tên, danh sách nhân viên).
    *   Thêm phòng ban (tên, số lượng nhân viên dự kiến).
    *   Cập nhật thông tin phòng ban (tên).
    *   Xóa phòng ban.

2.  **Quản lý nhân viên:**
    *   Xem danh sách nhân viên (STT, ID, tên, tuổi, ngày giờ tham gia, phòng ban).
    *   Xem chi tiết nhân viên (ID, tên, tuổi, ngày giờ tham gia, phòng ban).
    *   Thêm nhân viên vào phòng ban (tên, tuổi).
    *   Cập nhật thông tin nhân viên (tên, tuổi).
    *   Xóa nhân viên.

## Ràng buộc

*   Tối đa 5 phòng ban.
*   Tối đa 3 nhân viên mỗi phòng ban.

## Cách sử dụng

1.  Chạy file `Main.java` để khởi động ứng dụng.
2.  Chọn các chức năng từ menu để thực hiện các thao tác quản lý.

## Cấu trúc dự án

*   `NhanVien.java`: Lớp đại diện cho một nhân viên.
*   `PhongBan.java`: Lớp đại diện cho một phòng ban.
*   `DepartmentManager.java`: Lớp quản lý danh sách phòng ban và nhân viên.
*   `Main.java`: Lớp chứa hàm `main()` để chạy ứng dụng.

## Công nghệ sử dụng

*   Java
*   java.time (LocalDateTime, DateTimeFormatter)
*   java.util (List, ArrayList, Scanner)

## Tác giả

[hvintuong]
