package vn.doller.QuanLyKhachHang.examble04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class QuanLyKhachHang {
	
		public static ArrayList<KhachHang> list = new ArrayList<>();
		public static int autoId = 1;
		static Scanner sc = new Scanner(System.in);
			
		public static void capnhat() {
			int chon;
			do {
				System.out.println("\n\t------------ CAP NHAT THONG TIN KHACH HANG ---------------");
				System.out.println("\tLua chon chuc nang cap nhat Khach hang. 	");
				System.out.println("\t1. them moi Khach hang.	 				");
				System.out.println("\t2. Hien thi danh sach Khach hang.	 		");
				System.out.println("\t3. Sua thong tin Khach hang.	 			");
				System.out.println("\t4. Xoa thong tin khach hang.				");
				System.out.println("\t5. Sap Xep danh sach Khach hang.			");
				System.out.println("\t0. Quay Lai!								");
				System.out.print("\tNhap lua chon cua ban: ");
				chon = Integer.parseInt(sc.nextLine());
				
				switch(chon) {
				case 1: themkhachHang(); break;
				case 2: hienThiDS(); break;
				case 3: suakhachHang(); break;
				case 4: xoakhachHang();break;
				case 5: sapXepDS();break;
				case 0: return;
				default: System.out.println("\tLua chon cua ban khong hop le! ");
				}
							
			}while(true);
			
		}

		private static void themkhachHang() {
			System.out.println("\n\t------------- THEM KHACH HANG MOI -------------");
			System.out.println("\tNhap thong Tin khach Hang Moi. ");
			System.out.print("\tNhap Ten khach Hang: ");		
			String name = sc.nextLine();
			if(name.trim().length() == 0) {
				System.out.println("\tTen khong duoc de trong danh sach! ");
				return;					
			}

			//khoi tao doi luong loai hang va add vao list
			KhachHang kh = new KhachHang(autoId, name);
			list.add(kh);
			autoId++;
			System.out.println("\tThem khach Hang Thanh Cong! ");
		}

		private static void hienThiDS() {
			System.out.println("\n\t---------- DANH SACH KHACH HANG --------------");
			System.out.printf("\t%3s %-10s %-15s %n", "STT"," Ma KH", "Ten Khach Hang" );
			int stt = 1;
			for(KhachHang kh : list) {
				System.out.printf("\t%-3d ", stt++);
				kh.display();
			}
			if(stt == 1) {
				System.out.printf("\tDanh Sach khach hang rong!...");
			}
			
		}

		private static void suakhachHang() {
			System.out.println("\n\t---------- DANH SACH SUA THONG kHACH HANG --------------");
			System.out.print("\tNhap id khach hang can sua: ");
			int id = Integer.parseInt(sc.nextLine());
			
			//tim xem loai hang void id vua nhap co trong danh sach khong		
			int index = indexOf(id);
			if(index == -1) {
				System.out.println("\tkhach hang khong co trong danh sach! ");
				return;
			}
			System.out.print("\tnhap ten cho khach hang: ");
			String name = sc.nextLine();
			if(name.trim().length() == 0) {
				System.out.println("\tTen khong duoc de trong! ");
				return;					
	
			}
			list.get(index).setName(name);
			System.out.print("\tSua ten khach hang thanh cong! ");
			
		}

		private static void xoakhachHang() {
			System.out.println("\n\t------------ DANH SACH XOA THONG KHACH HANG --------------");
			System.out.print("\tNhap id khach hang can Xoa: ");
			int id = Integer.parseInt(sc.nextLine());
			
			//tim xem loai hang void id vua nhap co trong danh sach khon
			int index = indexOf(id);
			if(index == -1) {
				System.out.println("\tkhach hang khong co trong danh sach! ");
				return;
			}
			
			/* co thi kiem tra xem loai hang da su trong danh sach hay chua?
			int i = 0;
			while(i < QuanLyHangHoa.list.size() && QuanLyHangHoa.list.get(i).getIdlh() != id) {
				i++;
			}
			if( i < QuanLyHangHoa.list.size()) {
				System.out.println("\tLoai hang da su dung trong danh sach hang hoa, khong the xoa");
				return;			
			}
			*/
			list.remove(index);
			System.out.print("\tXoa khach hang thanh cong1F ");
			
		}
		

		private static void sapXepDS() {
			Collections.sort(list, new Comparator<KhachHang>() {
				@Override
				public int compare(KhachHang o1, KhachHang o2) {
					
					return o1.getName().trim().compareToIgnoreCase(o2.getName().trim());
				}
			});
			
		}
		//ham nhan vao id tra va index neu co ib trong danh sach, nguoc lai tra ve -1;
		public static int indexOf(int id) {
			for(int index = 0; index < list.size(); index++) {
				if(list.get(index).getId() == id) {
					return index;
				}
			}
			return -1;
		}

		
}
