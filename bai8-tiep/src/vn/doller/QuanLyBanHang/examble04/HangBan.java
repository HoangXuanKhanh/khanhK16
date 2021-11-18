package vn.doller.QuanLyBanHang.examble04;

import vn.doller.QuanLyHangHoa.examble03.QuanLyHangHoa;

public class HangBan {

	private int idhh;
	private double amount;

	public void display() {
		int index = QuanLyHangHoa.indexOf(idhh);
		if (index == -1) {
			return;
		}
		String name = QuanLyHangHoa.list.get(index).getName();
		double price = QuanLyHangHoa.list.get(index).getPrice();
		double total = amount * price;
		System.out.printf("%9s %,13.1f %,16.1f %,19.1f %n", name, amount, price, total);
	}

	public double total() {
		int index = QuanLyHangHoa.indexOf(idhh);
		if (index == -1) {
			return 0;
		}
		return amount * QuanLyHangHoa.list.get(index).getPrice();

	}

	public HangBan() {
		super();
	}

	public HangBan(int idhh, double amount) {
		super();
		this.idhh = idhh;
		this.amount = amount;
	}

	public int getIdhh() {
		return idhh;
	}

	public void setIdhh(int idhh) {
		this.idhh = idhh;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
