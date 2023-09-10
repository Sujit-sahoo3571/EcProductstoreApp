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
	  

}
