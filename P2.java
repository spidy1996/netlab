package cnlab;

import java.util.Scanner;

public class P2 {
	
	private int d[];
	private int num_ver;
	static int MAX_VALUE=999;
	public P2(int num_ver)
	{
		this.num_ver=num_ver;
		d=new int[num_ver+1];
	}
	
	public void eval(int source, int a[][])
	{
		for(int node=1; node<=num_ver; node++)
		{
			d[node] = MAX_VALUE;
		}
		d[source] = 0;
		for(int node=1; node<=num_ver; node++)
		{
			for(int sn=1;sn<=num_ver; sn++)
			{
				for(int dn=1; dn<=num_ver; dn++)
				{
					if(a[sn][dn]!=MAX_VALUE)
					{
						if(d[dn]>d[sn]+a[sn][dn])
							d[dn]=d[sn]+a[sn][dn];
					}
				}
			}
		}
		for(int sn=1; sn<=num_ver; sn++)
		{
			for(int dn=1; dn<=num_ver; dn++)
			{
				if(a[sn][dn]!=MAX_VALUE)
				{
					if(d[dn]>d[sn]+a[sn][dn])
						System.out.println("The Graph has a negative edge cycle.");
				}
			}
		}
		for(int vertex=1; vertex<=num_ver; vertex++)
		{
			System.out.println("Distance of source from"+source+ "to vertex" + vertex + "is:" +d[vertex]);
		}
	}

	public static void main(String[] args) 
	{
		int num_ver = 0;
		int source;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no. of vertices:");
		num_ver = sc.nextInt();
		int a[][]  = new int[num_ver+1][num_ver+1];
		System.out.println("Enter the adjacency matrix:");
		for(int sn=1; sn<=num_ver; sn++)
		{
			for(int dn=1; dn<=num_ver; dn++)
			{
				a[sn][dn]=sc.nextInt();
				if(sn==dn)
					a[sn][dn]=0;
				if(a[sn][dn]==0)
					a[sn][dn]=MAX_VALUE;
			}
		}
		System.out.println("Enter the source vertex:");
		source = sc.nextInt();
		P2 b= new P2(num_ver);
		b.eval(source, a);
		sc.close();
	}

}
