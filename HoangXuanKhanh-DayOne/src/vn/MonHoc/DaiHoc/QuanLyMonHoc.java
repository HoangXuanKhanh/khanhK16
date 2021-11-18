package vn.MonHoc.DaiHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.BangDiem.DaiHoc.BangDiem;
import vn.SinhVien.DaiHoc.QuanlySinhVien;


public class QuanLyMonHoc {
	
	public static ArrayList<MonHoc> list = new ArrayList<>();
	static int automaID = 559;
	static Scanner sc = new Scanner(System.in);

	public static void nhapMH() {
		do {		
		System.out.println("\n\t=========================== CAP NHAT DANH SACH MON HOC SINH VIEN DAI HOC ==========================");
		System.out.println("\t\tXin Moi Ban Lua Chon.  			 ");
		System.out.println("\t\t1. Them Moi Danh sach mon hoc	 ");
		System.out.println("\t\t2. Hien Thi Danh sach mon hoc 	 ");
		System.out.println("\t\t3. Sua Danh Sach mon hoc 		 ");
		System.out.println("\t\t4. Xoa Danh Sach mon hoc		 ");
		System.out.println("\t\t5. Sap Xep Danh sach mon hoc	 ");
		System.out.println("\t\t0. Quay Lai						 ");
		System.out.print("\t\tNhap Lua Chon Cua Ban:  ");
		int chose = Integer.parseInt(sc.nextLine());
		switch(chose) {
		case 1: themMH(); break;
		case 2: hienThi(); break;
		case 3: suaMH(); break;
		case 4: xoaMH(); break;
		case 5: sapXepMH(); break;
		case 0: return;
		default: System.out.println("\tLua chon cua ban khong hop le! ");			
		}
		}while(true);
	}

	private static void themMH() { //them sinh vao bang diem
			System.out.println("\n\t-------- Them Danh Sach Mon Hoc -----------");
			System.out.print("\tMon Hoc: ");
			String nameMH = sc.nextLine();
			if(nameMH.trim().length() == 0) {
				System.out.println("\tMon hoc khong duoc de rong! ");
				return;
			}
			int id = 0;
			while(id < list.size() && nameMH.trim().compareToIgnoreCase(list.get(id).getTenMh().trim()) != 0) {
				id++;
			}
			if(id < list.size()) {
				System.out.println("\tMon hoc da ton tai trong danh sach! ");
				return ;
			}
			
			MonHoc bd = new MonHoc(automaID, nameMH);
			list.add(bd);
			automaID++;
			System.out.println("\tNhap mon hoc sinh vien thanh cong! ");
		
	}
	private static void hienThi() { // hien thi danh sach bang diem sinh hoc da hoc 
		System.out.println("\n-------------DANH SACH MON HOC ----------------");
		int stt = 1;
		System.out.printf("%3s %-14s %-16s %n","STT ", "Ma Mon Hoc ", "Ten Mon Hoc ");
		for(MonHoc mh : list) {
		System.out.printf("%-3d ", stt++);
		mh.display();
		}
		if(stt == 1) {
			System.out.println("\tDanh sach mon hoc rong! ");
		}		
	}
	private static void suaMH() { // sua mon hoc
		System.out.println("\n\t-------- Sua Danh Sach Mon Hoc -----------");
		System.out.print("\tNhap ma mon Hoc can sua: ");
		int maMH = Integer.parseInt(sc.nextLine());
		int index = indexOd(maMH);	
		if(index == -1) {
			System.out.println("\tMon hoc co maID " +index+ " khong co trong danh sach! ");
			return;
		}
		else {
			System.out.println("\tMon hoc co trong danh sach! ");
		}
		do {
			System.out.println("\n\tXin moi ban lua chon! 			");
			System.out.println("\t1. Sua ten mon hoc 				");
			System.out.println("\t0. Quany lai!   					");
			System.out.print("\tNhap lua chon cua ban: ");
			int chose = Integer.parseInt(sc.nextLine());
			switch(chose) {
			case 1: suaTenMH(index); break;		
			case 0: return;
			default: System.out.println("\tLua chon cua ban khong le! ");						
				}				
			}while(true);	
		}	
	private static void suaTenMH(int index) {
		System.out.print("\tNhap ten mon hoc: "); // sua ten ten mon hoc
		String nameHk = sc.nextLine();			
		if(nameHk.trim().length() == 0 ) {
			System.out.println("\tTen sinh vien khong co trong danh sach");
			return;		
			}
		list.get(index).setTenMh(nameHk);
		System.out.println("\tSua thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");
		}
	private static void xoaMH() {//xoa bang diem theo ma  mon hoc
		System.out.println("\n\t--------------- Xoa Thong Tin Bang Diem ----------------");
		System.out.print("\tNhap maID mon hoc can xoa: ");
		int maID = Integer.parseInt(sc.nextLine());
		//kiem tra maid mon hoc da co trong danh sach hay chua
		int index = indexOd(maID);
		if(index == -1) {
			System.out.println("\tMon hoc co maID " +index+ " khong co trong danh sach");		
		}
		list.remove(index);
		System.out.println("\tXoa thanh cong! ");
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");
		
	}
	private static void sapXepMH() { // sap xep 
		Collections.sort(list, new Comparator<MonHoc>() {
			@Override
			public int compare(MonHoc o1, MonHoc o2) {
				return o1.getTenMh().trim().compareToIgnoreCase(o2.getTenMh().trim());
			}
		});
		System.out.println("\tSap xep mon hoc thanh cong! ");	
		System.out.println("\tHien thi danh sach sap xep mon hoc! ");		
	}
	public static int indexOd(int maID) {
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getMaMon() == maID) {
				return index;				
			}
		}
		return -1;
	}

}
