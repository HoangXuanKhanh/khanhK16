package vn.TimKiemSinhVien.DaiHoc;

import java.util.Scanner;

import vn.BangDiem.DaiHoc.QuanLyBangDiem;
import vn.MonHoc.DaiHoc.MonHoc;
import vn.MonHoc.DaiHoc.QuanLyMonHoc;

public class TimKiemMonHoc {
	static Scanner sc = new Scanner(System.in);
	public static void nhapMH() {
		do {
		System.out.println("\n\t-------------- TIM KIEM THONG TIN MON HOC ---------------");
		System.out.println("\t\tXin Moi Ban Lua Chon.														");	
		System.out.println("\t\t1. Tim Kiem Theo Ma Mon Hoc													");
		System.out.println("\t\t2. Tim Kiem Theo Ma Sinh Vien 												");
		System.out.println("\t\t3. Tim Kiem Theo Ten Mon Hoc												");
		System.out.println("\t\t0. Quay Lai																	");			
		System.out.print("\t\tNhap lua chon cua ban:  ");
		int chose = Integer.parseInt(sc.nextLine());
		switch(chose) {
		case 1: timkiemMaMH(); break;  
		case 2: timkiemMaSV(); break;
		case 3: timkiemTenMH(); break;
		case 0: return;
		default: System.out.println("\tLua chon cua ban khong hop le! ");			
		}
		}while(true);
		}		
	private static void timkiemMaMH() { // tim kiem mon hoc theo ma mon hoc, hien thi bang diem chua mon hoc, sinh vien, diem 
		System.out.println("\n------------ TIM KIEM THEO MA MON HOC -------------");
		System.out.print("\tNhap ma mon hoc can tim: ");
		int idMH = Integer.parseInt(sc.nextLine());
		int index = QuanLyBangDiem.indexOd(idMH);
		if(index == -1 ) {
			System.out.println("\tKhong tim thay ket qua nao!...");
			return;
		}
		System.out.println("\tThong tin mon hoc tim duoc ");
		QuanLyBangDiem.list.get(index).display();				
	}		
	private static void timkiemMaSV() { // tim kiem mon hoc theo ma sinh vien, hien thi bang diem chua mon hoc, sinh vien, diem 
		System.out.println("\n------------ TIM KIEM THEO MA SINH VIEN -------------");
		System.out.print("\tNhap ma sinh vien can tim: ");
		int idSV = Integer.parseInt(sc.nextLine());
		int index = QuanLyBangDiem.indexOd(idSV);
		if(index == -1 ) {
			System.out.println("\tKhong tim thay ket qua nao!...");
			return;
		}
		System.out.println("\tThong tin mon hoc tim duoc ");
		QuanLyBangDiem.list.get(index).display();	
	}		
	private static void timkiemTenMH() { // hien thi mon hoc theo ten mon hoc
		System.out.println("\n------------- TIM KIEM THEO TEN MON HOC ---------------");
		System.out.print("\tNhap ten mon hoc: ");
		String nameMH = sc.nextLine();
		int dem = 0;
		for(MonHoc mh : QuanLyMonHoc.list) {
			if(mh.getTenMh().trim().indexOf(nameMH.trim()) != -1) {
				dem ++;
				System.out.printf("%-3d", dem);					
			}
		}
		if(dem == 0) {
			System.out.println("\tkhong tim thay ket qua nao! ");
			System.out.println("\tLoi do cap nhat he thong, xin vui long nhan vien sua loi! ");
		}
		else {
			System.out.println("\tTim thay " + dem + " Ket qua: ");
		}
	}
}
