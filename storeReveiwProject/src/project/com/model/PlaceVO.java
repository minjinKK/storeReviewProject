package project.com.model;

public class PlaceVO {
	private String p_name;
	private int p_num;
	private String p_country;
	private String p_address;
	private String p_img_name;
	@Override
	public String toString() {
		return "PlaceVO [p_name=" + p_name + ", p_num=" + p_num + ", p_country=" + p_country + ", p_address="
				+ p_address + ", p_img_name=" + p_img_name + "]";
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public int getP_num() {
		return p_num;
	}
	public void setP_num(int p_num) {
		this.p_num = p_num;
	}
	public String getP_country() {
		return p_country;
	}
	public void setP_country(String p_country) {
		this.p_country = p_country;
	}
	public String getP_address() {
		return p_address;
	}
	public void setP_address(String p_address) {
		this.p_address = p_address;
	}
	public String getP_img_name() {
		return p_img_name;
	}
	public void setP_img_name(String p_img_name) {
		this.p_img_name = p_img_name;
	}
	
}
