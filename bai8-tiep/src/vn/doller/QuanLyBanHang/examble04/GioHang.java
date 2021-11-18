package vn.doller.QuanLyBanHang.examble04;

import java.util.ArrayList;
import java.util.Scanner;

import jdk.jfr.DataAmount;
import vn.doller.QuanLyHangHoa.examble03.QuanLyHangHoa;
import vn.doller.QuanLyKhachHang.examble04.QuanLyKhachHang;

public class GioHang {

	private int id;
	private int idkh;
	private ArrayList<HangBan> list = new ArrayList<>();

	public GioHang() {
		super();
	}

	public GioHang(int id, int idkh, ArrayList<HangBan> list) {
		super();
		this.id = id;
		this.idkh = idkh;
		this.list = list;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdkh() {
		return idkh;
	}

	public void setIdkh(int idkh) {
		this.idkh = idkh;
	}

	public ArrayList<HangBan> getList() {
		return list;
	}

	public void setList(ArrayList<HangBan> list) {
		this.list = list;
	}

	Scanner sc = new Scanner(System.in);

	public void themHangVaoGio() {
		System.out.println("\n\t----------- Them hang vao gio -------------");
		System.out.print("\tNhap ma hang hoa can them vao gio: ");
		int idhh = Integer.parseInt(sc.nextLine());
		// kiem tra xem ma hang hoa co trong danh sach hay khong?
		int index1 = QuanLyHangHoa.indexOf(idhh);
		if (QuanLyHangHoa.indexOf(idhh) == -1) {
			System.out.println("\tHang hoa khong co de ban! ");
			return;
		}
		System.out.print("\tNhap so luong muon mua: ");
		double amount = Double.parseDouble(sc.nextLine());
		if (amount < 0) {
			System.out.println("\tSo luong mua phai duong! ");
			return;
		}
		// tim hang hoa trong gio?
		int index2 = indexOf(idhh);
		if (index2 == -1) {
			// truong hop 1 hang moi vua chon chua co trong gio
			// kiem tra so luong vuot qua so luong co trong danh sach hang ban

			if (amount > QuanLyHangHoa.list.get(index1).getAmount()) {
				System.out.println("\tSo hang hien tai khong du de ban! ");
				return;
			}
			list.add(new HangBan(idhh, amount));
			System.out.println("\tThem hang hoa thanh cong! ");
		} else {// truong hop 2 hang vua chon da co trong gio
			double newAmount = amount + list.get(index2).getAmount();
			if (amount + list.get(index2).getAmount() > QuanLyHangHoa.list.get(index1).getAmount()) {
				System.out.println("\tSo hang hien tai khong du de ban! ");
				return;
			}
			list.get(index2).setAmount(newAmount);
			System.out.println("\tThem hang hoa thanh cong ");
		}
	}

	// hien thi gio hang
	public void hienThi() {
		System.out.println("\n\t-------------- GIO HANG CUA BAN -------------");
		System.out.println("\t\t\tDanh sach hang hoa");
		int stt = 1;
		double sumOfTatal = 0;
		System.out.printf("\t%3s %-16s %-13s %-16s %-22s %n", "STT", "Ten hang hoa", "So luong", "Don gia",
				"Thanh Tien");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("\t%-3d ", stt++);
			list.get(i).display();
			sumOfTatal += list.get(i).total();
		}
		System.out.printf("\t\t\t\t\t\tThanh Tien: %,12.1fvnd %n", sumOfTatal);
	}

	// sua thong tin hang trong gio
	public void suaHangTrongGio() {
		System.out.println("\n\t----------- Sua Hang Hoa Trong Gio ------------");
		System.out.print("\tNhap ma hang can sua! ");
		int idhh = Integer.parseInt(sc.nextLine());
		int index = indexOf(idhh);
		if (index == -1) {
			System.out.println("\tHang hoa khong co trong gio! ");
			return;
		}
		System.out.print("\tNhap so luong moi: ");
		double newAmount = Double.parseDouble(sc.nextLine());
		if (newAmount <= 0) {
			System.out.println("\tSo luong hang hoa phai la so duong! ");
			return;
		}
		int index1 = QuanLyHangHoa.indexOf(idhh);
		if (newAmount > QuanLyHangHoa.list.get(index).getAmount()) {
			System.out.println("\tSo luong hang hoa khong du de ban! ");
			return;
		}
		list.get(index1).setAmount(newAmount);
		System.out.println("\tSua thong tin trong gio hang thanh cong! ");
	}

	// xoa hang hoa tron gio
	public void xoaHangTrongGio() {
		System.out.println("\n\t----------- Xoa So Luong Trong Gio Hang ------------");
		System.out.print("\tNhap ma hang hoa can xoa: ");
		int idhh = Integer.parseInt(sc.nextLine());
		int index = indexOf(idhh);
		if (index == -1) {
			System.out.println("\tHang hoa khong co trong gio! ");
			return;
		}
		list.remove(index);
		System.out.println("\tXoa hang trong gio thanh cong! ");
	}

	public void hienThiHoaDon() {
		System.out.println("\n\t-------------- HOA DON BAN LE -------------");
		System.out.print("\tMa hoa don: " + id);// tam su dung la ma gio hang
		// truy van ten khach hang trong danh sach khach hang thong qua idkh;

		int index = QuanLyHangHoa.indexOf(idkh);
		if (index == -1) {
			return;
		}

		System.out.println("\tTen Khach hang: " + QuanLyKhachHang.list.get(index).getName());

		System.out.println("\tDanh sach hang hoa");
		int stt = 1;
		double sumOfTotal = 0;
		System.out.printf("\t%3s %-25s %-8s %-13s %-14s %n", "STT", "Ten hang hoa", "So luong", "Don gia",
				"Thanh Tien");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("\t%-3d ", stt++);
			list.get(i).display();
			sumOfTotal += list.get(i).total();
		}
		System.out.printf("\t\t\t\t\tThanh Tien: %,10.2f vnd %n", sumOfTotal);

	}

	// ham kiem tra hang hoa da co trong gio hay chua
	int indexOf(int idhh) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getIdhh() == idhh) {
				return i;
			}
		}
		return -1;
	}

}
