package vn.BangDiem.DaiHoc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import vn.MonHoc.DaiHoc.MonHoc;
import vn.MonHoc.DaiHoc.QuanLyMonHoc;
import vn.SinhVien.DaiHoc.QuanlySinhVien;
import vn.SinhVien.DaiHoc.SinhVien;

public class QuanLyBangDiem {
	public static ArrayList<BangDiem> list = new ArrayList<>();
	static int autoID = 599;
	static Scanner sc = new Scanner(System.in);
	public static void nhapBD() {
		do {		
		System.out.println("\n\t=========================== CAP NHAT DANH SACH BANG DIEM SINH VIEN DAI HOC ==========================");
		System.out.println("\t\tXin Moi Ban Lua Chon.  			 ");
		System.out.println("\t\t1. Them Moi Danh sach bang diem	 ");
		System.out.println("\t\t2. Hien Thi Danh sach bang diem  ");
		System.out.println("\t\t3. Sua Danh Sach bang diem 		 ");
		System.out.println("\t\t4. Xoa Danh Sach bang diem		 ");
		System.out.println("\t\t0. Quay Lai						 ");
		System.out.print("\t\tNhap Lua Chon Cua Ban:  ");
		int chose = Integer.parseInt(sc.nextLine());
		switch(chose) {
		case 1: themBD(); break;
		case 2: hienThi(); break;
		case 3: suaBD(); break;
		case 4: xoaBD(); break;
		case 0: return;
		default: System.out.println("\tLua chon cua ban khong hop le! ");			
		}
		}while(true);
	}
	private static void themBD() { //them sinh vao bang diem
			System.out.println("\n\t-------- Them Danh Sach Bang Diem -----------");
			System.out.print("\tMa mon hoc: ");
			int  maMH = Integer.parseInt(sc.nextLine()) ;
			int indx = QuanLyMonHoc.indexOd(maMH);
			if(indx == -1 ) {
				System.out.println("\tMon hoc khong co trong danh sach! ");
				return;
			}						
			System.out.print("\tNhap ma sinh vien: ");
			int maId = Integer.parseInt(sc.nextLine());
			//liem tra xem maid co trong danh sach sinh vien co ko
			int index = QuanlySinhVien.indexOf(maId);
			if(index == -1 ) {
				System.out.println("\tTen sinh vien khong co trong danh sach! ");
				return;
			}
			System.out.print("\tLop: ");
			String Lop = sc.nextLine();
			if(Lop.trim().length() == 0) {
				System.out.println("\tLop khong duoc de rong! ");
				return;
			}
			System.out.print("\tNganh Hoc: ");
			String ngH = sc.nextLine();
			if(ngH.trim().length() == 0) {
				System.out.println("\tNganh hoc khong duoc de rong! ");
				return;
			}
			System.out.print("\tNam Hoc: ");
			String namHk = sc.nextLine();
			if(namHk.trim().length() == 0) {
				System.out.println("\tNam hoc khong duoc de rong! ");
				return;
			}
			System.out.print("\tDiem Hk 1: ");	
			double diemHKOne = Double.parseDouble(sc.nextLine());
			if(diemHKOne < 0) {
				System.out.println("\tDiem hoc ki 1 khong duoc de rong! ");
				return;
			}
			System.out.print("\tDiem Hk 2: ");	
			double diemHKTwo = Double.parseDouble(sc.nextLine());
			if(diemHKTwo < 0) {
				System.out.println("\tDiem hoc ki 2 khong duoc de rong! ");
				return;
			}			
			BangDiem bd = new BangDiem(maMH, maId, Lop, ngH, namHk, diemHKOne, diemHKTwo);
			list.add(bd);
			autoID++;
				
			System.out.println("\tNhap bang diem sinh vien thanh cong! ");		
	}
	private static void hienThi() { // hien thi danh sach bang diem sinh hoc da hoc 
		System.out.println("\n\t\t\t\t\t\t------------- DANH SACH BANG DIEM ----------------");
		int stt = 1;
		System.out.printf("%3s %-14s %-16s %-12s %13s %14s %16s %18s %19s %n", "STT ", "Mon Hoc ", "Ho va Ten ", "Lop ",
							"Nganh Hoc ", "Nam Hoc ", "Diem HK 1 ", "Diem HK 2 ", " Tong Diem");
		double sum = 0;
		for(BangDiem bd : list) {
		System.out.printf("%-3d ", stt++);
		bd.display();
		sum += bd.tong()/list.size();
		}
		System.out.printf("\n\t\t\t\t\t\t\t\t\t\t\t\t\tTong Diem Ca Nam Hoc:%,8.1f %n", sum);
		if(stt == 1) {
			System.out.println("\tDanh sach mon hoc rong! ");
		}		
	}
	private static void suaBD() { // sua bang diem theo ma mon hoc
		System.out.println("\n\t-------- Sua Danh Sach Bang Diem -----------");
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
			System.out.println("\n\tXin moi ban lua chon! 					");
			System.out.println("\t1. Sua mon hoc theo ma mon (neu can)		");
			System.out.println("\t2. Sua nam hoc 							");
			System.out.println("\t3. Sua diem hoc ki 1 						");
			System.out.println("\t4. Sua diem hoc ki 2 						");
			System.out.println("\t0. Quany lai!   							");
			System.out.print("\tNhap lua chon cua ban: ");
			int chose = Integer.parseInt(sc.nextLine());
			switch(chose) {
			case 1: suaMaMh(index);  break;
			case 2: suaNHK(index); break;
			case 3: suaDiemHKO(index); break;
			case 4: suaDiemHKT(index); break;			
			case 0: return;
			default: System.out.println("\tLua chon cua ban khong le! ");						
				}				
			}while(true);
	}	
		private static void suaMaMh(int index) { // sua ten mon theo ma id mon hoc (neu can), khi sua ma mon roi thi can sua diem hoc ki 1, va hoc ki 2;
			System.out.print("\tNhap ma mon Hoc: ");
			int maMH = Integer.parseInt(sc.nextLine());
			if(maMH < 0) {
				System.out.println("\tKhong duoc de trong! ");
			}
			list.get(index).setiDMonHoc(maMH);
			System.out.println("\tSua thanh cong ");	
			System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");
		}

		private static void suaNHK(int index) {
			System.out.print("\tNhap nam mon hoc: "); // sua namn mon hoc
			String namHk = sc.nextLine();			
			if(namHk.trim().length() == 0 ) {
				System.out.println("\tkhong co de trong! ");
				return;		
				}
			list.get(index).setNamHoc(namHk);
			System.out.println("\tSua thanh cong ");	
			System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
		private static void suaDiemHKO(int index) { // sua diem hoc ki 1 
			System.out.print("\tDiem Hk 1: ");	
			double diemHKOne = Double.parseDouble(sc.nextLine());
			if(diemHKOne < 0) {
				System.out.println("\tDiem hoc ki 1 khong duoc de rong! ");
				return;
			}
			list.get(index).setDiemHKOne(diemHKOne);
			System.out.println("\tSua thanh cong ");	
			System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");	
	}
		private static void suaDiemHKT(int index) { // sua diem hoc ki 2
			System.out.print("\tDiem Hk 2: ");	
			double diemHKTwo = Double.parseDouble(sc.nextLine());
			if(diemHKTwo < 0) {
				System.out.println("\tDiem hoc ki 2 khong duoc de rong! ");
				return;
			}
			list.get(index).setDiemHKTwo(diemHKTwo);
			System.out.println("\tSua thanh cong ");	
			System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");			
	}
		private static void xoaBD() {
			System.out.println("\n\t--------------- Xoa Thong Tin Bang Diem ----------------");
			System.out.print("\tNhap ma mon hoc can xoa: ");
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
	public static int indexOd(int maID) {
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getiDMonHoc() == maID) {
				return index;				
			}
		}
		return -1;
	}

}
