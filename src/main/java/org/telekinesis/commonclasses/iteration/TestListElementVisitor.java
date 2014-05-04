package org.telekinesis.commonclasses.iteration;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestListElementVisitor {
	static class OddCounter implements ListElementVisitor<Integer, Integer>{
		int count = 0;
		
		@Override
		public void visit(List<Integer> elements) {
			int value = elements.get(0);
			if(value % 2 == 1)
				count++;
		}

		@Override
		public int elementCountPerIteration() {
			return 1;
		}
		
		@Override
		public Integer getResult(){
			return count;
		}
	}
	
	@Test
	public void countOddNumbers(){
		List<Integer> testList = new ArrayList<Integer>();
		for(int i = 0; i < 104; i++)
			testList.add(i);
		ListElementVisitor<Integer, Integer> counter = new OddCounter();
		int result = ListVisitor.visit(testList, counter);
		Assert.assertEquals(52, result);
	}
}
