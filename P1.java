package cnlab;
import java.io.*;
public class P1 {

	public static void main(String[] args) throws Exception {
		InputStreamReader isr= new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		int[] msg;
		int[] gen;
		int[] app_msg;
		int[] rcm;
		int[] trans_msg;
		int i;
		int msg_b,gen_b,total_bits;
		System.out.println("Enter no. of bits in msg:");
		msg_b = Integer.parseInt(br.readLine());
		msg = new int[msg_b];
		System.out.println("\nEnter msg bits:");
		for(i=0; i<msg_b; i++)
		{
			msg[i] = Integer.parseInt(br.readLine());
		}
		System.out.println("Enter no. of bits in gen");
		gen_b = Integer.parseInt(br.readLine());
		gen = new int[gen_b];
		System.out.println("Enter gen bits:");
		for(i=0; i<gen_b; i++)
		{
			gen[i] = Integer.parseInt(br.readLine());
		}
		total_bits = msg_b + gen_b -1;
		app_msg = new int[total_bits];
		rcm = new int[total_bits];
		trans_msg = new int[total_bits];
		for(i=0; i<msg.length;i++)
			app_msg[i] = msg[i];
		System.out.println("Msg bits are:");
		for(i=0; i<msg_b; i++)
			System.out.println(msg[i]);
		System.out.println("gen bits are:");
		for(i=0; i<gen_b; i++)
			System.out.println(gen[i]);
		System.out.println("Appended msg is:");
		for(i=0; i<app_msg.length; i++)
			System.out.println(app_msg[i]);
		for(i=0; i<app_msg.length; i++)
			rcm[i] = app_msg[i];
		rcm = computecrc(app_msg, gen, rcm);
		for(i=0; i<app_msg.length; i++)
			trans_msg[i] = (app_msg[i]^rcm[i]);
		System.out.println("Transmitted msg from transmission is");
		for(i=0; i<trans_msg.length; i++)
			System.out.println(trans_msg[i]);
		System.out.println("enter msg of" + total_bits + "bits recieved");
		for(i=0; i<trans_msg.length; i++)
			trans_msg[i] = Integer.parseInt(br.readLine());
		System.out.println("Received msg is:");
		for(i=0; i<trans_msg.length; i++)
		{
			System.out.println(trans_msg[i]);
			rcm[i]=trans_msg[i];
		}
		rcm=computecrc(trans_msg, gen, rcm);
		for(i=0; i<rcm.length;i++)
		{
			if(rcm[i]!=0)
			{
				System.out.println("\n Error");
				break;
			}
		}
		if(i == rcm.length)
		{
			System.out.println("no error");
		}
	}
	static int[] computecrc(int app_msg[], int gen[], int rcm[])
	{
		int cur = 0;
		while(true)
		{
			for(int i=0; i<gen.length; i++)
				rcm[cur+i] = (int)(rcm[cur+i]^gen[i]);
			while(rcm[cur] == 0 && cur!=rcm.length-1)
				cur++;
			if((rcm.length-cur)<gen.length)
				break;
		}
		return rcm;	
	}
}
