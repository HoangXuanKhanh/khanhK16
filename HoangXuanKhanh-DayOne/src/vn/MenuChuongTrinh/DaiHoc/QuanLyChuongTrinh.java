package vn.MenuChuongTrinh.DaiHoc;

import java.util.Scanner;

import vn.BangDiem.DaiHoc.QuanLyBangDiem;
import vn.GiaoVien.DaiHoc.QuanLyGiaoVien;
import vn.MonHoc.DaiHoc.QuanLyMonHoc;
import vn.SinhVien.DaiHoc.QuanlySinhVien;
import vn.TimKiemSinhVien.DaiHoc.TimKiemGiaoVien;
import vn.TimKiemSinhVien.DaiHoc.TimKiemMonHoc;
import vn.TimKiemSinhVien.DaiHoc.TimKiemSV;

public class QuanLyChuongTrinh {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//cap nhat he thong dai hoc 
		//tim kiem danh muc he thong truong hoc
		do {
			System.out.println("\n\t=========================== CHUONG TRINH DAO TAO DAI HOC ==========================");
			System.out.println("\t\tXin Moi Ban Lua chon. 															   ");
			System.out.println("\t\t1. Cap Nhat He Thong Truong Dai Hoc 											   ");
			System.out.println("\t\t2. Tim Kiem He Thong Truong Dai Hoc 											   ");
			System.out.println("\t\t0. Quay Lai! 																	   ");
			System.out.print("\t\tNhap lua chon cua ban: ");
			int chose = Integer.parseInt(sc.nextLine());
			switch(chose) {
			case 1: capNhatDH(); break;
			case 2: timKiemDH(); break;
			case 0: return;
			default: System.out.println("\tLua chon cua ban khong le!  ");			
			}						
		}while(true);
	}
	private static void capNhatDH() {
		do {
			System.out.println("\n\t------------------- CAP NHAT HE THONG TRUONG DAI HOC -----------------------");
			System.out.println("\t\tXin Moi Ban Lua Chon.														");	
			System.out.println("\t\t1. Cap Nhat Danh Sach Giao Vien Dai Hoc										");
			System.out.println("\t\t2. Cap Nhat Danh Sach Sinh Vien Dai Hoc										");
			System.out.println("\t\t3. Cap Nhat Danh Sach Mon Hoc Dai Hoc										");
			System.out.println("\t\t4. Cap Nhat Danh Sach Bang Diem Dai Hoc										");
			System.out.println("\t\t0. Quay Lai																	");			
			System.out.print("\t\tNhap lua chon cua ban:  ");
			int chose = Integer.parseInt(sc.nextLine());
			switch(chose) {
			case 1: QuanLyGiaoVien.nhapGV(); break;
			case 2: QuanlySinhVien.nhapSV(); break;
			case 3: QuanLyMonHoc.nhapMH(); break;
			case 4: QuanLyBangDiem.nhapBD(); break;
			case 0: return;
			default: System.out.println("\tLua chon cua ban khong hop le! ");
			}			
		}while(true);		
	}
	private static void timKiemDH() {
		do {
			System.out.println("\n\t------------------- TIM KIEM THONG TIN TRUONG DAI HOC ----------------------");
			System.out.println("\t\tXin Moi Ban Lua Chon.														");	
			System.out.println("\t\t1. Tim Kiem thong Tin Giao Vien Dai Hoc										");
			System.out.println("\t\t2. Tim Kiem thong Tin Sinh Vien Dai Hoc										");
			System.out.println("\t\t3. Tim Kiem thong Tin Mon Hoc 												");
			System.out.println("\t\t0. Quay Lai																	");			
			System.out.print("\t\tNhap lua chon cua ban:  ");
			int chose = Integer.parseInt(sc.nextLine());
			switch(chose) {
			case 1: TimKiemGiaoVien.nhapGV(); break;
			case 2: TimKiemSV.nhapSV(); break;
			case 3: TimKiemMonHoc.nhapMH(); break;
			case 0: return;
			default: System.out.println("\tLua chon cua ban khong hop le! ");
			}
		}while(true);
		
	}

}
