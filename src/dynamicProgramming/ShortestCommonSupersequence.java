package dynamicProgramming;

//http://www.geeksforgeeks.org/shortest-common-supersequence/
public class ShortestCommonSupersequence {

	public static void main(String[] args) {
		String a = "DEBANIK";
		String b = "LAHIRI";
		int i=a.length()-1;
		int j=b.length()-1;
		int[][] mem = new int[a.length()+1][b.length()+1];
		for(int p=0;p<=a.length();p++)
			for(int q=0;q<=b.length();q++)
				mem[p][q] = -1;
		System.out.println(getcomonSuperSeqLen(a, b, i, j, mem));
		
		
	}
	
	private static int getcomonSuperSeqLen(String a, String b,int i,int j,int[][] mem)
	{
		if(i==0 && j==0)
		{
			return 0;
		}
		else if(i==0 && j!=0)
		{
			return j;
		}
		else if(j==0 && i!=0)
		{
			return i;
		}
		else if(mem[i][j] != -1)
		{
			return mem[i][j];
		}
		else
		{
			int p = Integer.MAX_VALUE;
			int q = Integer.MAX_VALUE;
			int r = Integer.MAX_VALUE;
			
			if(a.charAt(i) == b.charAt(j))
			p = 2+ getcomonSuperSeqLen(a, b, i-1, j-1, mem);
			
			q = getcomonSuperSeqLen(a, b, i-1, j, mem)+1;
			
			r = getcomonSuperSeqLen(a, b, i, j-1, mem)+1 ;
			
			int val = Math.min(p, Math.min(q, r));
			mem[i][j] = val;
			return val;
			
			
			
			
		}
		
	}
	
	
	
}
