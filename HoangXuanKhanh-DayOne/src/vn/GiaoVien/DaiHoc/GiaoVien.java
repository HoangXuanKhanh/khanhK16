package vn.GiaoVien.DaiHoc;

public class GiaoVien {
		private int maID;
		private String hoTen;
		private int day, month, year;
		private String gioiTinh;
		private int soDT;
		private String gmail;
		private String diaChi;
		private String trangThai;
		private String chucVu;
		
		public void display() {
			System.out.printf("%10d %21s  %02d/%02d/%04d %10s %18s %25s %32s %17s %19s %n", maID, hoTen ,  day, month, year, gioiTinh, soDT, 
					gmail, diaChi, trangThai, chucVu);
		}

		public GiaoVien() {
			super();
		}

		public GiaoVien(int maID, String hoTen, int day, int month, int year, String gioiTinh, int soDT, String gmail,
				String diaChi, String trangThai, String chucVu) {
			super();
			this.maID = maID;
			this.hoTen = hoTen;
			this.day = day;
			this.month = month;
			this.year = year;
			this.gioiTinh = gioiTinh;
			this.soDT = soDT;
			this.gmail = gmail;
			this.diaChi = diaChi;
			this.trangThai = trangThai;
			this.chucVu = chucVu;
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

		public int getSoDT() {
			return soDT;
		}

		public void setSoDT(int soDT) {
			this.soDT = soDT;
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

		public String getTrangThai() {
			return trangThai;
		}

		public void setTrangThai(String trangThai) {
			this.trangThai = trangThai;
		}

		public String getChucVu() {
			return chucVu;
		}

		public void setChucVu(String chucVu) {
			this.chucVu = chucVu;
		}
		
		
		
		
		
}
