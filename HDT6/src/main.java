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
						 + "3.LinkedHashMap\n");
		
		int MapType = scan.nextInt();
		String Option = "";
		Map<String, ArrayList<Product>> WareHouse = Factory.createMap(MapType);
		FileReader(WareHouse);
		
		System.out.println(WareHouse);
		
		
		Map<String, ArrayList<Product>> ShoppingCart;
		
		
		while(true) {
			System.out.println("Bienvenido a la teinda online que deseas hacer:\n"
					+ "1.Agregar un producto al carrito\n"
					+ "2.Obtener categoria de un producto\n"
					+ "3.Ver los productos en mi carrito\n"
					+ "4.Ver carrito ordenados por categoria\n"
					+ "5.Mostrar todo el inventario disponible\n"
					+ "6.Mostrar todo el inventario disponible ordenado\n"
					+ "7.Salir\n");
			Option = scan.nextLine();
			
			switch (Option) {
			case "1":
				System.out.println("Ingrese la categoria del articulo");
				String Category = scan.nextLine();
				
				System.out.println("Ingrese el nombre de articulo");
				String Product = scan.nextLine();
				
				System.out.println("Ingrese la cantidad que desea añadir");
				int Quantity = scan.nextInt();
				
				System.out.println("\n");
				
				
				
				break;
				
			case "2":
				
				break;
				
			case "3":
				
				break;
			
			case "14":
				
				break;
				
			case "5":
				
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
				if(StrLine[0].equals("Mueble de terraza")) {
					
					if(map.get("Mueble de terraza") == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put("Mueble de terraza", ProductsList);
						
					}
					
					else {
						
						((ArrayList<Product>) map.get("Mueble de terraza")).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Sillones de masaje")) {
					//If position 2 is empty
					if(map.get("Sillones de masaje") == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put("Sillones de masaje", ProductsList);
						
					}
					
					else {
						//Else, get array list at position 2
						((ArrayList<Product>) map.get("Sillones de masaje")).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Bebidas")) {
					//If key value 3 is null
					if(map.get("Bebidas") == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put("Bebidas", ProductsList);
						
					}
					
					else {
						//Else, get array list at position 3
						((ArrayList<Product>) map.get("Bebidas")).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Condimentos")) {
					//if key value 4 returns null
					if(map.get("Condimentos") == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put("Condimentos", ProductsList);
						
					}
					
					else {
						//Else, get array list at position 4
						((ArrayList<Product>) map.get("Condimentos")).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Fruta")) {
					//If key 5 returns null
					if(map.get("Frutas") == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put("Frutas", ProductsList);
						
					}
					
					else {
						//Else, get array list at position 5
						((ArrayList<Product>) map.get("Frutas")).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Carnes")) {
					//Check if position 6 is empty
					if(map.get("Carnes") == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put("Carnes", ProductsList);
						
					}
					
					else {
						//Else, get array list at position 6
						((ArrayList<Product>) map.get("Carnes")).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Lácteos")) {
					//Checking if key seven is null
					if(map.get("Lácteos") == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put("Lácteos", ProductsList);
						
					}
					
					else {
						//Else, get array list at position 7
						((ArrayList<Product>) map.get("Lácteos")).add(newProduct);
					}
				}

			}
			
		} catch (Exception e) {
			System.out.println("Error al leer el archivo");
		}
		
		return map;
		
	}
}
