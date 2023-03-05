import java.util.ArrayList;
import java.util.Map;

public class StoreManager {
	public void addProductToShoppingCart(String keyCat, String product, String Quantity, Map<String, ArrayList<Product>> Inventory, Map<String, ArrayList<Product>> UserMap) {
		
	}
	
	public String getCategoryOfProduct(String Product, Map<String, ArrayList<Product>> Inventory) {
		
		for (String key : Inventory.keySet()) {
			ArrayList<Product> ProductsList = Inventory.get(key);
			
			for (Product ListProduct : ProductsList) {
				
				String ProductName = ListProduct.getName();
				
				if(ProductName.compareToIgnoreCase(Product) == 0) {
					
					return "El producto: " + Product + ", es de la categoria: " + ListProduct.getCategory() ;
					
				}
				
			}
		}
		
		return "No se encontro el: " + Product + ", en el inventario";
	}
	
	public void ShowShoppingCart(Map<String, ArrayList<Product>> UserMap) {
		
	}
	
	public void ShowOrderedShoppingCart(Map<String, ArrayList<Product>> UserMap) {
		
	}
	
	public void ShowWarehouseInventory(Map<String, ArrayList<Product>> Inventory) {
		
	}
	
	public void ShowOrderedWareHouseINventory(Map<String, ArrayList<Product>> Inventory) {
		
	}
}
