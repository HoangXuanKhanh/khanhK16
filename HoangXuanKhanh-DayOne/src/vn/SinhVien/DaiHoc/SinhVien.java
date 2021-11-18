package vn.SinhVien.DaiHoc;

public class SinhVien {
	
		private int maID;
		private String hoTen;
		private String lop;
		private String nganh;
		private int day, month, year;
		private String gioiTinh;
		private int soDt;
		private String gmail;
		private String diaChi;
				
		public void display() {
			System.out.printf("%10d %21s %-10s %-12s %02d/%02d/%04d %11s %22s %28s %35s %n", maID, hoTen, lop, nganh , day, month, year, 
								gioiTinh, soDt, gmail, diaChi);
		}
		
		public SinhVien() {
			super();
		}

		public SinhVien(int maID, String hoTen, String lop, String nganh, int day, int month, int year, String gioiTinh,
				int soDt, String gmail, String diaChi) {
			super();
			this.maID = maID;
			this.hoTen = hoTen;
			this.lop = lop;
			this.nganh = nganh;
			this.day = day;
			this.month = month;
			this.year = year;
			this.gioiTinh = gioiTinh;
			this.soDt = soDt;
			this.gmail = gmail;
			this.diaChi = diaChi;
		}


		public int getMaID() {
			return maID;
		}


		public void setMaID(int maID) {
			this.maID = maID;
		}


		public String getHoTen() {
			return hoTen;
		}


		public void setHoTen(String hoTen) {
			this.hoTen = hoTen;
		}


		public String getLop() {
			return lop;
		}


		public void setLop(String lop) {
			this.lop = lop;
		}


		public String getNganh() {
			return nganh;
		}


		public void setNganh(String nganh) {
			this.nganh = nganh;
		}


		public int getDay() {
			return day;
		}


		public void setDay(int day) {
			this.day = day;
		}


		public int getMonth() {
			return month;
		}


		public void setMonth(int month) {
			this.month = month;
		}


		public int getYear() {
			return year;
		}


		public void setYear(int year) {
			this.year = year;
		}


		public String getGioiTinh() {
			return gioiTinh;
		}


		public void setGioiTinh(String gioiTinh) {
			this.gioiTinh = gioiTinh;
		}


		public int getSoDt() {
			return soDt;
		}


		public void setSoDt(int soDt) {
			this.soDt = soDt;
		}


		public String getGmail() {
			return gmail;
		}


		public void setGmail(String gmail) {
			this.gmail = gmail;
		}


		public String getDiaChi() {
			return diaChi;
		}


		public void setDiaChi(String diaChi) {
			this.diaChi = diaChi;
		}
		
		
		
}
