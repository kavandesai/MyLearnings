package learning;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;

public class LRUCache {

	private Map<String,String> cacheMap = new ConcurrentHashMap<String,String>();
	private ConcurrentLinkedDeque<String> lruQueue = new ConcurrentLinkedDeque<>();
	
	public void addElement(String e) {
		
	}
	
	public void removeElement(String e) {
		
	}
	
	public String getElement(String key) {
		return "";
	}
	
	public void populateCache(Map<String,String> map) {
		
	}
	
	
}
