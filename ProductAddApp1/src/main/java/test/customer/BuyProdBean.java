package test.customer;

public class BuyProdBean {
	
	private String id ;
	StringBuffer prodlist; 
	private Double price;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public StringBuffer getProdlist() {
		return prodlist;
	}
	public void setProdlist(StringBuffer prodlist) {
		this.prodlist = prodlist;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "BuyProdBean [id=" + id + ", prodlist=" + prodlist + ", price=" + price + "]";
	} 
	
	
	

}
