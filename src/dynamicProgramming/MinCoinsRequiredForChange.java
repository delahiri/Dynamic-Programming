package dynamicProgramming;

public class MinCoinsRequiredForChange {

	public static void main(String[] args) {
		//int d[] = {1,5,10,25,50};
		int d[] = {1,3,7};
		int n = 12;
		int[][] mem = new int[d.length+1][n+1];
		for(int i=0;i<=d.length;i++)
			for(int j=0;j<=n;j++)
				mem[i][j] = -1;
		
		System.out.println(minCoinsReqd(n,d,d.length-1,mem));

	}
	
	private static int minCoinsReqd(int n,int d[],int ind, int[][] mem)
	{
		if(n==0)
		{
			return 0;
		}
		else if(mem[ind][n] != -1)
		{
			
			return mem[ind][n];
		}
		else
		{
				int min1 = Integer.MAX_VALUE, min = Integer.MAX_VALUE;
				
				if(ind >=1)
				{
					min = minCoinsReqd(n, d, ind-1,mem);
				}
				
				if( n >=d[ind])
				{
					min1 = 1+ minCoinsReqd(n-d[ind], d, ind,mem);
				}
				
				min = Math.min(min, min1);
			
			mem[ind][n] = min;
			return min;
		}
	}
	

}
