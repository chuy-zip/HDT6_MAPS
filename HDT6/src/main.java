import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		MapFactory Factory = new MapFactory();
		StoreManager Manager = new StoreManager();
		Scanner scan = new Scanner(System.in);		
		
		System.out.println("Elige el tipo de estructura que desea usar para explorar el inventario\n");
		System.out.println("1.HashMap\n"
						 + "2.TreeMap\n"
						 + "3.LinkedHashMap");
		
		int MapType = scan.nextInt();
		scan.nextLine(); // descarta los caracteres restantes que no son de tipo int  \n
		Map<String, ArrayList<Product>> WareHouse = Factory.createMap(MapType);
		FileReader(WareHouse);
		
		Map<String, ArrayList<Product>> ShoppingCart = Factory.createMap(MapType);
		
		String Option = "";
		while(true) {
			Option = getUserOption(Option, scan);
			
			switch (Option) {
			case "1":
				System.out.println("Ingrese la categoria del articulo");
				String Category = scan.nextLine();
				
				System.out.println("Ingrese el nombre de articulo");
				String Product = scan.nextLine();
				
				System.out.println("Ingrese la cantidad que desea agregar al carrito");
				int Quantity = scan.nextInt();
				scan.nextLine();
				
				Manager.addProductToShoppingCart(Category, Product, Quantity, WareHouse, ShoppingCart);
				System.out.println("\n");
				
				
				break;
				
			case "2":
				System.out.println("Ingrese el nombre de articulo");
				String SearchProduct = scan.nextLine();
				
				System.out.println(Manager.getCategoryOfProduct(SearchProduct, WareHouse));
				System.out.println("\n");
				
				break;
				
			case "3":
				Manager.ShowMapValues(ShoppingCart);
				
				break;
			
			case "4":
				
				break;
				
			case "5":
				Manager.ShowMapValues(WareHouse);
				break;
				
			case "6":
				
				break;

			case "7":
				System.out.println("Buen dia");
				System.exit(0);
				break;
				
			}

		}

		
		
	}
	
	public static String getUserOption(String option, Scanner scan) {
		System.out.println("Bienvenido a la tienda online que deseas hacer:\n"
				+ "1.Agregar un producto al carrito\n"
				+ "2.Obtener categoria de un producto\n"
				+ "3.Ver los productos en mi carrito\n"
				+ "4.Ver carrito ordenados por categoria\n"
				+ "5.Mostrar todo el inventario disponible\n"
				+ "6.Mostrar todo el inventario disponible ordenado\n"
				+ "7.Salir\n");
		option = scan.nextLine();
		return option;
	}
	
	public static Map FileReader(Map map) {
		String MyFile = "src/ListadoProducto.txt";
		String line = ""; 
		Random rand = new Random();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyFile));
			while((line = reader.readLine())!=null) {

				String[] StrLine = line.split("\\|");
				
				StrLine[0] = StrLine[0].stripTrailing();
				StrLine[1] = StrLine[1].stripLeading();
				
				int Quantity = rand.nextInt(10 - 0 + 1) + 1;
				Product newProduct = new Product(StrLine[1], StrLine[0], Quantity);
				
				//In every cycle, the programs looks for the existing key, if it is not found
				//the key and array list is added. If the key is found, a new object is added to 
				//the category
				if(map.get(StrLine[0]) == null) {
					ArrayList<Product> ProductsList = new ArrayList<Product>();
					ProductsList.add(newProduct);
					map.put(StrLine[0], ProductsList);
						
				}
				else {					
					((ArrayList<Product>) map.get(StrLine[0])).add(newProduct);
				}

			}
			
		} catch (Exception e) {
			System.out.println("Error al leer el archivo");
		}
		
		return map;
		
	}
}
