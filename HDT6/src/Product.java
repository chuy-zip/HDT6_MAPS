
public class Product {
	
	private String Name;
	private String Category;
	private int Quantity;
	
	public Product(String name, String cat, int qty) {
		Name = name;
		Category = cat;
		Quantity = qty;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	
	
}
