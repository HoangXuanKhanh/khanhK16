package vn.doller.QuanLyLoaiHang.examble02;

public class LoaiHang {

	private int id;
	private String name;

	public void display() {
		System.out.printf("%4d %17s %n", id, name);

	}

	public LoaiHang() {
		super();
	}

	public LoaiHang(int id, String name) {
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
