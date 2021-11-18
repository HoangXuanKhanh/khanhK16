package vn.doller.QuanLyKhachHang.examble04;

public class KhachHang {
	private int id;
	private String name;

	public void display() {
		System.out.printf("%4d %20s %n", id, name);
	}

	public KhachHang() {
		super();
	}

	public KhachHang(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
