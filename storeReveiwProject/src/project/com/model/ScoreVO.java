package project.com.model;

public class ScoreVO {
	private String pname;
	private float total;
	private float taste;
	private float price;
	private float distance;
	private float circul;
	private int count;
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getTaste() {
		return taste;
	}
	public void setTaste(float taste) {
		this.taste = taste;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public float getCircul() {
		return circul;
	}
	public void setCircul(float circul) {
		this.circul = circul;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "ScoreVO [pname=" + pname + ", total=" + total + ", taste=" + taste + ", price=" + price + ", distance="
				+ distance + ", circul=" + circul + ", count=" + count + "]";
	}
	
	
}
