package lv.venta.services;

import java.util.ArrayList;

import lv.venta.model.Product;

public interface IFilteringProduct {
	//filter product: price less than X
	public abstract ArrayList<Product> filterByPriceLessThan(float priceThreshold) throws Exception;
	
	//filter quantity: quantity less than X
	public abstract ArrayList<Product> filterByQuantityLessThan(int quantityThreshold) throws Exception; 
	
	//filter product: sorting
	//TODO ascending or descending
	public abstract ArrayList<Product> sort();
}
