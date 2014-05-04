package org.telekinesis.commonclasses.collection;

import java.util.List;
import java.util.Set;

public class KeyToAverage<KEY_TYPE> {
	private KeyToValueList<KEY_TYPE, Double> mapping = new KeyToValueList<KEY_TYPE, Double>();
	
	public void add(KEY_TYPE key, Double valueToBeAppended){
		mapping.put(key, valueToBeAppended);
	}
	
	public double getAverage(KEY_TYPE key){
		List<Double> values = mapping.get(key);
		if(values.isEmpty())
			return 0;
		return calculateAverage(values);
	}
	
	private double calculateAverage(List<Double> values){
		double sum = 0;
		for(double d : values)
			sum += d;
		return sum / values.size();
	}
	
	public Set<KEY_TYPE> keySet(){
		return mapping.keySet();
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(KEY_TYPE key : mapping.keySet()){
			buffer.append(key);
			buffer.append("\t");
			buffer.append(getAverage(key));
			buffer.append("\n");
		}
		return buffer.toString();
	}
	
}
