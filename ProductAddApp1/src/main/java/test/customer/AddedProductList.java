package test.customer;

import java.util.ArrayList;

import test.ProductBean;

public class AddedProductList {
	
	  private static ArrayList<ProductBean> pbs = new ArrayList<>();
	
	  public static void addProduct(ProductBean pb ) {
		  pbs.add(pb);
		  System.out.print("Product added successfully " + pbs);
	  }
	  
	  public static ArrayList<ProductBean> getProducts(){
		  return pbs; 
	  }
	  
	  
	  public static void removeProduct(ProductBean pb) {
		  pbs.remove(pb);
		  System.out.println("after removing product " +pbs);
	  }
	  
	  public static void clear() {
		  pbs.clear();
		  System.out.println(pbs);
	  }

}
