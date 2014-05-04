package org.telekinesis.commonclasses.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MultiTreeMap<K, V> {
	private final TreeMap<K, List<V>> map = new TreeMap<K, List<V>>();
	
	public void put(K key, V value){
		List<V> valueList = map.get(key);
		if(valueList == null){
			valueList = new ArrayList<V>();
			map.put(key, valueList);
		}
		valueList.add(value);
	}
	
	public List<V> get(K key){
		List<V> valueList = map.get(key);
		if(valueList == null)
			return new ArrayList<V>();
		return valueList;
	}
	
	public List<V> convertedToSortedList(){
		List<V> valueList = new ArrayList<V>();
		for(K key : map.keySet())
			valueList.addAll(map.get(key));
		return valueList;
	}
}
