package dynamicProgramming;

public class MinCoinsRequiredForChange {

	public static void main(String[] args) {
		int d[] = {5,10,25};
		int n = 30;
		int[][] mem = [d.length+1][n+1];
		for()
		
		System.out.println(minCoinsReqd(n,d,d.length-1,mem));

	}
	
	private static int minCoinsReqd(int n,int d[],int ind)
	{
		if(n==0)
		{
			return 0;
		}
		else
		{
			int min = Integer.MAX_VALUE;
			if(d[ind] > n && ind >=1)
			{
				min = minCoinsReqd(n, d, ind-1);
			}
			else
			{
				int min1 = 1+ minCoinsReqd(n-d[ind], d, ind);
				if((ind) >=1)
				min = minCoinsReqd(n, d, ind-1);
				
				min = Math.min(min, min1);
			}
			return min;
		}
	}
	

}
