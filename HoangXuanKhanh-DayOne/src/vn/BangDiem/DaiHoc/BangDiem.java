package vn.BangDiem.DaiHoc;

import vn.MonHoc.DaiHoc.QuanLyMonHoc;
import vn.SinhVien.DaiHoc.QuanlySinhVien;

public class BangDiem {


	private int iDMonHoc;
	private int maId;
	private String slass;
	private String ngN;
	private String namHoc;
	private double diemHKOne;
	private double diemHKTwo;
			
	public void display() {
		// lay ten mon hoc theo ma mon hoc co trong danh sach mon hoc
		String tenMH = QuanLyMonHoc.list.get(QuanLyMonHoc.indexOd(iDMonHoc)).getTenMh().trim();
		// lay ten sinh vien theo ma sinh vien co trong quan ly sinh vien;
		String tenSV = QuanlySinhVien.list.get(QuanlySinhVien.indexOf(maId)).getHoTen().trim();		
		String lop = QuanlySinhVien.list.get(QuanlySinhVien.indexOf(maId)).getLop().trim();
		String nganh = QuanlySinhVien.list.get(QuanlySinhVien.indexOf(maId)).getNganh().trim();
		System.out.printf("%10s %18s %9s %15s %16s %,14.1f %,18.1f %,20.1f %n", tenMH, tenSV, lop, nganh, namHoc, diemHKOne,
							diemHKTwo, tong());
	}

	public double tong() {
		return (diemHKOne + diemHKTwo) /2;
	}

	
	public BangDiem() {
		super();
	}

	
	public BangDiem(int iDMonHoc, int maId, String slass, String ngN, String namHoc, double diemHKOne,
			double diemHKTwo) {
		super();

		this.iDMonHoc = iDMonHoc;
		this.maId = maId;
		this.slass = slass;
		this.ngN = ngN;
		this.namHoc = namHoc;
		this.diemHKOne = diemHKOne;
		this.diemHKTwo = diemHKTwo;
	}



	public int getiDMonHoc() {
		return iDMonHoc;
	}

	public void setiDMonHoc(int iDMonHoc) {
		this.iDMonHoc = iDMonHoc;
	}

	public int getMaId() {
		return maId;
	}

	public void setMaId(int maId) {
		this.maId = maId;
	}

	public String getSlass() {
		return slass;
	}

	public void setSlass(String slass) {
		this.slass = slass;
	}

	public String getNgN() {
		return ngN;
	}

	public void setNgN(String ngN) {
		this.ngN = ngN;
	}

	public String getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(String namHoc) {
		this.namHoc = namHoc;
	}

	public double getDiemHKOne() {
		return diemHKOne;
	}

	public void setDiemHKOne(double diemHKOne) {
		this.diemHKOne = diemHKOne;
	}

	public double getDiemHKTwo() {
		return diemHKTwo;
	}

	public void setDiemHKTwo(double diemHKTwo) {
		this.diemHKTwo = diemHKTwo;
	}

	
	
}
