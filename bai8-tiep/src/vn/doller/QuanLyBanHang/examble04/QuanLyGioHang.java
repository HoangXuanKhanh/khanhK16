package vn.doller.QuanLyBanHang.examble04;

import java.util.ArrayList;
import java.util.Scanner;

import vn.doller.QuanLyKhachHang.examble04.KhachHang;
import vn.doller.QuanLyKhachHang.examble04.QuanLyKhachHang;

public class QuanLyGioHang {

	public static ArrayList<GioHang> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static int autoId = 1;

	public static void khachMuaHang() {

		// khoi tao 1 gio hang
		GioHang gio = new GioHang();

		int chon;
		do {
			System.out.println("\n\t----------- CHAO MUNG BAN, MOI BAN MUA HANG -------------");
			System.out.println("\tChon chuc nang mua hang:				");
			System.out.println("\t1. Them hang vao gio. 				");
			System.out.println("\t2. Xem thong tin gio hang. 			");
			System.out.println("\t3. Sua thong tin trong gio hang.   	");
			System.out.println("\t4. Xoa hang trong gio hang.  			");
			System.out.println("\t5. Thanh toan gio hang.		    	");
			System.out.println("\t0. Quay lai!						    ");
			System.out.print("\tmoi chon chuc nang mua hang:  ");

			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				gio.themHangVaoGio();
				break;
			case 2:
				gio.hienThi();
				break;
			case 3:
				gio.suaHangTrongGio();
				break;
			case 4:
				gio.xoaHangTrongGio();
				break;
			case 5:
				thanhToan(gio);
				break;
			case 0:
				gio = null;
				return;

			}
		} while (true);
	}

	// thanh toan gio hang
	public static void thanhToan(GioHang gio) {
		System.out.println("\n\t---------- THANH TOAN GIO HANG -------------");
		gio.setId(autoId++);

		System.out.println("\tLua chon loai khach hang. 										  ");
		System.out.println("\t1. Khach hang da tung mua hang (co thong tin khach trong danh sach. ");
		System.out.println("\t2. khach hang moi. 												  ");
		System.out.print("\tMoi chon: ");
		int chon;
		do {
			System.out.print("\tMoi chon (bam 1 hoac 2 ): ");
			chon = Integer.parseInt(sc.nextLine());

		} while (chon != 1 && chon != 2);
		if (chon == 2) {
			gio.setIdkh(QuanLyKhachHang.autoId++);
			String name;
			do {
				System.out.print("\tNhap ten khach hang: ");
				name = sc.nextLine();
				if (name.trim().length() == 0) {
					System.out.println("\tTen khach hang khong duoc de trong ");
				}
			} while (name.trim().length() == 0);
			// them khach hang moi vao danh khach hang
			QuanLyKhachHang.list.add(new KhachHang(QuanLyKhachHang.autoId++, name));
		} else {// khach tung mua hang chon ==1
			System.out.println("\tNhap id khach hang: ");
			int idkh = Integer.parseInt(sc.nextLine());
			int index1 = QuanLyKhachHang.indexOf(idkh);
			if (index1 == -1) {
				System.out.println("\tKhach hang chua co trong danh sach khach ");
				// tao khach hang moi
				gio.setIdkh(QuanLyKhachHang.autoId);
				String name;

				do {
					System.out.print("\tNhap ten khach hang: ");
					name = sc.nextLine();
					if (name.trim().length() == 0) {
						System.out.println("\tTen khach hang khong duoc de trong! ");
					}

				} while (name.trim().length() == 0);
				// them khach hang moi vao danh sach khach hang
				QuanLyKhachHang.list.add(new KhachHang(QuanLyKhachHang.autoId++, name));
			} else {
				gio.setIdkh(idkh);
			}
		}

		// hien thi hoa don
		gio.hienThiHoaDon();
		// them gio hang vao danh sach quan ly
		list.add(gio);
		System.out.println("\tCam on ban da den voi cua hang, chao than ai. ");
		return;
	}

	// chuc nang danh cho nguoi quan ly;
	// - thong ke cac gio hang
	// - tinh tong doanh thu
	public static void thongkeBanHang() {
		do {
			System.out.println("\n\t-------------- THONG KE BAN HANG ---------------");
			System.out.println("\tCho 1 Chuc nang thong ke. 			  ");
			System.out.println("\t1. Chon 1 Thong ke Danh Sach Gio Hang.  ");
			System.out.println("\t2. Chon 2 Tinh Tong Doanh Thu.          ");
			System.out.println("\t0. Quay lai!  						  ");
			System.out.print("\tNhap lua chon cua ban:  ");
			int chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				thongKeGioHang();
				break;
			case 2:
				tongDoanhThu();
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua chon cua ban khong hop le! ");
			}

		} while (true);
	}

	private static void thongKeGioHang() {
		System.out.println("\n\t--------- DANH SACH CAC GIO HANG -----------");
		for (GioHang gio : list) {
			gio.hienThiHoaDon();
			System.out.println("\n\t-------------------------------------");
		}

	}

	private static void tongDoanhThu() {
		double totalRevenue = 0;
		for (GioHang gio : list) {
			// tinh tong tien moi gio hang
			double sumTotal = 0;
			for (HangBan h : gio.getList()) {
				sumTotal += h.total();
			}
			totalRevenue += sumTotal;
		}
		System.out.println("\tTong cong co: " + list.size() + " gio hang ");
		System.out.printf("\tTong doanh thu la: %,17.1f vnd %n", totalRevenue);
	}
}
