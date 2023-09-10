package test;

import java.io.Serializable;

public class ProductBean implements Serializable{
	
	private String pcode, pname ;
	private double price;
	private int qty;
	public String getPcode() {
		return pcode;
	}
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "ProductBean [pcode=" + pcode + ", pname=" + pname + ", price=" + price + ", qty=" + qty + "]";
	} 
	
	
	
	

}
