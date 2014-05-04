package org.telekinesis.commonclasses.util;

import java.util.List;

public class CSVStyledStringCreator {
	private CSVStyledStringCreator(){}
	
	public static String create(Object... objects){
		if(objects.length == 0)
			return "";
		StringBuffer buffer = new StringBuffer();
		buffer.append(objects[0].toString());
		for (int i = 1; i < objects.length; i++) {
			buffer.append(",");
			buffer.append(objects[i].toString());
		}
		return buffer.toString();
	}
	
	public static <T> String create(List<T> objects){
		if(objects.size() == 0)
			return "";
		StringBuffer buffer = new StringBuffer();
		buffer.append(objects.get(0).toString());
		for (int i = 1; i < objects.size(); i++) {
			buffer.append(",");
			buffer.append(objects.get(i).toString());
		}
		return buffer.toString();
	}
}
