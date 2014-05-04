package org.telekinesis.commonclasses.io;


public interface ByLineReader<T> {
	public void read(T target, LineParser lineParser, int skippedLines) throws LineReadingException;
}
