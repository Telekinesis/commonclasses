package org.telekinesis.commonclasses.util;

public class EqualsHelper {
	private EqualsHelper(){}
	
	public static boolean equals(Object[] termList1, Object[] termList2){
		if(termList1 == null || termList2 == null)
			return false;
		if(!(termList1.length == termList2.length))
			return false;
		boolean result = compareTerms(termList1, termList2);
		return result;
	}
	
	private static boolean compareTerms(Object[] termList1, Object[] termList2){
		for(int i = 0; i < termList1.length; i++){
			Object term1 = termList1[i];
			Object term2 = termList2[i];
			if(term1 == null && term2 != null)
				return false;
			if(!term1.equals(term2))
				return false;
		}
		return true;
	}
}
