package org.telekinesis.commonclasses.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamLineReader implements ByLineReader<InputStream> {

	@Override
	public void read(InputStream target, LineParser lineParser, int skippedLines) {
		BufferedReader br = new BufferedReader(new InputStreamReader(target));
		try {
			BufferedReaderProcessor processor = new BufferedReaderProcessor();
			processor.read(br, lineParser, skippedLines);
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				throw new LineReadingException(e);
			}
		}
	}

}
