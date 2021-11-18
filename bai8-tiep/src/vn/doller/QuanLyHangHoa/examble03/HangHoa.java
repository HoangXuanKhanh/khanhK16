package vn.doller.QuanLyHangHoa.examble03;

import vn.doller.QuanLyLoaiHang.examble02.QuanLyLoaiHang;

public class HangHoa {

	private int id;
	private int idlh;
	private String name;
	private double amount;
	private double price;

	public void display() {
		// lay ten loai hang
		String tenLH = QuanLyLoaiHang.list.get(QuanLyLoaiHang.indexOf(idlh)).getName().trim();
		System.out.printf("%-10d %-15s %-10s %,13.1f %,18.1f %,22.1f %n", id, tenLH, name, amount, price, total());
	}

	public double total() {
		return amount * price;
	}

	public HangHoa() {
		super();
	}

	public HangHoa(int id, int idlh, String name, double amount, double price) {
		super();
		this.id = id;
		this.idlh = idlh;
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdlh() {
		return idlh;
	}

	public void setIdlh(int idlh) {
		this.idlh = idlh;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
