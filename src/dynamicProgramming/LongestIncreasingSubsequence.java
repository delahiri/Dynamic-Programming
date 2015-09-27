package dynamicProgramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		int l[] = new int[a.length];
		System.out.println(getLongestIncreasingSubsequence(a, l));

	}
	
	
	private static int getLongestIncreasingSubsequence(int a[],int l[])
	{
		l[0] = 1;
		for(int i=1;i<a.length;i++)
		{
			int max = 0;
			for(int j=i-1;j>=0;j--)
			{
				if(a[j] < a[i])
				{
					max = Math.max(max,l[j]);
				}
				
			}
			l[i] = max+1;
		}
		
		int max = 0;
		
		for(int i:l)
		{
			max = Math.max(max, i);
		}
		
		return max;
	}

}
