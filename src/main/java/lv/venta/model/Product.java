package lv.venta.model;

public class Product {
	private String title;
	private String description;
	private float price;
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
	public void setId(long id) {
		this.id = id;
	}
	public static long getIdCounter() {
		return idCounter;
	}
	public static void setIdCounter(long idCounter) {
		Product.idCounter = idCounter;
	}
	public Product(String title, String description, float price, int quantity) {
		setId();
		this.title = title;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
	}
	
	
}
