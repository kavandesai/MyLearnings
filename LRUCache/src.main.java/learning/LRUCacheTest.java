package learning;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheTest {
	public static void main(String args[]) {
		LRUCache cache = new LRUCache();
		Map<String,String> map = new HashMap<>();
		map.put("1", "One");
		map.put("2", "Two");
		map.put("3", "Three");
		map.put("4", "Four");
		map.put("5", "Five");
		cache.populateCache(map);
		System.out.println("Cache size "+cache.size());
		cache.add("6","six");
		cache.add("7","seven");
		cache.add("8","eight");
		cache.get("4");
		cache.get("5");
		cache.add("9","nine");
		cache.add("10","ten");
		System.out.println("Key - 1 has been removed? "+(cache.get("1") == null ? true:false));
		System.out.println("Key - 2 has been removed? "+(cache.get("2") == null ? true:false));
		System.out.println("Key - 3 has been removed? "+(cache.get("3") == null ? true:false));
		System.out.println("Key - 4 has been removed? "+(cache.get("4") == null ? true:false));
		System.out.println("Key - 5 has been removed? "+(cache.get("5") == null ? true:false));
		System.out.println("Key - 6 has been removed? "+(cache.get("6") == null ? true:false));
		System.out.println("Key - 7 has been removed? "+(cache.get("7") == null ? true:false));
		System.out.println("Key - 8 has been removed? "+(cache.get("8") == null ? true:false));
		System.out.println("Key - 9 has been removed? "+(cache.get("9") == null ? true:false));
		System.out.println("Key - 10 has been removed? "+(cache.get("10") == null ? true:false));
	}
}