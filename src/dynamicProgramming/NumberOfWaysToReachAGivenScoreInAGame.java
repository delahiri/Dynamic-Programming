package dynamicProgramming;

public class NumberOfWaysToReachAGivenScoreInAGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] p= {3,5,10};
		int n=20;
		int[][] mem = new int[n+1][p.length+1];
		for(int i=0;i<=(n);i++)
			for(int j=0;j<=p.length;j++)
				mem[i][j] = -1;
		
		System.out.println(noOfWays(n, p, p.length-1, mem));
			
	}
	private static int noOfWays(int n, int[] p,int pind,int[][] mem)
	{
		if(n==0)
		{
			return 1;
		}
		else if(n<0 || pind <0 || p[pind] > n)
		{
			return 0;
		}
		else
		{
			int val = noOfWays(n, p, pind-1, mem) + noOfWays(n-p[pind], p, pind, mem);
			return val;
		}
	}

}
