package dynamicProgramming;

// http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/


public class CoinChange {

	public static void main(String[] args) {
		int d[] = {1,2,3};
		int dInd = d.length-1;
		int n = 4;
		
		int mem[][] = new int[n+1][d.length+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=d.length;j++)
				mem[i][j] = -1;
		
		System.out.println(typeOfChanges(d, dInd, n,mem));
		

	}
	private static int typeOfChanges(int d[],int dInd, int n,int[][] mem)
	{
		if(n==0)
		{
			return 1;
		}
		else if(n<0 || dInd<0)
		{
			return 0;
		}
		else
		{
			if(mem[n][dInd] != -1)
			{
				System.out.println("Read from mem"+ n+","+dInd);
				return mem[n][dInd];
			}
			else
			{
				int val = typeOfChanges(d, dInd, n-d[dInd],mem) + typeOfChanges(d, dInd-1, n,mem);
			//use the dInd'th denom or dont use it
				mem[n][dInd] = val;
			return val;
			}
		}
	}

}
