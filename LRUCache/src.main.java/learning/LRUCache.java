package learning;

import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LRUCache {
	private int maxSize = 5;
	private static ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<String, String>();
	private ConcurrentLinkedDeque<String> accessTracker = new ConcurrentLinkedDeque<>();
	
	public String get(String key) {
		if (cache.containsKey(key)) {
			accessTracker.remove(key);
			accessTracker.add(key);
			return cache.get(key);
		} else {
			return null;
		}
	}
	
	public void add(String key,String value) {
		if (cache.containsKey(key)) {
			cache.put(key, value);
			accessTracker.remove(key);
			accessTracker.add(key);
		} else {
			if (cache.size()== maxSize) {
				String itemKeyToRemove = accessTracker.removeFirst();
				cache.remove(itemKeyToRemove);
				cache.put(key, value);
				accessTracker.add(key);
			} else {
				
			}
		}
	}
		
	public void populateCache(Map<String,String> map) {
		for (Entry<String, String> entry : map.entrySet()) {
				cache.put(entry.getKey(), entry.getValue());
				accessTracker.add(entry.getKey());
		}
	}
	
	public int size() {
		return cache.size();
	}
		
}