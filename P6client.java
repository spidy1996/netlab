
import java.io.*;
import java.net.*;
public class P6client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket sock = new Socket("127.0.0.1", 4000);
		System.out.println("Enter the filename: ");
		BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
		String fname = key.readLine();
		OutputStream ostream = sock.getOutputStream();
		PrintWriter pwrite = new PrintWriter(ostream, true);
		pwrite.println(fname);
		InputStream istream = sock.getInputStream();
		BufferedReader socketread = new BufferedReader(new InputStreamReader(istream));
		String str;
		while((str = socketread.readLine())!= null)
		{
			System.out.println(str);
		}
		pwrite.close();
		socketread.close();
		key.close();
	}

}
