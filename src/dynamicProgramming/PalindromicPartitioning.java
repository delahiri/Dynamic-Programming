package dynamicProgramming;

public class PalindromicPartitioning {

	public static void main(String[] args) {
		String s = "ababbbabbababa";
		System.out.println(minPartitioning(s, 0, s.length()-1));
	
				
	}
	
	private static int minPartitioning(String s, int i, int j)
	{
		if(i==j)
		{
			return 0;
		}
		if(isPalindrome(s.substring(i,j)))
		{
			return 0;
		}
		else
		{
			int q = Integer.MAX_VALUE;
			int cuts;
			for(int k=i;k<j;k++)
			{
				cuts = 1+ minPartitioning(s, i, k)+ minPartitioning(s, k+1, j);
				q = Math.min(q, cuts);
			}
			return q;
		}
		
		
	}

	private static boolean isPalindrome(String substring) {
		boolean isPalindrome = true;
		for(int i = 0; i<substring.length()/2;i++)
		{
			if(substring.charAt(i) != substring.charAt(substring.length()-i-1))
			{
				isPalindrome = false;
				break;
			}
		}
		return isPalindrome;
	}

}
