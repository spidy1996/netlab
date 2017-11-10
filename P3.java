package cnlab;
import java.math.BigInteger;
import java.util.Random;
import java.io.*;
public class P3 {
	
	private BigInteger p,q,n,phi,e,d;
	private int bitlength=1024;
	private int blocksize=256;
	private Random r;
	public P3() 
	{
		r=new Random();
		p = BigInteger.probablePrime(bitlength, r);
		q = BigInteger.probablePrime(bitlength, r);
		n = p.multiply(q);
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(bitlength/2, r);
		while((phi.gcd(e)).compareTo(BigInteger.ONE)>0 && e.compareTo(phi)<0)
		{
			e.add(BigInteger.ONE);
		}
		d = e.modInverse(phi);
	}
	public P3(BigInteger e, BigInteger d, BigInteger n)
	{
		this.e = e;
		this.d = d;
		this.n = n;
	}
	public static void main(String[] args) throws IOException 
	{
		P3 rsa = new P3(); 
		DataInputStream in = new DataInputStream(System.in);
		String teststring;
		System.out.println("Enter plain text:");
		teststring = in.readLine();
		System.out.println("Encryption String:"+ teststring);
		System.out.println("String in bytes" + bytesToString(teststring.getBytes()));
		byte[] encrypted = rsa.encrypt(teststring.getBytes());
		System.out.println("Encrypted String in bytes:" + encrypted);
		byte[] decrypted = rsa.decrypt(encrypted);
		System.out.println("Decrypted String in bytes:" + bytesToString(decrypted));
		System.out.println("Decrypted String:" + new String(decrypted));
	}
	public byte[] encrypt(byte[] message)
	{
		return(new BigInteger(message).modPow(e, n).toByteArray()); 
	}
	public byte[] decrypt(byte[] message)
	{
		return(new BigInteger(message).modPow(d, n).toByteArray()); 
	}
	private static String bytesToString(byte[] encrypted)
	{
		String test="";
		for(byte b: encrypted)
			test+=Byte.toString(b);
		return test;
	}
}
