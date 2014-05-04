package org.telekinesis.commonclasses.io;

import java.io.InputStream;

import org.telekinesis.commonclasses.io.ssh.JschConnector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class SshLineFileReader implements ByLineReader<String> {
	private final String host;
	private final String username;
	private final String password;

	public SshLineFileReader(String host, String username, String password) {
		this.host = host;
		this.username = username;
		this.password = password;
	}

	@Override
	public void read(String target, LineParser lineParser, int skippedLines) {
		try {
			Session session = JschConnector.connect(host, username, password);
			try {
				ChannelSftp channel = JschConnector.getSftpChannel(session);
				try {
					InputStream stream = channel.get(target);
					InputStreamLineReader reader = new InputStreamLineReader();
					reader.read(stream, lineParser, skippedLines);
				} catch (SftpException e) {
					throw new LineReadingException(e);
				} finally {
					channel.disconnect();
				}
			} finally {
				session.disconnect();
			}
		} catch (JSchException e) {
			throw new LineReadingException(e);
		}
	}

}
