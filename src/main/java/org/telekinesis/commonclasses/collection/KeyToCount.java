package org.telekinesis.commonclasses.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.telekinesis.commonclasses.debug.MapPrinter;

public class KeyToCount<KEY_TYPE> {
	private Map<KEY_TYPE, Integer> map = new HashMap<KEY_TYPE, Integer>();
	
	public void addToKey(KEY_TYPE key, int increment){
		Integer count = map.get(key);
		if(count == null)
			map.put(key, increment);
		else
			map.put(key, count + increment);
	}
	
	public int get(KEY_TYPE key){
		Integer count = map.get(key);
		if(count == null)
			return 0;
		return count;
	}
	
	public Map<KEY_TYPE, Integer> getCount(){
		return map;
	}
	
	public boolean containsKey(KEY_TYPE key){
		return map.containsKey(key);
	}
	
	public Set<KEY_TYPE> keySet(){
		return map.keySet();
	}

	@Override
	public String toString() {
		return MapPrinter.print(map);
	}
	
}
