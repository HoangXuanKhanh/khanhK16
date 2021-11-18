package vn.GiaoVien.DaiHoc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class QuanLyGiaoVien {

	
	public static ArrayList<GiaoVien> list = new ArrayList<>();
	static int automaID = 12345679;
	static Scanner sc = new Scanner(System.in);
	public static void nhapGV() {
	do {
		System.out.println("\n\t=============== CAP NHAT DANH SACH GIAO VIEN DAI HOC ================");
		System.out.println("\t\tXin Moi Ban Lua Chon.  			 ");
		System.out.println("\t\t1. Them Moi Danh sach Giao Vien  ");
		System.out.println("\t\t2. Hien Thi Danh sach Giao Vien  ");
		System.out.println("\t\t3. Sua Danh Sach Giao Vien 		 ");
		System.out.println("\t\t4. Xoa Danh Sach Giao Vien		 ");
		System.out.println("\t\t5. Sap Xep Danh sach Giao Vien	 ");
		System.out.println("\t\t0. Quay Lai						 ");
		System.out.print("\t\tNhap Lua Chon Cua Ban:  ");
		int chose = Integer.parseInt(sc.nextLine());
		switch(chose) {
		case 1: themDS(); break;
		case 2: hienThiDS(); break;
		case 3: suaDS(); break;
		case 4: xoaDS(); break;
		case 5: sapXepDS(); break;
		case 0: return;
		default: System.out.println("\tLua chon cua ban khong hop le! ");		
		}
	}while(true);
	}
	private static void themDS() {
		System.out.println("\n\t-------- Them Danh Sach Giao Vien -----------");
		System.out.print("\tHo va Ten Giao Vien: ");
		String nameGV = sc.nextLine();
		if(nameGV.trim().length() == 0) {
			System.out.println("\tHo va Ten khong duoc de rong! ");
			return;
		}
		int id = 0;
		while(id < list.size() && nameGV.trim().compareToIgnoreCase(list.get(id).getHoTen().trim()) != 0) {
			id++;
		}
		if(id < list.size()) {
			System.out.println("\tTen giao vien trung trong danh sach! ");
			return ;
		}
		//khoi tao danh sach giao vien va add vao list		
		System.out.println("\tNgay Sinh ");//ngay sinh
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
		System.out.print("\tGioi tinh: ");// gioi tinh
		String gt = sc.nextLine();
		if(gt.trim().length() == 0) {
			System.out.println("\tGioi tinh khong duoc de rong ");
			return;
		}		
		System.out.print("\tSo dien thoai: "); // so dien thoai
		int soDT = Integer.parseInt(sc.nextLine());
		if(soDT < 0) {
			System.out.println("\tSo dien thoai phai tu 11 so ");
			return;
		}		
		System.out.print("\tGmail: "); //gmail
		String gmail = sc.nextLine();
		if(gmail.trim().length() == 0) {
			System.out.println("\tGmail khong duoc de rong ");
			return;
		}
		System.out.print("\tDia chi: "); // dia chi
		String dc = sc.nextLine();
		if(dc.trim().length() == 0) {
			System.out.println("\tDia chi khong duoc de rong ");
			return;
		}
		System.out.print("\tTrang thai: "); // trang thai Dang cap nhat;
		String tt = sc.nextLine();
		if(tt.trim().length() == 0) {
			System.out.println("\tTrang thai khong duoc de rong ");
			return;
		}				
		System.out.print("\tChuc vu: "); //chuc vu
		String cv = sc.nextLine();
		if(cv.trim().length() == 0) {
			System.out.println("\tChuc vu khong duoc de rong ");
			return;
		}		
		GiaoVien gv = new GiaoVien(automaID, nameGV, day, month, year, gt, soDT, gmail, dc, tt, cv);
		list.add(gv);
		automaID++;
		System.out.println("\tNhap danh sach giao vien thanh cong!! ");		
	}
	private static void hienThiDS() {
		System.out.println("\n\t\t\t\t\t\t-------------DANH SACH GIAO VIEN ----------------");
		int stt = 1;
		System.out.printf("%3s %-14s %-17s %-15s %-10s %17s %15s %23s %31s %18s %n", "STT ", "Ma Giao Vien ", "Ho va Ten ", "Ngay Sinh ", "Gioi Tinh ",
							"So Dien Thoai ", "Gmail ", "Dia Chi ", "Trang Thai ", " Chuc Vu");
		for(GiaoVien gv : list) {
		System.out.printf("%-3d ", stt++);
		gv.display();
		}
		if(stt == 1) {
			System.out.println("\tDanh sach giao vien rong! ");
		}
	}
	private static void suaDS() {
		System.out.println("\n\t---------------- Sua Thong Tin Giao Vien ---------------");
		System.out.print("\tNhap maID giao vien can sua: ");
		int maID = Integer.parseInt(sc.nextLine());
		int index = indexOf(maID);
		if(index == -1) {
			System.out.println("\tGiao vien co maID " +index+ " Khong co trong danh sach ");
			return;
		}		
		else {
			System.out.println("\tGiao vien co trong danh sach ");
		}
		do {
			System.out.println("\n\tChon thong tin can sua! 		");
			System.out.println("\t1. Sua ho va ten giao vien 		");
			System.out.println("\t2. Sua ngay sinh giao vien 		");
			System.out.println("\t3. Sua gioi tinh giao vien 		");
			System.out.println("\t4. Sua so dien thoai giao vien 	");
			System.out.println("\t5. Sua gmail giao vien 			");
			System.out.println("\t6. Sua dia chi giao vien 			");
			System.out.println("\t7. Sua trang thai giao vien 		");
			System.out.println("\t8. Sua chuc vu giao vien 			");
			System.out.println("\t0. Quany lai!   					");
			System.out.print("\tNhap lua chon cua ban: ");
			int chose = Integer.parseInt(sc.nextLine());
			switch(chose) {
			case 1: suaHoTen(index); break;
			case 2: suaNgaySinh(index); break;
			case 3: suaGioiTinh(index); break;
			case 4: suaSoDT(index); break;
			case 5: suaGmail(index); break;
			case 6: suaDiaChi(index); break;
			case 7: suaTrangThai(index); break;
			case 8: suaChucVu(index); break;
			case 0: return;
			default: System.out.println("\tLua chon cua ban khong le! ");						
			}	
		}while(true);
	}	
	private static void suaHoTen(int index) {
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
	private static void suaNgaySinh(int index) {
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
		list.get(index).setMonth(month);
		list.get(index).setYear(year);
		System.out.println("\tSua ngay sinh thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");
	}
	private static void suaGioiTinh(int index) {
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
	private static void suaSoDT(int index) {
		System.out.print("\tSo dien thoai: ");
		int soDT = Integer.parseInt(sc.nextLine());
		if(soDT < 0) {
			System.out.println("\tSo dien thoai phai 11 so ");
			return;
		}
		list.get(index).setSoDT(soDT);
		System.out.println("\tSua so dien thoai thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");
	}
	private static void suaGmail(int index) {
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
	private static void suaDiaChi(int index) {
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
	private static void suaTrangThai(int index) {
		System.out.print("\tTrang Thai: ");
		String tt = sc.nextLine();
		if(tt.trim().length() == 0) {
			System.out.println("\tTrang Thai khong duoc de rong! ");
			return;
		}
		list.get(index).setTrangThai(tt);
		System.out.println("\tSua trang thai tinh thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");
	}
	private static void suaChucVu(int index) {
		System.out.print("\tChuc vu: ");
		String cv = sc.nextLine();
		if(cv.trim().length() == 0) {
			System.out.println("\tChuc vu khong duoc de rong! ");
			return;
		}
		list.get(index).setChucVu(cv);
		System.out.println("\tSua chuc vu thanh cong ");	
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");
	}
	private static void xoaDS() {
		System.out.println("\n\t--------------- Xoa Thong Tin Giao Vien ----------------");
		System.out.print("\tNhap maID giao vien can xoa: ");
		int maID = Integer.parseInt(sc.nextLine());
		//kiem tra maid giao vien da co trong danh sach hay chua
		int index = indexOf(maID);
		if(index == -1) {
			System.out.println("\tGiao vien co maID " +index+ " khong co trong danh sach");		
		}
		list.remove(index);
		System.out.println("\tXoa giao vien thanh cong! ");
		System.out.println("\tHien thi lai danh sach neu ban muon kiem tra lai! ");	
	}
	private static void sapXepDS() {		
	Collections.sort(list, new Comparator<GiaoVien>() {
		@Override
		public int compare(GiaoVien o1, GiaoVien o2) {
			return o1.getHoTen().trim().compareToIgnoreCase(o2.getHoTen().trim());
		}
	});
		System.out.println("\tSap xep giao vien thanh cong! ");	
		System.out.println("\tHien thi danh sach sap xep giao vien! ");
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
