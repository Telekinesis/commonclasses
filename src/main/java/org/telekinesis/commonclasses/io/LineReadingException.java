package org.telekinesis.commonclasses.io;

public class LineReadingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2571254539930164727L;
	
	private final Exception cause;

	public LineReadingException(Exception cause) {
		this.cause = cause;
	}

	@Override
	public String toString() {
		return "LineReadingException [cause=" + cause + "]";
	}
	
}
