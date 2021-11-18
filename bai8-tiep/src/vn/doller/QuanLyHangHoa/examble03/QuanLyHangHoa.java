package vn.doller.QuanLyHangHoa.examble03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.doller.QuanLyLoaiHang.examble02.LoaiHang;
import vn.doller.QuanLyLoaiHang.examble02.QuanLyLoaiHang;

public class QuanLyHangHoa {

	public static ArrayList<HangHoa> list = new ArrayList<>();
	static int autoId = 1;
	static Scanner sc = new Scanner(System.in);

	public static void capNhat() {
		int chon;
		do {
			System.out.println("\n\t------------ CAP NHAT THONG TIN HANG HOA ---------------");
			System.out.println("\tLua chon chuc nang cap nhat hang hoa. 	");
			System.out.println("\t1. them moi hang hoa. 	 				");
			System.out.println("\t2. Hien thi danh sach hang hoa.			");
			System.out.println("\t3. Sua thong tin hang hoa.				");
			System.out.println("\t4. Xoa thong tin hang hoa.				");
			System.out.println("\t5. Sap Xep danh sach hang hoa.			");
			System.out.println("\t0. Quay Lai! 								");
			System.out.print("\tNhap lua chon cua ban...");
			chon = Integer.parseInt(sc.nextLine());

			switch (chon) {
			case 1:
				themHangHoa();
				break;
			case 2:
				hienThiDS();
				break;
			case 3:
				suaHangHoa();
				break;
			case 4:
				xoaHangHoa();
				break;
			case 5:
				sapXepDS();
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua chon cua ban khong hop le! ");
			}

		} while (true);
	}

	private static void themHangHoa() {
		System.out.println("\n\t-------- HEM HANG HOA MOI VAO DANH SACH ---------");

		System.out.print("\tChon ma loai hang: ");
		int idlh = Integer.parseInt(sc.nextLine());
		// kiem tra xem id co trong danh sach loai hang hoa ko
		int index = QuanLyLoaiHang.indexOf(idlh);
		if (index == -1) {
			System.out.println("\tLoai hang khong co trong danh sach! ");
			return;
		}
		System.out.print("\tNhap ten hang hoa: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\tkhong duoc de trong ");
			return;
		}
		System.out.print("\tNhap so luong cua hang hoa: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount < 0) {
			System.out.println("\tSo luong phai khong am. ");
			return;
		}
		System.out.print("\tNhap don gia cua hang hoa: ");
		double price = Double.parseDouble(sc.nextLine());
		if (price < 0) {
			System.out.println("\tDon gia phai khong am. ");
			return;
		}
		// khoi tao doi tuong moi va them vao danh sach list
		HangHoa hh = new HangHoa(autoId, idlh, name, amount, price);
		list.add(hh);
		autoId++;
		System.out.println("\tthem hang hoa thanh cong! ");

	}

	private static void hienThiDS() {
		System.out.println("\t\t\t\t----------DANH SACH HANG HOA--------------");
		System.out.printf("\t%3s %-10s %-14s %-15s %8s %13s %18s %n", "STT", "Ma hang", "Ten loai hang", "Ten hang hoa",
				"So luong", "Don gia", "Thanh tien");
		int stt = 1;
		for (HangHoa hh : list) {
			System.out.printf("\t%-3d ", stt++);
			hh.display();
		}
		if (stt == 1) {
			System.out.println("\tDanh sach hang hoa rong!");
		}
	}

	private static void suaHangHoa() {
		int chon;
		System.out.println("\n\t------------- Sua Thong Tin Hang Hoa ----------------");
		System.out.print("\tNhap id hang hoa can sua: ");
		int id = Integer.parseInt(sc.nextLine());

		// kiem tra hang hoa trong danh sach
		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tHang hoa co id = " + index + " Khong co hang trong danh sach");
			return;
		}
		do {
			System.out.println("\n\tChon thong tin hang can sua: ");
			System.out.println("\t1. Sua ten hang hoa. ");
			System.out.println("\t2. Sua so luong.     ");
			System.out.println("\t3. Sua don gia.      ");
			System.out.println("\t4. Sua ma loai hang. ");
			System.out.println("\t0. Quay Lai! 	       ");
			System.out.print("\tLua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				suaTenHang(index);
				break;
			case 2:
				suaSoLuong(index);
				break;
			case 3:
				suaDonGia(index);
				break;
			case 4:
				suaMaLoaiHang(index);
				break;
			case 0:
				return;
			default:
				System.out.println("\tLua chon cua ban khong hop le! ");
			}

		} while (true);
	}

	private static void suaTenHang(int index) {
		System.out.print("\tNhap ten moi cho hang hoa: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong! ");
			return;
		}
		list.get(index).setName(name);
		System.out.println("\tSua ten thanh cong! ");
	}

	private static void suaSoLuong(int index) {
		System.out.print("\tNhap so luong moi cho hang hoa: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount < 0) {
			System.out.println("\tSo luong phai khong am. ");
			return;
		}
		list.get(index).setAmount(amount);
		System.out.println("\tSua so luong thanh cong! ");
	}

	private static void suaDonGia(int index) {
		System.out.print("\tNhap don gia moi cho hang hoa: ");
		double price = Double.parseDouble(sc.nextLine());
		if (price < 0) {
			System.out.println("\tDon gia phai khong am. ");
			return;
		}
		list.get(index).setAmount(price);
		System.out.println("\tSua don gia thanh cong1 ");
	}

	private static void suaMaLoaiHang(int index) {
		System.out.print("\tNhap ma loai hang moi: ");
		int idLH = Integer.parseInt(sc.nextLine());
		if (QuanLyLoaiHang.indexOf(idLH) == -1) {
			System.out.println("\tMa loai hang vua nhap khong co trong danh sach loai hang! ");
			return;
		}
		list.get(index).setIdlh(idLH);
		System.out.println("\tSua thong tin ma loai hang thanh cong! ");
	}

	private static void xoaHangHoa() {
		System.out.println("\n\t------------- Xoa Thong Tin Hang Hoa ----------------");
		System.out.print("\tNhap id hang hoa can xoa: ");
		int id = Integer.parseInt(sc.nextLine());
		// kiem tra hang hoa trong danh sach
		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tHang hoa co id = " + index + " Khong co hang trong danh sach");
			return;
		}
		list.remove(index);
		System.out.print("\tXoa hang hoa thanh cong! ");
	}

	private static void sapXepDS() {
		Collections.sort(list, new Comparator<HangHoa>() {
			@Override
			public int compare(HangHoa o1, HangHoa o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});

	}

	// ham nhan vao id tra va index neu co ib trong danh sach, nguoc lai tra ve -1;
	public static int indexOf(int id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
}
