import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);		
		
		System.out.println("Bienvenido, elige el tipo de estructura que desea usar para explorar el inventario\n");
		System.out.println("1.HashMap\n"
						 + "2.TreeMap\n"
						 + "3.LinkedHashMap\n");
		
		int MapType = scan.nextInt();
		
		Map<String, String> phoneBook = new HashMap<String,String>();
		
		FileReader(phoneBook);
		
	}
	
	public static Map FileReader(Map map) {
		System.out.println("Entra");
		String MyFile = "src/ListadoProducto.txt";
		String line = ""; 
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyFile));
			while((line = reader.readLine())!=null) {

				String[] StrLine = line.split("\\|");
				
				StrLine[0].stripTrailing();
				StrLine[1].stripLeading();
				
				System.out.println(StrLine[0] + "+" + StrLine[1]);
				
				
				if(StrLine[0].equals("Mueble de terraza")) {
					System.out.println(1);
					System.out.println(StrLine[0] + "+" + StrLine[1]);
				}
				
				else if(StrLine[0].equals("Sillones de masaje")) {
					System.out.println(2);
					System.out.println(StrLine[0] + "+" + StrLine[1]);
				}
				
				else if(StrLine[0].equals("Bebidas")) {
					System.out.println(3);
					System.out.println(StrLine[0] + "+" + StrLine[1]);
				}
				
				else if(StrLine[0].equals("Condimentos")) {
					System.out.println(4);
					System.out.println(StrLine[0] + "+" + StrLine[1]);
				}
				
				else if(StrLine[0].equals("Frutas")) {
					System.out.println(5);
					System.out.println(StrLine[0] + "+" + StrLine[1]);
				}
				
				else if(StrLine[0].equals("Carnes")) {
					System.out.println(6);
					System.out.println(StrLine[0] + "+" + StrLine[1]);
				}
				
				else if(StrLine[0].equals("Lácteos")) {
					System.out.println(7);
					System.out.println(StrLine[0] + "+" + StrLine[1]);
				}
				
				map.put(StrLine, reader);

			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return map;
		
	}
}
