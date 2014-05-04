package org.telekinesis.commonclasses.iteration;

import java.util.List;

public interface ListElementVisitor<T, R> {
	public void visit(List<T> elements);
	public int elementCountPerIteration();
	public R getResult();
}
