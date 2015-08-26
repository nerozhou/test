import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


public class FTPTest {
	static public void main(String[] args) throws SocketException, IOException {
		
		FTPClient ftp = new FTPClient();
		ftp.connect("192.168.203.158");
		ftp.login("zhou", "zhou");
		

		
		
		
		if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
			FTPFile[] files = ftp.listFiles();
			System.out.println(files.length);
		}
	}
}
