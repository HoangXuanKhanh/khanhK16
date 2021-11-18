package vn.doller.QuanLyLoaiHang.examble02;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.doller.QuanLyHangHoa.examble03.QuanLyHangHoa;

public class QuanLyLoaiHang {

	public static ArrayList<LoaiHang> list = new ArrayList<>();

	static int autoId = 1;
	static Scanner sc = new Scanner(System.in);

	public static void capNhat() {
		int chon;
		do {
			System.out.println("\n\t------------ CAP NHAT THONG TIN LOAI HANG ---------------");
			System.out.println("\tLua chon chuc nang cap nhat loai hang. 	");
			System.out.println("\t1. them moi loai hang.	 				");
			System.out.println("\t2. Hien thi danh sach loai hang.	 		");
			System.out.println("\t3. Sua thong tin loai hang.	 			");
			System.out.println("\t4. Xoa thong tin loai hang.				");
			System.out.println("\t5. Sap Xep danh sach loai hang.			");
			System.out.println("\t0. Quay Lai! 								");
			System.out.print("\tNhap lua chon cua ban: ");
			chon = Integer.parseInt(sc.nextLine());
			switch (chon) {
			case 1:
				themLoaiHang();
				break;
			case 2:
				hienThiDS();
				break;
			case 3:
				suaLoaiHang();
				break;
			case 4:
				xoaLoaiHang();
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

	private static void themLoaiHang() {
		System.out.println("\n\t------------- THEM LOAI HANG MOI --------------");
		System.out.println("\tNhap thong Tin Loai Hang Moi. ");
		System.out.print("\tNhap Ten Loai Hang: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\tTen khong duoc de trong danh sach! ");
			return;
		}
		// kiem tra xem ten da ton tai trong danh sach hay chua?
		int i = 0;
		while (i < list.size() && name.trim().compareToIgnoreCase(list.get(i).getName().trim()) != 0) {
			i++;
		}
		if (i < list.size()) {
			System.out.println("\tTen Loai hang da co trong danh sach loai hang! ");
			return;
		}
		// khoi tao so luong loai hang va add vao list
		LoaiHang lh = new LoaiHang(autoId, name);
		list.add(lh);
		autoId++;
		System.out.println("\tThem Loai Hang Thanh Cong1 ");
	}

	private static void hienThiDS() {
		System.out.println("\t---------- DANH SACH LOAI HANG --------------");
		System.out.printf("\t%3s %-10s %-15s %n", "STT", " Ma LH", "Ten Loai Hang");
		int stt = 1;
		for (LoaiHang lh : list) {
			System.out.printf("\t%-3d ", stt++);
			lh.display();
		}
		if (stt == 1) {
			System.out.printf("\tDanh Sach loai hang rong! ");
		}

	}

	private static void suaLoaiHang() {
		System.out.println("\n\t---------- DANH SACH SUA THONG TIN LOAI HANG --------------");
		System.out.print("\tNhap id loai hang can sua: ");
		int id = Integer.parseInt(sc.nextLine());

		// tim xem loai hang void id vua nhap co trong danh sach khong
		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tLoai hang khong co trong danh sach! ");
			return;
		}
		System.out.print("\tNhap loai hang: ");
		String name = sc.nextLine();
		if (name.trim().length() == 0) {
			System.out.println("\tTen loai hang khong duoc de trong! ");
			return;
		}
		// kiem tra xem ten da ton tai trong danh sach hay chua?
		int i = 0;
		while (i < list.size() && name.trim().compareToIgnoreCase(list.get(i).getName().trim()) != 0) {
			i++;
		}
		if (i < list.size()) {
			System.out.println("\tLoai hang da co trong danh sach loai hang1 ");
			return;
		}
		list.get(index).setName(name);
		System.out.print("\t Sua ten loai hang thanh cong! ");

	}

	private static void xoaLoaiHang() {
		System.out.println("\n\t------------ DANH SACH Xoa THONG LOAI HANG --------------");
		System.out.print("\tNhap id loai hang can Xoa: ");
		int id = Integer.parseInt(sc.nextLine());

		// tim xem loai hang void id vua nhap co trong danh sach khon
		int index = indexOf(id);
		if (index == -1) {
			System.out.println("\tLoai hang khong co trong danh sach! ");
			return;
		}

		// co thi kiem tra xem loai hang da su trong danh sach hay chua?
		int i = 0;
		while (i < QuanLyHangHoa.list.size() && QuanLyHangHoa.list.get(i).getIdlh() != id) {
			i++;
		}
		if (i < QuanLyHangHoa.list.size()) {
			System.out.println("\tLoai hang da su dung trong danh sach hang hoa, khong the xoa");
			return;
		}
		list.remove(index);
		System.out.print("\tXoa loai hang thanh cong! ");
	}

	private static void sapXepDS() {
		Collections.sort(list, new Comparator<LoaiHang>() {
			@Override
			public int compare(LoaiHang o1, LoaiHang o2) {
				return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
			}
		});

	}

	// ham nhan vao id tra va index neu co id trong danh sach, nguoc lai tra ve -1;
	public static int indexOf(int id) {
		for (int index = 0; index < list.size(); index++) {
			if (list.get(index).getId() == id) {
				return index;
			}
		}
		return -1;
	}
}
