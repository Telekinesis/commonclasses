package org.telekinesis.commonclasses.io;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferedReaderProcessor implements ByLineReader<BufferedReader> {

	@Override
	public void read(BufferedReader reader, LineParser lineParser,
			int linesToSkip) {
		try {
			for (int i = 0; i < linesToSkip; i++)
				reader.readLine();
			String line;
			while ((line = reader.readLine()) != null)
				lineParser.parse(line);
			lineParser.onEnd();
		} catch (IOException e) {
			throw new LineReadingException(e);
		}
	}

}
