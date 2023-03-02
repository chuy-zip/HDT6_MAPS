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
		Scanner scan = new Scanner(System.in);		
		
		System.out.println("Bienvenido, elige el tipo de estructura que desea usar para explorar el inventario\n");
		System.out.println("1.HashMap\n"
						 + "2.TreeMap\n"
						 + "3.LinkedHashMap\n");
		
		int MapType = scan.nextInt();
		
		Map<Integer, ArrayList<Product>> WareHouse = Factory.createMap(MapType);
		
		FileReader(WareHouse);
		
		System.out.println(WareHouse);
		
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
				
				if(StrLine[0].equals("Mueble de terraza")) {
					
					//If position 1 is empty
					if(map.get(1) == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put(1, ProductsList);
						
					}
					
					else {
						//Else, get array list at position 1
						((ArrayList<Product>) map.get(1)).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Sillones de masaje")) {
					//If position 2 is empty
					if(map.get(2) == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put(2, ProductsList);
						
					}
					
					else {
						//Else, get array list at position 2
						((ArrayList<Product>) map.get(2)).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Bebidas")) {
					//If key value 3 is null
					if(map.get(3) == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put(3, ProductsList);
						
					}
					
					else {
						//Else, get array list at position 3
						((ArrayList<Product>) map.get(3)).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Condimentos")) {
					//if key value 4 returns null
					if(map.get(4) == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put(4, ProductsList);
						
					}
					
					else {
						//Else, get array list at position 4
						((ArrayList<Product>) map.get(4)).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Frutas")) {
					//If key 5 returns null
					if(map.get(5) == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put(5, ProductsList);
						
					}
					
					else {
						//Else, get array list at position 5
						((ArrayList<Product>) map.get(5)).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Carnes")) {
					//Check if position 6 is empty
					if(map.get(6) == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put(6, ProductsList);
						
					}
					
					else {
						//Else, get array list at position 6
						((ArrayList<Product>) map.get(6)).add(newProduct);
					}
				}
				
				else if(StrLine[0].equals("Lácteos")) {
					//Checking if key seven is null
					if(map.get(7) == null) {
						ArrayList<Product> ProductsList = new ArrayList<Product>();
						ProductsList.add(newProduct);
						map.put(7, ProductsList);
						
					}
					
					else {
						//Else, get array list at position 7
						((ArrayList<Product>) map.get(7)).add(newProduct);
					}
				}

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return map;
		
	}
}
