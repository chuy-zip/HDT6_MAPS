import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class MapFactory {
	
	public static <K,V> Map<String, ArrayList<Product>> createMap(int opcion ){
		switch(opcion) {
			case 1:
				//HashMAp				
				return new HashMap<String, ArrayList<Product>>();
				
			case 2:
				//TreeMap
				return new TreeMap<String, ArrayList<Product>>();
			case 3: 
				//LinkedHashMap
				return new LinkedHashMap<String, ArrayList<Product>>();
			 default:
	                throw new IllegalArgumentException("INVALID MAP TYPE");
		}
	}
}

		
