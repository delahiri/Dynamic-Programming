package dynamicProgramming;

public class MinimumEdits {

	public static void main(String[] args) {
		String a = "SUNDAY";
		String b = "SATURDAY";
		int[][] mem = new int[a.length()+1][b.length()+1];
		for(int i=0;i<=a.length();i++)
			for(int j=0;j<= b.length();j++)
				mem[i][j] = -1;
				
			
		System.out.println(minEdits(a,b,a.length()-1,b.length()-1,mem));
		

	}
	
	private static int minEdits(String a, String b, int i, int j, int[][] mem)
	{
		if(i==0 && j==0)
		{
			return 0;
		}
		else if(i==0 && j!=0)
		{
			return j;
		}
		else if(i!=0 && j==0)
		{
			return i;
		}
		else if(mem[i][j] != -1)
		{
		//	System.out.println("readm it from mem"+i+","+j);
			return mem[i][j];
		}
		else
		{
			
			int cutA = Integer.MAX_VALUE,cutB = Integer.MAX_VALUE,dntCut = Integer.MAX_VALUE;
				
				dntCut =minEdits(a,b,i-1,j-1,mem) + (a.charAt(i)==b.charAt(j) ?0:1);
				cutA = minEdits(a,b,i-1,j,mem)+1;
				cutB = minEdits(a,b,i,j-1,mem)+1;
				int min = Math.min(Math.min(cutA,cutB),dntCut);
				mem[i][j] = min;
				return min;
				
			}
			
		}
	}


