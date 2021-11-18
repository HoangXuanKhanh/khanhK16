package vn.SinhVien.DaiHoc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanlySinhVien {
	
	public static ArrayList<SinhVien> list = new ArrayList<>();
	static int automaID = 19140899;
	static Scanner sc = new Scanner(System.in);
	public static void nhapSV() {
		do {
			System.out.println("\n\t========================= CAP NHAT DANH SACH SINH VIEN DAI HOC ============================");
			System.out.println("\t\tXin Moi Ban Lua Chon! 																	   ");
			System.out.println("\t\t1. Them Moi Danh Sach Sinh Vien 														   ");
			System.out.println("\t\t2. Hien Thi Danh Sach Sinh Vien 														   ");
			System.out.println("\t\t3. Sua Danh Sach Sinh Vien 															   	   ");
			System.out.println("\t\t4. Xoa Danh Sach Sinh Vien 															   	   ");
			System.out.println("\t\t5. Sap Xep Danh Sach Sinh Vien 															   ");
			System.out.println("\t\t0. Quay lai					 															   ");
			System.out.print("\tNhap lua chon cua ban: ");
			int chose = Integer.parseInt(sc.nextLine());
			switch(chose) {
			case 1: themDS(); break;
			case 2: hienThiDS(); break;
			case 3: suaDS(); break;
			case 4: xoaDS(); break;
			case 5: sapXepDS(); break;
			case 0: return;
			default: System.out.println("\tLua chon cua ban khong le!  ");	
			}	
		}while(true);
	}
	private static void themDS() {
		System.out.println("\n\t---------------- Them Danh Sach Sinh Vien ---------------");
		System.out.print("\tHo va Ten sinh vien: ");
		String nameT = sc.nextLine();
		if(nameT.trim().length() == 0) {
			System.out.println("\tHo va Ten khong duoc de rong! ");
			return;
		}
		int id = 0;
		while(id < list.size() && nameT.trim().compareToIgnoreCase(list.get(id).getHoTen().trim()) != 0) {
			id++;
		}
		if(id < list.size()) {
			System.out.println("\tTen sinh vien trung trong danh sach! ");
		}		
		System.out.print("\tLop: ");//lop
		String lop = sc.nextLine();
		if(lop.trim().length() == 0) {
			System.out.println("\tLop khong duoc de rong! ");
			return;
		}		
		System.out.print("\tNganh hoc: "); //nganh hoc
		String nganh = sc.nextLine();
		if(nganh.trim().length() == 0) {
			System.out.println("\tNganh hoc khong duoc de rong! ");
			return;
		}
		//khoi tao danh sach giao vien va add vao list
		//ngay sinh
		System.out.println("\tNgay Sinh ");
		System.out.print("\t\tNgay: ");				
		int day = Integer.parseInt(sc.nextLine());
		if(day < 0) {
			System.out.println("\tSo ngay phai duong");
			return;
		}		
		System.out.print("\t\tThang: ");
		int month = Integer.parseInt(sc.nextLine());
		if(month < 0) {
			System.out.println("\tSo thang phai duong");
			return;
		}	
		System.out.print("\t\tNam: ");
		int year = Integer.parseInt(sc.nextLine());
		if(year < 0) {
			System.out.println("\tSo nam phai duong");
			return;
		}		
		System.out.print("\tGioi tinh: ");//gioi tinh
		String gT = sc.nextLine();
		if(gT.trim().length() == 0) {
			System.out.println("\tGioi tinh khong duoc de rong! ");
			return;
		}	
		System.out.print("\tSo dien thoai: ");// so dien thoai
		int soDT = Integer.parseInt(sc.nextLine());
		if(soDT < 0) {
			System.out.println("\tSo dien thoai phai tu 11 so ");
			return;
		}	
		System.out.print("\tGmail: ");//gmail
		String gmail = sc.nextLine();
		if(gmail.trim().length() == 0) {
			System.out.println("\tGmail khong duoc de rong ");
			return;
		}						
		System.out.print("\tDia chi: ");// dia chi
		String dc = sc.nextLine();
		if(dc.trim().length() == 0) {
			System.out.println("\tDia chi khong duoc de rong ");
			return;
		}
		SinhVien sv = new SinhVien(automaID, nameT, lop, nganh, day, month, year, gT, soDT, gmail, dc);
		list.add(sv);
		automaID++;
		System.out.println("\tNhap danh sach sinh vien thanh cong! ");
	}
	private static void hienThiDS() {
		System.out.println("\t\t\t\t\t--------------------------- Danh Sach Sinh Vien ------------------------------");
		System.out.printf("%3s %-18s %-14s %-9s %-12s %-15s %-16s %-25s %-32s %-25s %n", "STT"," Ma Sinh Vien", "Ho va Ten ", " Lop ", "Nganh ", "Ngay Sinh ", "Gioi Tinh ",
							"So Dien Thoai ", "Gmail ", "Dia Chi ");
		int stt = 1;
		for(SinhVien sv : list) {
			System.out.printf("%-3d ", stt++);
			sv.display();
		}
		if(stt == 1) {
			System.out.println("\tDanh sach sinh vien rong! ");
		}
	}
	private static void suaDS() {
		System.out.println("\n\t-------------------- Sua Thong Tin Sinh Vien -----------------------");
		System.out.print("\tNhap maID sinh vien can sua: ");
		int maiD = Integer.parseInt(sc.nextLine());
		int index = indexOf(maiD);
		if(index == -1) {
			System.out.println("\tSinh vien co maID " +index+ " Khong co trong danh sach! ");
			return;
		}
		else {
			System.out.println("\tSinh vien co trong danh sach! ");
		}
		do {
			System.out.println("\n\tChon thong tin can sua! 		");
			System.out.println("\t1. Sua ho va ten sinh vien 		");
			System.out.println("\t2. Sua lop hoc sinh vien 			");
			System.out.println("\t3. Sua nganh hoc sinh vien 		");			
			System.out.println("\t4. Sua ngay sinh sinh vien 		");
			System.out.println("\t5. Sua gioi tinh sinh vien 		");
			System.out.println("\t6. Sua so dien thoai sinh vien 	");
			System.out.println("\t7. Sua gmail sinh vien 			");
			System.out.println("\t8. Sua dia chi sinh vien 			");		
			System.out.println("\t0. Quany lai!   					");
			System.out.print("\tNhap lua chon cua ban: ");
			int chose = Integer.parseInt(sc.nextLine());
			switch(chose) {
			case 1: suaHoTen(index); break;
			case 2: suaLop(index); break;
			case 3: suaNganh(index); break;
			case 4: suaNgaySinh(index); break;
			case 5: suaGioiTinh(index); break;
			case 6: suaSoDT(index); break;
			case 7: suaGmail(index); break;
			case 8: suaDiaChi(index); break;
			case 0: return;
			default: System.out.println("\tLua chon cua ban khong le! ");						
			}	
		}while(true);
	}
	private static void suaHoTen(int index) { // sua ten
		System.out.print("\tHo va Ten: ");
		String nameHt = sc.nextLine();
		if(nameHt.trim().length() == 0) {
			System.out.println("\tHo va ten khong duoc de rong! ");
			return;
		}
		list.get(index).setHoTen(nameHt);
		System.out.println("\tSua ho va ten thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void suaLop(int index) { // sua ten lop
		System.out.print("\tLop: ");
		String lop = sc.nextLine();
		if(lop.trim().length() == 0) {
			System.out.println("\tlop khong duoc de rong! ");
			return;
		}
		list.get(index).setLop(lop);
		System.out.println("\tSua ten Lop thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void suaNganh(int index) { // sua nganh hoc
		System.out.print("\tNganh Hoc: ");
		String ng = sc.nextLine();
		if(ng.trim().length() == 0) {
			System.out.println("\tTen nganh hoc khong duoc de rong! ");
			return;
		}
		list.get(index).setNganh(ng);
		System.out.println("\tSuaDia Chi thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void suaNgaySinh(int index) { // sua ngay sinh
		System.out.println("\tNgay Sinh ");		
		System.out.print("\tNgay: ");
		int day = Integer.parseInt(sc.nextLine());
		if(day < 0) {
			System.out.println("\tNgay phai duong ");
			return;
		}		
		System.out.print("\tThang: ");
		int month = Integer.parseInt(sc.nextLine());
		if(month < 0) {
			System.out.println("\tThang phai duong ");
			return;
		}
		System.out.print("\tNam: ");
		int year = Integer.parseInt(sc.nextLine());
		if(year < 0) {
			System.out.println("\tnam phai duong ");
			return;
		}
		list.get(index).setDay(day);
		list.get(index).setMaID(year);
		list.get(index).setYear(year);
		System.out.println("\tSua ngay sinh thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void suaGioiTinh(int index) {//sua gioi tinh
		System.out.print("\tGioi tinh: ");
		String gt = sc.nextLine();
		if(gt.trim().length() == 0) {
			System.out.println("\tGioi tinh khong duoc de rong! ");
			return;
		}
		list.get(index).setGioiTinh(gt);
		System.out.println("\tSua gioi tinh thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void suaSoDT(int index) { // sua so dien thoai
		System.out.print("\tSo dien thoai: ");
		int soDT = Integer.parseInt(sc.nextLine());
		if(soDT < 0) {
			System.out.println("\tSo dien thoai phai 11 so ");
			return;
		}
		list.get(index).setSoDt(soDT);
		System.out.println("\tSua so dien thoai thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void suaGmail(int index) { // sua gmail
		System.out.print("\tGamil: ");
		String gmail = sc.nextLine();
		if(gmail.trim().length() == 0) {
			System.out.println("\tGmail khong duoc de rong! ");
			return;
		}
		list.get(index).setGmail(gmail);
		System.out.println("\tSua gmail thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void suaDiaChi(int index) { // sua dia chi
		System.out.print("\tDia chi: ");
		String dc = sc.nextLine();
		if(dc.trim().length() == 0) {
			System.out.println("\tDia Chi khong duoc de rong! ");
			return;
		}
		list.get(index).setDiaChi(dc);
		System.out.println("\tSua Dia Chi thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void xoaDS() { // xoa sinh vien theo maID
		System.out.print("\tNhap maID sinh vien can xoa: ");
		int maID = Integer.parseInt(sc.nextLine());
		int index = indexOf(maID);
		if(index == -1) {
			System.out.println("\tSinh vien co maID " +index+ " Khong co trong danh sach ");
			return;
		}
			list.remove(index);
			System.out.println("\tXoa sinh vien thanh cong! ");
			System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");		
	}
	private static void sapXepDS() { //sap sep danh sach
		Collections.sort(list, new Comparator<SinhVien>() {
			@Override
			public int compare(SinhVien o1, SinhVien o2) {				
				return o1.getHoTen().trim().compareToIgnoreCase(o2.getHoTen().trim());
			}
		});;
		System.out.println("\tSap xep sinh vien thanh cong! ");	
		System.out.println("\tHien thi danh sach sap xep sinh vien! ");		
	}
	public static int indexOf(int maID) {
		for(int index = 0; index < list.size(); index++) {
			if(list.get(index).getMaID() == maID) {
				return index;
			}
		}
		return -1;
	}

}
