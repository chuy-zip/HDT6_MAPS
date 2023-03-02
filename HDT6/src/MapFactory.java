import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class MapFactory {
	
	public static <K,V> Map<Integer, ArrayList<Product>> createMap(int opcion,int Key, ArrayList<Product> Product ){
		switch(opcion) {
			case 1:
				//HashMAp				
				return new HashMap<Integer, ArrayList<Product>>();
				
			case 2:
				//TreeMap
				return new TreeMap<Integer, ArrayList<Product>>();
			case 3: 
				//LinkedHashMap
				return new LinkedHashMap<Integer, ArrayList<Product>>();
			 default:
	                throw new IllegalArgumentException("INVALID MAP TYPE");
		}
	}
}

		
