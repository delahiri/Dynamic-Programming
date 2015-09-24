package dynamicProgramming;


//http://www.geeksforgeeks.org/dynamic-programming-set-9-binomial-coefficient/

public class BinomialCoefficient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n=15,k=4;
		int mem[][] = new int[n+1][k+1];
		for(int i=0;i<=n;i++)
			for(int j=0;j<=k;j++)
				mem[i][j] = -1;
		System.out.println(coefficient(n,k,mem));

	}
	
	private static int coefficient(int n, int k,int[][] mem)
	{
		// k > n return 0;
		if(k > n)
		{
			return 0;
		}
		// n=0 and k=0 return 1
		if(n==0 && k==0)
		{
			return 1;
		}
		
		// k=0 return 0;
		else if(k==0)
		{
			return 1;
		}
		// n=k return 1
		else if(n==k)
		{
			return 1;
		}
		else if(mem[n][k] != -1)
		{
			System.out.println("Reading from mem"+n+","+k);
			return mem[n][k];
		}
		
		
		
		//otherwise
		// F(n,k) = F(n-1,k)+F(n-1,k-1);
		else
		{
			int val = coefficient(n-1, k,mem) + coefficient(n-1, k-1,mem);
			mem[n][k] = val;
			return val;
		}
		
		
		
		
	}

}
