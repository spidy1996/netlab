package cnlab;

import java.util.Scanner;

public class P4 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int no_of_groups, bucket_size;
		System.out.println("Enter the bucket size:");
		bucket_size = sc.nextInt();
		System.out.println("Enter the no. of groups:");
		no_of_groups = sc.nextInt();
		int no_packets[] = new int[no_of_groups];
		int in_bw[]= new int[no_of_groups];
		int out_bw, read_bw=0, tot_packets=0;
		for(int i=0; i<no_of_groups; i++)
		{
			System.out.println("enter the total no of packets for group:" + (i+1) +"\t");
			no_packets[i] = sc.nextInt();
			System.out.println("enter input bandwidth of group"+(i+1)+"\t");
			in_bw[i] = sc.nextInt();
			if((tot_packets+no_packets[i])<bucket_size)
				tot_packets += no_packets[i];
			else
			{
				do
				{
					System.out.println("Bucket Overflow");
					System.out.println("enter value less than"+ (bucket_size-tot_packets));
					no_packets[i] = sc.nextInt();
				}while((tot_packets+no_packets[i])>bucket_size);
				tot_packets+=no_packets[i];
			}
			read_bw += (no_packets[i]*in_bw[i]);
		}
		System.out.println("The total bandwidth is:" + read_bw);
		System.out.println("Enter the output bandwidth:");
		out_bw = sc.nextInt();
		int temp = read_bw;
		int rem_packets = tot_packets;
		while((out_bw <= temp)&&(rem_packets>0))
		{
			System.out.println("Data sent, " + (--rem_packets) + "packets remaining.");
			System.out.println("remaining bandwidth is:" + (temp -= out_bw));
			if((out_bw>temp)&&(rem_packets>0))
			{
				System.out.println(rem_packets + "discarded due to insufficient memory.");
			}
		}
		sc.close();
	}
}
