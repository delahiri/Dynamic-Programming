package dynamicProgramming;

//http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/

public class MatrixMultiply {

	public static void main(String[] args) {
		int p[] = {5,10,3,12,5,50,6};
		int mem[][] = new int[p.length][p.length];
		int s[][] = new int[p.length][p.length];
		for(int i=0;i<p.length;i++)
		{
			for(int j=0;j<p.length;j++)
			{
				mem[i][j] = -1;
				s[i][j] = -1;
			}
		}
		
		int cost = minCost(p,mem,s,1,p.length-1);
		
		for(int p1=1;p1< mem.length;p1++)
		{
			for(int q=1;q<mem[0].length;q++)
			{
				System.out.print(mem[p1][q] +"  ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		for(int p1=1;p1< mem.length;p1++)
		{
			for(int q=1;q<mem[0].length;q++)
			{
				System.out.print(s[p1][q] +"  ");
			}
			System.out.println();
		}
		
		print(s,1,p.length-1);
		System.out.println();
		
		System.out.println(cost);
	}

	private static void print(int[][] s, int i, int j) {
		if(i==j)
		{
			System.out.print("A");
		}
		else
		{
			System.out.print("(");
			print(s,i,s[i][j]);
			print(s,s[i][j]+1,j);
			System.out.print(")");

		}
		
	}

	private static int minCost(int[] p, int[][] mem, int[][] s, int i, int j) {
		if(i==j)
			return 0;
		else if(mem[i][j] != -1)
			return mem[i][j];
		else
		{
			int cost;
			int position=-1;
			int q = Integer.MAX_VALUE;
			for(int k=i; k<j;k++)
			{
				cost = minCost(p, mem, s, i, k)+minCost(p, mem, s, k+1, j)+p[i-1]*p[j]*p[k];
				if(cost < q)
				{
					position = k;
					q=cost;
				}
			}
			mem[i][j] = q;
			s[i][j] = position;
		}
		
		return mem[i][j];
	}

	

}
