package vn.MonHoc.DaiHoc;

import vn.SinhVien.DaiHoc.QuanlySinhVien;

public class MonHoc {
	
		private int maMon;
		private String tenMh;
		
		public void display() {
			System.out.printf("%6d %19s %n", maMon, tenMh);
		}
		
		public MonHoc() {
			super();
		}
		
		public MonHoc(int maMon, String tenMh) {
			super();
			this.maMon = maMon;
			this.tenMh = tenMh;
		}
		public int getMaMon() {
			return maMon;
		}
		public void setMaMon(int maMon) {
			this.maMon = maMon;
		}
		public String getTenMh() {
			return tenMh;
		}
		public void setTenMh(String tenMh) {
			this.tenMh = tenMh;
		}
		
		
}
