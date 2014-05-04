package org.telekinesis.commonclasses.debug;

import java.util.Map;

public class MapPrinter {
	private MapPrinter(){}
	
	public static <KEY, VALUE> String print(Map<KEY, VALUE> map){
		StringBuffer buffer = new StringBuffer();
		for(Map.Entry<KEY, VALUE> entry : map.entrySet()){
			buffer.append(entry.getKey());
			buffer.append('\t');
			buffer.append(entry.getValue());
			buffer.append('\n');
		}
		return buffer.toString();
	}
}
