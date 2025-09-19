import java.util.ArrayList;
import java.util.Scanner;

// Lớp Nguoi
class Nguoi {
    private String hoTen248;
    private String ngaySinh248;
    private String soCMND248;

    public Nguoi() {}

    public Nguoi(String hoTen248, String ngaySinh248, String soCMND248) {
        this.hoTen248 = hoTen248;
        this.ngaySinh248 = ngaySinh248;
        this.soCMND248 = soCMND248;
    }

    public void nhapThongTin248(Scanner sc) {
        System.out.print("Nhập họ tên: ");
        hoTen248 = sc.nextLine();
        System.out.print("Nhập ngày sinh: ");
        ngaySinh248 = sc.nextLine();
        System.out.print("Nhập số CMND: ");
        soCMND248 = sc.nextLine();
    }

    public void hienThiThongTin248() {
        System.out.println("Họ tên: " + hoTen248);
        System.out.println("Ngày sinh: " + ngaySinh248);
        System.out.println("Số CMND: " + soCMND248);
    }

    public String getSoCMND248() {
        return soCMND248;
    }
}

// Lớp KhachSan
class KhachSan {
    private Nguoi nguoi248;
    private int soNgayTro248;
    private String loaiPhong248;
    private double giaPhong248;

    public KhachSan() {}

    public void nhapThongTin248(Scanner sc) {
        nguoi248 = new Nguoi();
        System.out.println("== Nhập thông tin khách hàng ==");
        nguoi248.nhapThongTin248(sc);

        System.out.print("Nhập số ngày trọ: ");
        soNgayTro248 = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập loại phòng: ");
        loaiPhong248 = sc.nextLine();

        System.out.print("Nhập giá phòng: ");
        giaPhong248 = Double.parseDouble(sc.nextLine());
    }

    public void hienThiThongTin248() {
        System.out.println("==== Thông tin khách trọ ====");
        nguoi248.hienThiThongTin248();
        System.out.println("Số ngày trọ: " + soNgayTro248);
        System.out.println("Loại phòng: " + loaiPhong248);
        System.out.println("Giá phòng: " + giaPhong248);
    }

    public String getSoCMND248() {
        return nguoi248.getSoCMND248();
    }

    public double tinhTien248() {
        return soNgayTro248 * giaPhong248;
    }
}

// Chương trình chính
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<KhachSan> dsKhachTro248 = new ArrayList<>();

        System.out.print("Nhập số lượng khách trọ: ");
        int n248 = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n248; i++) {
            System.out.println("\n--- Nhập thông tin khách trọ thứ " + (i + 1) + " ---");
            KhachSan ks248 = new KhachSan();
            ks248.nhapThongTin248(sc);
            dsKhachTro248.add(ks248);
        }

        System.out.println("\n===== DANH SÁCH KHÁCH TRỌ =====");
        for (KhachSan ks248 : dsKhachTro248) {
            ks248.hienThiThongTin248();
            System.out.println("---------------------------");
        }

        System.out.print("\nNhập số CMND của khách muốn tính tiền: ");
        String cmndTim248 = sc.nextLine();
        boolean found = false;
        for (KhachSan ks248 : dsKhachTro248) {
            if (ks248.getSoCMND248().equals(cmndTim248)) {
                System.out.println("Tổng tiền cần trả: " + ks248.tinhTien248());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy khách có CMND này.");
        }

        // Xóa khách theo CMND
        System.out.print("\nNhập số CMND khách muốn xóa: ");
        String cmndXoa248 = sc.nextLine();
        dsKhachTro248.removeIf(ks248 -> ks248.getSoCMND248().equals(cmndXoa248));

        System.out.println("\n===== DANH SÁCH SAU KHI XÓA =====");
        for (KhachSan ks248 : dsKhachTro248) {
            ks248.hienThiThongTin248();
            System.out.println("---------------------------");
        }
    }
}
