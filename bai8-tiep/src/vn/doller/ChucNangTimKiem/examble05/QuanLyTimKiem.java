package vn.doller.ChucNangTimKiem.examble05;

import java.util.ArrayList;
import java.util.Scanner;

import vn.doller.QuanLyBanHang.examble04.QuanLyGioHang;
import vn.doller.QuanLyHangHoa.examble03.HangHoa;
import vn.doller.QuanLyHangHoa.examble03.QuanLyHangHoa;
import vn.doller.QuanLyKhachHang.examble04.KhachHang;
import vn.doller.QuanLyKhachHang.examble04.QuanLyKhachHang;
import vn.doller.QuanLyLoaiHang.examble02.LoaiHang;
import vn.doller.QuanLyLoaiHang.examble02.QuanLyLoaiHang;

public class QuanLyTimKiem {

	static Scanner sc = new Scanner(System.in);

	public static void quanLyTimKiem() {
		do {
			System.out.println("\n\t--------------- TIM KIEM THONG TIN ----------------");
			System.out.println("\tChon chuc nang tim kiem. 					");
			System.out.println("\t1. Chon 1 Tim kiem Thong Tin Loai Hang. 	");
			System.out.println("\t2. Chon 2 Tim kiem Thong Tin Hang Hoa.    ");
			System.out.println("\t3. chon 3 Tim kiem Thong Tin Khach Hang.  ");
			System.out.println("\t4. chon 4 Tim kiem Thong Tin Gio Hang.    ");
			System.out.println("\t0. Quay Lai!							    ");
			System.out.print("\tNhap Lua Chon Cua Ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				tkLoaiHang();
				break;
			case 2:
				tkHangHoa();
				break;
			case 3:
				tkKhachHang();
				break;
			case 4:
				tkGioHang();
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua chon cua ban khong hop le!  ");
			}
		} while (true);
	}

	private static void tkLoaiHang() {
		// tim ma khach , tim ten hang, ma loai hang
		do {
			System.out.println("\n\t------------ TIM KIEM THONG TIN LOAI HANG ------------");
			System.out.println("\tCac tieu chi tim kiem.			");
			System.out.println("\t1. Tim Kiem Theo Ma Loai Hang. 	");
			System.out.println("\t2. Tim Kiem Theo Ten Hang. 		");
			System.out.println("\t3. Tim Kiem Theo Ma Khach Hang. 	");
			System.out.println("\t0. Quay lai!						");
			System.out.print("\tLua Chon Cua Ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				timkiemMaLH();
				break;
			case 2:
				timKiemTH();
				break;
			case 3:
				timKiemMKH();
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua cho cua ban khong hop le! ");
			}
		} while (true);
	}

	private static void timkiemMaLH() {
		System.out.println("\n\t----------- Tim kiem Ma Id Loai Hang ---------------");
		System.out.print("\tNhap ma id loai hang: ");
		int maLH = Integer.parseInt(sc.nextLine());
		int index = QuanLyHangHoa.indexOf(maLH);
		if (index == -1) {
			System.out.println("\tKhong co trong danh sach!...");
			return;
		}
		System.out.println("\tThong tin loai hang: ");
		QuanLyHangHoa.list.get(index).display();
	}

	private static void timKiemTH() {
		System.out.println("\n\t----------- Tim Kiem Ten Loai Hang -----------");
		System.out.print("\tNhap ten loai hang: ");
		String nameTenHang = sc.nextLine();
		int dem = 1;
		for (LoaiHang lh : QuanLyLoaiHang.list) {
			if (lh.getName().trim().indexOf(nameTenHang.trim()) != -1) {
				System.out.printf("%-3d ", dem++);
			}
			if (dem == 0) {
				System.out.println("\tkhong co trong danh sach!...");
			}
			System.out.println("\tTim thay " + dem + " Ket qua ");
		}

	}

