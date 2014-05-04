package org.telekinesis.commonclasses.collection;

import java.util.Map;
import java.util.TreeMap;

public class ToTreeMapConverter<KEY, VALUE> {
	public TreeMap<KEY, VALUE> convert(Map<KEY, VALUE> map){
		TreeMap<KEY, VALUE> target = new TreeMap<KEY, VALUE>();
		for(Map.Entry<KEY, VALUE> entry : map.entrySet())
			target.put(entry.getKey(), entry.getValue());
		return target;
	}

}
