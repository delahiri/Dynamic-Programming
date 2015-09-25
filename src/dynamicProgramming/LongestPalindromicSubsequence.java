package dynamicProgramming;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		String a = "DEBANIK LAHIRI";
		String b = "";
		int[][] mem = new int[a.length()+1][a.length()+1];
		for(int i=0;i<=a.length();i++)
			for(int j=0;j<=a.length();j++)
				mem[i][j] = -1;
		
		for(int i=a.length()-1;i>=0;i--)
			b+=a.charAt(i);
		
		System.out.println(getLongestPalindromicSubsequence(a, b, a.length()-1, b.length()-1,mem));
		

	}
	
	private static int getLongestPalindromicSubsequence(String a, String b, int i,int j, int[][] mem)
	{
		if(i<=0 || j<=0)
			return 0;
		else if(mem[i][j] !=-1)
		{
			return mem[i][j];
		}
		else
		{
			int p=Integer.MIN_VALUE,q = Integer.MIN_VALUE,r = Integer.MIN_VALUE;
			if(a.charAt(i) == b.charAt(j))
			{
				p= (1+ getLongestPalindromicSubsequence(a, b, i-1, j-1,mem));
			}
			else
			{
				q=getLongestPalindromicSubsequence(a, b, i-1, j,mem);
				r=getLongestPalindromicSubsequence(a, b, i, j-1,mem); 
			}
			int val = Math.max(p, Math.max(q,r));
			mem[i][j] = val;
			return val;
		}
	}

}
