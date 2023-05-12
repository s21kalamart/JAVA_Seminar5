package lv.venta.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Product {
	
	@NotNull
	@Size(min = 3, max = 150)
	@Pattern(regexp = "[A-Z](1)[a-z\\ ]+") 	//only latin letters and space
	private String title;
	
	@NotNull
	@Size(min = 5, max = 400)
	@Pattern(regexp = "[A-Z](1)[a-z0-9\\ ]+") 	//only latin letters, numbers and space
	private String description;
	
	@Min(0)
	@Max(10000)
	private float price;
	
	@Min(0)
	@Max(1000000)
	private int quantity;
	
	private long id;
	private static long idCounter = 1;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getId() {
		return id;
	}
	public void setId() {
		this.id = idCounter++;
	}
	
	public Product(String title, String description, float price, int quantity) {
		setId();
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	public Product() {}
	@Override
	public String toString() {
		return "Product [title=" + title + ", description=" + description + ", price=" + price + ", quantity=" + quantity + ", id=" + id + "]";
	}
}
