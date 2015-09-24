package dynamicProgramming;

public class RodCutting {
public static void main(String args[])
{
	int p[] = {0,1,5,8,11,10,17,17,20,24,30};
	int maxCost = bottomUpCut(p, 4, 1);
	System.out.println(maxCost);
}

private static int bottomUpCut(int[] p, int n, int c)
{
	int r[] = new int[n+1];
	r[0] = 0;
	int rev;
	for(int j=1;j<=n;j++)
	{
		int q = Integer.MIN_VALUE;
		for(int i=1;i<=j;i++)
		{			
			rev = p[i]+r[j-i];
			if(i!=j)
			{
				rev -=c;
			}
			q = Math.max(q, rev);
		}
		r[j] = q;
		
	}
	
	return r[n];
}

}
