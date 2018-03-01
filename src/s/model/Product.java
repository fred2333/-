package s.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Product entity. @author MyEclipse Persistence Tools
 */

public class Product implements java.io.Serializable {

	// Fields

	private Integer pid;
	private Category category;
	private String pname;
	private String brand;
	private Double price;
	private String image;
	private Date time;
	private Set orderItems = new HashSet(0);
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Set getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", brand="
				+ brand + ", price=" + price + ", image=" + image + ", time="
				+ time + "]";
	}

		
	

}