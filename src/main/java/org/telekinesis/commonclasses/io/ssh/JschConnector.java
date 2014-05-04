package org.telekinesis.commonclasses.io.ssh;

import java.util.List;
import java.util.Vector;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;

public class JschConnector {
	private JschConnector() {
	}

	public static Session connect(String host, String username, String password)
			throws JSchException {
		JSch client = new JSch();
		Session session = client.getSession(username, host);
		session.setPassword(password);
		session.setConfig("StrictHostKeyChecking", "no");
		session.connect(30000);
		return session;
	}
	
	public static ChannelSftp getSftpChannel(Session session) throws JSchException{
		ChannelSftp fileChannel = (ChannelSftp) session.openChannel("sftp");
		fileChannel.connect();
		return fileChannel;
	}

	@SuppressWarnings("unchecked")
	public static List<String> ls(Session session, String path) throws JSchException,
			SftpException {
		ChannelSftp fileChannel = (ChannelSftp) session.openChannel("sftp");
		fileChannel.connect();
		try {
			Vector<String> files = fileChannel.ls(path);
			return files;
		} finally {
			fileChannel.disconnect();
		}
	}
	
}
