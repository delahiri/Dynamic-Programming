package dynamicProgramming;

import java.util.Map;

public class ShortestCommonSupersequence {

	public static void main(String[] args) {
		String a = "";
		String b = "";
		int i;
		int j;
		
		
	}
	
	private int getcomonSuperSeqLen(String a, String b,int i,int j,Map<Integer,Integer> mem)
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
		else
		{
			int p = Integer.MAX_VALUE;
			int q = Integer.MAX_VALUE;
			int r = Integer.MAX_VALUE;
			
			if(a.charAt(i) == b.charAt(j))
			p = 1+ getcomonSuperSeqLen(a, b, i-1, j-1, mem);
			
			q = getcomonSuperSeqLen(a, b, i, j, mem)
			
			
			
			
		}
		return 0;
	}
	
	
	
}
