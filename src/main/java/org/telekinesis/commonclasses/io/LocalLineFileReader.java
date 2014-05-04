package org.telekinesis.commonclasses.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LocalLineFileReader implements ByLineReader<String> {

	@Override
	public void read(String path, LineParser lineParser, int skippedLines) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			try {
				BufferedReaderProcessor processor = new BufferedReaderProcessor();
				processor.read(reader, lineParser, skippedLines);
			} finally {
				try {
					reader.close();
				} catch (IOException e) {
					throw new LineReadingException(e);
				}
			}
		} catch (FileNotFoundException e) {
			throw new LineReadingException(e);
		}

	}

}
