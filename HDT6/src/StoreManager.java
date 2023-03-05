import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class StoreManager {
	public void addProductToShoppingCart(String keyCat, String RequestedProduct, int RequestedQuantity, Map<String, ArrayList<Product>> Inventory, Map<String, ArrayList<Product>> UserMap) {
		
		//First check is to evaluate if the key values exists on the inventory
		if(Inventory.get(keyCat) == null) {
			System.out.println("La categoria ingresada no existe");
			return;
		}
					
		//If it does exists, we get the ArrayList of a category, based on the given key
		else {
			ArrayList<Product> ProductsList = Inventory.get(keyCat);
			
			for (Product ProductInList : ProductsList) {// Going through every element in the list
				
				String ProductName = ProductInList.getName();
				
				//If the requested product matches a product, and there is enough product to be taken
				if(ProductName.compareToIgnoreCase(RequestedProduct) == 0 && ProductInList.getQuantity() - RequestedQuantity >= 0) {
					
					System.out.println("Se encontro el producto: " + RequestedProduct + ", Con la cantidad de: " + ProductInList.getQuantity());
					//The amount of the product in the inventory is reduced
					ProductInList.setQuantity(ProductInList.getQuantity() - RequestedQuantity);
					
					//And a Product object is created for the User Map
					Product newUserProduct = new Product(RequestedProduct, keyCat, RequestedQuantity);
					
					//If it is the first time the user requests something from the specific category
					if(UserMap.get(keyCat) == null) {
						//A new list is created and then added to the map
						ArrayList<Product> CategoryList = new ArrayList<Product>();
						CategoryList.add(newUserProduct);
						UserMap.put(keyCat, CategoryList);
						System.out.println("Se ha agregado la categoria de: " + keyCat + ", a tu carrito de compras y se agrego el producto solicitado");
							
					}
					//If it is not the first time the user adds something from a category
					else {	
						//Checking if the product already exists in the shopping cart
						ArrayList<Product> UserProductList = ((ArrayList<Product>) UserMap.get(keyCat));
						for (Product product : UserProductList) {
							//If the produta has been added previously, only quantity increases
							if(product.getName().compareToIgnoreCase(RequestedProduct) == 0) {
								product.setQuantity(product.getQuantity() + RequestedQuantity);
								System.out.println("Se aumento la cantidad del producto: " + RequestedProduct + ", en el carrito");
								return;
							}
						}
						//If the product has not been added previously, a new category is added to the shopping cart
						System.out.println("Se agrego el producto a lista de la categoria: " + keyCat);
						((ArrayList<Product>) UserMap.get(keyCat)).add(newUserProduct);
						
					}
					
					return;
				}
			}
			
			System.out.println("No se encontro el producto solicitado y/o la cantidad solicitada es mayor a la disponible");
			
		}
		
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
		
		return "No se encontro: " + Product + ", en el inventario";
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
