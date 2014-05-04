package org.telekinesis.commonclasses.io;

public interface LineParser {
	public void parse(String line);
	public void onEnd();
}
