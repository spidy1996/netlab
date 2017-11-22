
import java.io.*;
import java.net.*;
public class P6server {

	public static void main(String[] args) throws IOException {
		ServerSocket skt = new ServerSocket(4000);
		System.out.println("Sytem ready for connection");
		Socket sock = skt.accept();
		System.out.println("Connection successfull, waiting for chatting");
		InputStream istream = sock.getInputStream();
		BufferedReader key = new BufferedReader(new InputStreamReader(istream));
		String fname = key.readLine();
		BufferedReader contentread = new BufferedReader(new FileReader(fname));
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);
		String str;
		while((str = contentread.readLine())!=null)
		{
			pwrite.println(str);
		}
		sock.close();
		contentread.close();
		key.close();
		pwrite.close();
	}

}
