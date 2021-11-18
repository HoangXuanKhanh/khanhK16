package vn.TimKiemSinhVien.DaiHoc;
import java.util.Scanner;

import vn.BangDiem.DaiHoc.QuanLyBangDiem;
import vn.GiaoVien.DaiHoc.GiaoVien;
import vn.GiaoVien.DaiHoc.QuanLyGiaoVien;
import vn.MonHoc.DaiHoc.MonHoc;
import vn.MonHoc.DaiHoc.QuanLyMonHoc;
import vn.SinhVien.DaiHoc.QuanlySinhVien;
import vn.SinhVien.DaiHoc.SinhVien;

public class TimKiemSV {
		static Scanner sc = new Scanner(System.in);
		public static void nhapSV() {
			do {
				System.out.println("\n\t------------------- TIM KIEM THONG TIN SINH VIEN -----------------------");
				System.out.println("\t\tXin Moi Ban Lua Chon.														");	
				System.out.println("\t\t1. Tim Kiem Theo Ma Sinh Vien Dai Hoc										");
				System.out.println("\t\t2. Tim Kiem Theo Ma Mon Hoc Dai Hoc											");
				System.out.println("\t\t3. Tim Kiem Theo Ten Sinh Vien Dai Hoc										");
				System.out.println("\t\t4. Tim Kiem Theo Gmail Sinh Vien Dai Hoc									");
				System.out.println("\t\t5. Tim Kiem Theo Dia Chi Sinh Vien Dai Hoc									");
				System.out.println("\t\t0. Quay Lai																	");			
				System.out.print("\t\tNhap lua chon cua ban:  ");
				int chose = Integer.parseInt(sc.nextLine());
				switch(chose) {
				case 1: timKiemMaSV(); break;
				case 2: timKiemMaMH(); break;
				case 3: timKiemTenSV(); break;
				case 4: timKiemGmailSV(); break;
				case 5: timKiemDiaChiSV(); break;
				case 0: return;
				default: System.out.println("\tLua chon cua ban khong hop le! ");
				}
				switch(chose) {				
				}
			}while(true);
		}
		private static void timKiemMaSV() {
			System.out.println("\n------------ TIM KIEM THEO MA SINH VIEN -------------");
			System.out.print("\tNhap ma sinh vien can tim: ");
			int id = Integer.parseInt(sc.nextLine());
			int index = QuanlySinhVien.indexOf(id);
			if(index == -1 ) {
				System.out.println("\tKhong tim thay ket qua nao!...");
				return;
			}
			System.out.println("\tThong tin sinh vien tim duoc ");
			QuanlySinhVien.list.get(index).display();				
		}
		private static void timKiemMaMH() {
			System.out.println("\n------------ TIM KIEM THEO MA MON HOC -------------");
			System.out.print("\tNhap ma mon hoc can tim: ");
			int idMH = Integer.parseInt(sc.nextLine());
			int index = QuanLyBangDiem.indexOd(idMH);
			if(index == -1) {
				System.out.println("\tKhong tim thay ket qua nao!...");
				return;
			}
			System.out.println("\tThong tin sinh vien tim duoc!...");
			QuanLyBangDiem.list.get(index).display();			
		}
		private static void timKiemTenSV() {
			System.out.println("\n---------- TIM KIEM THEO TEN SINH VIEN -------------");
			System.out.print("\tNhap ten sinh vien can tim: ");
			String nameSV = sc.nextLine();
			int dem = 0;
			for(SinhVien sv : QuanlySinhVien.list) {
				if(sv.getHoTen().trim().indexOf(nameSV.trim()) != -1) {
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
		private static void timKiemGmailSV() {
			System.out.println("\n---------- TIM KIEM THEO GMAIL SINH VIEN -------------");
			System.out.print("\tNhap gmail sinh vien can tim: ");
			String gamil = sc.nextLine();
			int dem = 0;
			for(SinhVien g : QuanlySinhVien.list) {
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
		private static void timKiemDiaChiSV() {
			System.out.println("\n------------ TIM KIEM THEO DIA CHI SINH VIEN --------------");
			System.out.print("\tNhap dia chi sinh vien can tim: ");
			String dc = sc.nextLine();
			int dem = 0;
			for(SinhVien s : QuanlySinhVien.list) {
				if(s.getDiaChi().trim().indexOf(dc.trim()) != -1) {
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
