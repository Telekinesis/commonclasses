package org.telekinesis.commonclasses.collection;

public class HashCalculator {
	public static final int initialValue = 17;
	public static final int multiplier = 37;
	
	private HashCalculator(){}
	
	public static int hash(Object... terms){
		int result = initialValue;
		for(Object term : terms)
			result = result * multiplier + hash(term);
		return result;
	}
	
	private static int hash(Object input){
		if(input == null)
			return 0;
		return input.hashCode();
	}
}
