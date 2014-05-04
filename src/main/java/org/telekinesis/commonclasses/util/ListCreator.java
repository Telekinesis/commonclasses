package org.telekinesis.commonclasses.util;

import java.util.ArrayList;
import java.util.List;

public class ListCreator {
	public static <T> List<T> create(T... objects){
		List<T> result = new ArrayList<T>();
		for(T obj : objects)
			result.add(obj);
		return result;
	}
}
