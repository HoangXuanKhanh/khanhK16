package vn.doller.QuanLyChucNangBanHang.examble05;

import java.util.Scanner;

import vn.doller.ChucNangTimKiem.examble05.QuanLyTimKiem;
import vn.doller.QuanLyBanHang.examble04.QuanLyGioHang;
import vn.doller.QuanLyHangHoa.examble03.QuanLyHangHoa;
import vn.doller.QuanLyKhachHang.examble04.QuanLyKhachHang;
import vn.doller.QuanLyLoaiHang.examble02.QuanLyLoaiHang;


public class QuanLyBanHangMenu {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		do {
		System.out.println("\n\t============== CHUONG TRINH QUAN LY BAN HANG ===============");
		System.out.println("\tChon 1 chuc nang quan ly.					 ");
		System.out.println("\t1. Cap Nhat Chuc Nang He Thong.			 ");
		System.out.println("\t2. Quan ly ban Hang.  					 ");
		System.out.println("\t3. Tim Kiem Thong Tin.					 ");
		System.out.println("\t0. Thoat.									 ");				
		System.out.print("\tNhap Lua Chon Cua Ban: ");
		int chon;
		chon = Integer.parseInt(sc.nextLine());
		switch(chon) {
		case 1: capNhatThongTinHeTho(); break;
		case 2: quanLyBanHang(); break;
		case 3: timKiemThongTin(); break;
		case 0: 
			System.out.println("\tDa thoat khoi chuong trinh! ");
			System.exit(0);
			default: System.out.println("\tLua Chon khong Hop Le! ");
		}		
	}while(true);
	}	
	private static void capNhatThongTinHeTho() {
		do {
			System.out.println("\n\t============= CHUC NANG CAP NHAT THONG TIN ===============");
			System.out.println("\tChon Chuc nang Cap Nhat.					 ");
			System.out.println("\t1. Cap Nhat Thong Tin Loai Hang.		 ");
			System.out.println("\t2. Cap Nhat Thong Tin Hang Hoa.		 ");
			System.out.println("\t3. Cap Nhat Thong Tin Khach hang. 		 ");
			System.out.println("\t0. Quay lai! 						     ");			
			System.out.print("\tLua Chon Chuc Nang Muon Cap Nhat: ");
			int chon = Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1: QuanLyLoaiHang.capNhat(); break;
			case 2: QuanLyHangHoa.capNhat(); break;
			case 3: QuanLyKhachHang.capnhat(); break;
			case 0: return;
			default: System.out.print("Lua Chon khong Hop Le! ");
					
			}				
		}
		while(true);		
	}
	
	private static void quanLyBanHang() {
	
		System.out.println("\t----------------- QUAN LY BAN HANG --------------");
		System.out.println("\tChon Chuc Nang Phu Hop. 					");
		System.out.println("\t1. Danh cho khach mua hang.				");
		System.out.println("\t2. Danh cho nguoi quan ly cua hang.		");
		System.out.println("\t0. Quay Lai!								");
		System.out.print("\tLua Chon Chuc Nang Muon Mua: ");
		int chon = Integer.parseInt(sc.nextLine());
		switch(chon) {
		case 1: QuanLyGioHang.khachMuaHang();  break;
		case 2: QuanLyGioHang.thongkeBanHang(); break;
		case 0: return;
		default: System.out.print("\tLua chon khong hop le! ");				
		}					
	}
//xoa thong tin khach hang
	private static void timKiemThongTin() {
		do {
			System.out.println("\n\t--------------- TIM KIEM THONG TIN HANG HOA ----------------");
			System.out.println("\tChon chuc nang tim kiem. 		");
			System.out.println("\t1. Chon 1 Tim kiem Thong Tin. ");
			System.out.println("\t0. Quay Lai!   			    ");
			System.out.print("\tLua Chon Cua Ban: ");
			int chon =Integer.parseInt(sc.nextLine());
			switch(chon) {
			case 1: QuanLyTimKiem.quanLyTimKiem(); break;
			case 0: return;
			default: System.out.println("\tLua Chon Cua Ban khong Hop Le!  ");
			}
		}while(true);
	}
}
