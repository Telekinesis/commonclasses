package org.telekinesis.commonclasses.iteration;

import java.util.ArrayList;
import java.util.List;

public class ListVisitor {
	private ListVisitor(){}
	
	public static <T, R> R visit(List<T> list, ListElementVisitor<T, R> elementVisitor){
		int elementBufferSize = elementVisitor.elementCountPerIteration();
		List<T> elementBuffer = new ArrayList<T>();
		for(int i = 0; i < elementBufferSize; i++)
			elementBuffer.add(list.get(i));
		for(int i = elementBufferSize; i < list.size(); i++){
			elementBuffer.remove(0);
			elementBuffer.add(elementBufferSize - 1, list.get(i));
			elementVisitor.visit(elementBuffer);
		}
		return elementVisitor.getResult();
	}
}
