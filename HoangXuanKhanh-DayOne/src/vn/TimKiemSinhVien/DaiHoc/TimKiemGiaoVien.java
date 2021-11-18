package vn.TimKiemSinhVien.DaiHoc;

import java.util.Scanner;

import vn.GiaoVien.DaiHoc.GiaoVien;
import vn.GiaoVien.DaiHoc.QuanLyGiaoVien;

public class TimKiemGiaoVien {
	static Scanner sc = new Scanner(System.in);
	public static void nhapGV() {
			do {
				System.out.println("\n\t------------------- TIM KIEM THONG TIN GIAO VIEN -----------------------");
				System.out.println("\t\tXin Moi Ban Lua Chon.														");	
				System.out.println("\t\t1. Tim Kiem Theo Ma Giao Vien Dai Hoc										");
				System.out.println("\t\t2. Tim Kiem Theo Ten Giao Vien Dai Hoc										");
				System.out.println("\t\t3. Tim Kiem Theo Gmail Giao Vien Dai Hoc									");
				System.out.println("\t\t4. Tim Kiem Theo Dia Chi Giao Vien Dai Hoc									");
				System.out.println("\t\t0. Quay Lai																	");			
				System.out.print("\t\tNhap lua chon cua ban:  ");
				int chose = Integer.parseInt(sc.nextLine());
				switch(chose) {
				case 1: timKiemMaGV(); break;
				case 2: timKiemTenGV(); break;
				case 3: timKiemGmailGV(); break;
				case 4: timKiemDiaChi(); break;
				case 0: return;
				default: System.out.println("\tLua chon cua ban khong hop le! ");
				}
				switch(chose) {					
				}
			}while(true);
	}
	private static void timKiemMaGV() {
		System.out.println("\n------------ TIM KIEM THEO MA GIAO VIEN -------------");
		System.out.print("\tNhap ma giao vien can tim: ");
		int id = Integer.parseInt(sc.nextLine());
		int index = QuanLyGiaoVien.indexOf(id);
		if(index == -1 ) {
			System.out.println("\tKhong tim thay ket qua nao!...");
			return;
		}
		System.out.println("\tThong tin giao vien tim duoc ");
		QuanLyGiaoVien.list.get(index).display();				
	}
	private static void timKiemTenGV() {
		System.out.println("\n---------- TIM KIEM THEO TEN GIAO VIEN -------------");
		System.out.print("\tNhap ten giao vien can tim: ");
		String name = sc.nextLine();
		int dem = 0;
		for(GiaoVien gv : QuanLyGiaoVien.list) {
			if(gv.getHoTen().trim().indexOf(name.trim()) != -1) {
				dem ++;
				System.out.printf("%-3d", dem);					
			}
		}
		if(dem == 0) {
			System.out.println("\tkhong tim thay ket qua nao!... ");
		}
		else {
			System.out.println("\tTim thay " + dem + " Ket qua: ");
		}									
	}
	private static void timKiemGmailGV() {
		System.out.println("\n---------- TIM KIEM THEO GMAIL GIAO VIEN -------------");
		System.out.print("\tNhap gmail giao vien can tim: ");
		String gamil = sc.nextLine();
		int dem = 0;
		for(GiaoVien g : QuanLyGiaoVien.list) {
			if(g.getGmail().trim().indexOf(gamil.trim()) != -1) {
				dem ++;
				System.out.printf("%-3d", dem);					
			}
		}
		if(dem == 0) {
			System.out.println("\tkhong tim thay ket qua nao!... ");
		}
		else {
			System.out.println("\tTim thay " + dem + " Ket qua: ");
		}			
	}
	private static void timKiemDiaChi() {
		System.out.println("\n---------- TIM KIEM THEO DIA CHI GIAO VIEN -------------");
		System.out.print("\tNhap dia chi giao vien can tim: ");
		String dc = sc.nextLine();
		int dem = 0;
		for(GiaoVien d : QuanLyGiaoVien.list) {
			if(d.getDiaChi().trim().indexOf(dc.trim()) != -1) {
				dem ++;
				System.out.printf("%-3d", dem);					
			}
		}
		if(dem == 0) {
			System.out.println("\tkhong tim thay ket qua nao! ");
		}
		else {
			System.out.println("\tTim thay " + dem + " Ket qua: ");
		}			
	}
}
