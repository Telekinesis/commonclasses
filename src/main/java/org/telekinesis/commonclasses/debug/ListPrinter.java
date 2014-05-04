package org.telekinesis.commonclasses.debug;

import java.util.List;

public class ListPrinter {
	private ListPrinter(){}
	
	public static <T> void print(List<T> list){
		for (T t : list)
			System.out.println(t);
	}
	
	public static <T> void print(List<T> list, int count){
		for (int i = 0; i < list.size() && i < count; i++)
			System.out.println(list.get(i));
	}
	
	public static <T> void print(List<T> list, ObjectPrinter<T> printer){
		for (T t : list) {
			System.out.println(printer.print(t));
		}
	}
}
