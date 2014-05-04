package org.telekinesis.commonclasses.util;

public class EqualityChecker {
	private EqualityChecker(){}
	
	public static boolean isEqual(Object term1, Object term2){
		if(term1 == null)
			return term2 == null;
		return term1.equals(term2);
	}
}