	private static void timKiemMKH() {
		System.out.println("\n\t---------- TIM KIEM THEO MA HANG -------------");
		System.out.print("\tNhap ma hang (id) can tim: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyHangHoa.indexOf(id);
		if (index == -1) {
			System.out.println("\tKhong tim thay ket qua nao! ");
			return;
		}
		System.out.println("\tThong tin loai hang tim duoc: ");
		QuanLyHangHoa.list.get(index).display();
	}

	// kiem tra hang hoa
	private static void tkHangHoa() {
		do {
			System.out.println("\n\t----------- TIM KIEM THONG TIN HANG HOA ------------");
			System.out.println("\tCac tieu chi tim kiem.	   ");
			System.out.println("\t1. Tim Kiem Theo Ma Hang.	   ");
			System.out.println("\t2. Tim Kiem Theo Ten Hang.   ");
			System.out.println("\t3. Tim Kiem Theo Loai Hang.  ");
			System.out.println("\t4. Tim Kiem Theo Khung Hang. ");
			System.out.println("\t0. Quay lai! ");
			System.out.print("\tLua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				tkThoeMaHang();
				break;
			case 2:
				tkTheoTenHang();
				break;
			case 3:
				tkTheoLoaiHang();
				break;
			case 4:
				tkTheoKhungHang();
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua chon cua ban khong hop le!...");
			}
		} while (true);
	}

	private static void tkThoeMaHang() {
		System.out.println("\n\t---------- TIM KIEM THEO MA HANG -------------");
		System.out.print("\tNhap ma hang (id) can tim: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyHangHoa.indexOf(id);
		if (index == -1) {
			System.out.println("\tKhong tim thay ket qua nao!...");
			return;
		}
		System.out.println("\tThong tin hang hoa tim duoc ");
		QuanLyHangHoa.list.get(index).display();
	}

	private static void tkTheoTenHang() {
		System.out.println("\n\t---------- TIM KIEM THEO TEN HANG -------------");
		System.out.print("\tNhap ten hang (id) can tim: ");
		String name = sc.nextLine();
		int dem = 0;
		for (HangHoa h : QuanLyHangHoa.list) {
			if (h.getName().trim().indexOf(name.trim()) != -1) {
				dem++;
				System.out.printf("%-3d", dem);
			}
		}
		if (dem == 0) {
			System.out.println("\tkhong tim thay ket qua nao! ");
		} else {
			System.out.println("\tTim thay " + dem + "Ket qua: ");
		}
	}

	private static void tkTheoLoaiHang() {
		ArrayList<Integer> listIdlh = new ArrayList<>();
		System.out.println("\n\t---------- TIM KIEM THEO TEN LOAI HANG -------------");
		System.out.print("\tNhap ten loai hang (id) can tim: ");
		String name = sc.nextLine();
		// duyet danh sach loai hang
		for (LoaiHang lh : QuanLyLoaiHang.list) {
			if (lh.getName().trim().indexOf(name.trim()) != -1) {
				listIdlh.add(lh.getId());
			}
		}
		if (listIdlh.size() == 0) {
			System.out.println("\tkhong tim thay ket qua nao! ");
			return;
		}
		// duyet danh sach hang hoa
		System.out.println("\tTim Thay " + listIdlh.size() + " Ket qua: ");
		for (HangHoa h : QuanLyHangHoa.list) {
			// kiem tra idlh cua hang hoa co trong listIdll khong?
			boolean check = false;
			if (listIdlh.indexOf(h.getIdlh()) != -1) {
				h.display();
			}
		}
	}

	private static void tkTheoKhungHang() {
		System.out.println("\n\t---------- TIM KIEM THEO KHUNG GIA -------------");
		System.out.print("\tNhap gia dau: ");
		double firstPrice = Double.parseDouble(sc.nextLine());
		System.out.println("\tNhap gia sau: ");
		double lastPrice = Double.parseDouble(sc.nextLine());
		int dem = 0;

		for (HangHoa h : QuanLyHangHoa.list) {
			if (h.getPrice() >= firstPrice && h.getPrice() <= lastPrice) {
				dem++;
				System.out.printf("%-3d", dem);
				h.display();
			}
		}
		if (dem == 0) {
			System.out.println("\tkhong tim thay ket qua nao! ");
		} else {
			System.out.println("\tTim thay " + dem + " Ket qua! ");
		}
	}

	// ==============================
	private static void tkKhachHang() {
		do {
			System.out.println("\n\t-------------- TIM KIEM KHACH HANG --------------");
			System.out.println("\tMoi ban chon.												");
			System.out.println("\t1. Tim Kiem theo ma khach hang. 							");
			System.out.println("\t2. Tim Kiem theo ten khach hang. 							");
			System.out.println("\t3. Tim Kiem theo ma id loai hang Khach Hang da dat mua. 	");
			System.out.println("\t0. Quay Lai! 												");
			System.out.print("\tNhap lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				timKiemMaKH();
				break;
			case 2:
				timKiemTenKH();
				break;
			case 3:
				timKiemMaIdLH();
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua chon cua ban khong hop le! ");
			}
		} while (true);
	}

	private static void timKiemMaKH() {
		System.out.println("\n\t-------- Tim Kiem Ma khach Hang -------");
		System.out.print("\tNhap ma khach hang: ");
		int idKH = Integer.parseInt(sc.nextLine());
		int index = QuanLyKhachHang.indexOf(idKH);
		if (index == -1) {
			System.out.println("\tKhong co trong danh sach! ");
			return;
		}
		System.out.println("\tThong tin khach hang co trong danh sach: ");
		QuanLyKhachHang.list.get(index).display();

	}

	private static void timKiemTenKH() {
		System.out.println("\n\t------- Tim Kiem Ten khach Hang ------");
		System.out.print("\tNhap ten khach hang: ");
		String namKh = sc.nextLine();
		if (namKh.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong danh sach! ");
			return;
		}
		System.out.println("\tKhach hang co trong danh sach! ");
	}

	private static void timKiemMaIdLH() {
		System.out.println("\n\t---------- Tim Kiem Khach Hang Theo Ma Id Loai Hang --------");
		System.out.print("\tNhap id loai hang: ");
		int idLHKH = Integer.parseInt(sc.nextLine());
		int index = QuanLyLoaiHang.indexOf(idLHKH);
		if (index == -1) {
			System.out.println("\tKhong co trong danh sach! ");
			return;
		}
		System.out.println("\tThong tin khach hang co trong danh sach: ");
		QuanLyLoaiHang.list.get(index).display();

	}

	private static void tkGioHang() {
		// ma gio ma khach
		do {
			System.out.println("\n-------------- TIM KIEM GIO HANG --------------");
			System.out.println("\tMoi ban chon. 								 ");
			System.out.println("\t1. Tim Kiem theo ma gio hang. 				 ");
			System.out.println("\t2. Tim Kiem theo ma id loai hang. 			 ");
			System.out.println("\t3. Tim Kiem theo ten khach hang. 				 ");
			System.out.println("\t0. Quay Lai!								   	 ");
			System.out.print("\tNhap lua chon cua ban: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				timkiemMaGH();
				break;
			case 2:
				timkiemmaIDLH();
				break;
			case 3:
				timkiemTenKh();
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua chon cua ban khong hop le! ");
			}
		} while (true);
	}

	private static void timkiemMaGH() {
		System.out.println("\n\t----------- Tim kiem Ma Id Gio Hang ---------------");
		System.out.print("\tNhap ma id Gio hang: ");
		int idGH = Integer.parseInt(sc.nextLine());
		int index = QuanLyHangHoa.indexOf(idGH);
		if (index == -1) {
			System.out.println("\tKhong co trong danh sach! ");
			return;
		}
		System.out.println("\tDa ton tai thong tin id trong gio hang! ");

	}

	private static void timkiemmaIDLH() {
		System.out.println("\n\t----------- Tim kiem Ma Id Loai Hang ---------------");
		System.out.print("\tNhap ma id loai hang: ");
		int maLH = Integer.parseInt(sc.nextLine());
		int index = QuanLyHangHoa.indexOf(maLH);
		if (index == -1) {
			System.out.println("\tKhong co trong danh sach!...");
			return;
		}
		System.out.println("\tThong tin loai hang: ");
		QuanLyHangHoa.list.get(index).display();

	}

	private static void timkiemTenKh() {
		System.out.println("\n\t------- Tim Kiem Ten khach Hang --------");
		System.out.print("\tNhap ten khach hang: ");
		String namKh = sc.nextLine();
		if (namKh.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong danh sach! ");
			return;
		}
		System.out.println("\tTen Khach hang co trong danh sach! ");
	}
}
