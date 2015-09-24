package dynamicProgramming;

public class LongestSubsequence {

	public static void main(String[] args) {
		String a = "ACCGGTCGAGTGCGCGGAAGCCGGCCGAA";
		String b= "GTCGTTCGGAATGCCGTTGCTCTGTAAA";
		
		//char X[] = {'\0','A','B','C','B','D','A','B'};
		//char Y[] = {'\0','B','D','C','A','B','A'};
		char X[] = new char[a.length()+1];
		char Y[] = new char[b.length()+1];
		X[0] = '\0';
		X[0] = '\0';
		for(int i=1;i<X.length;i++)
			X[i] = a.charAt(i-1);
		for(int j=1;j<Y.length;j++)
			Y[j] = b.charAt(j-1);
		int LCS[][] = new int[X.length][Y.length];
		char S[][] = new char[X.length][Y.length];
		getLongestCommonSequence(X,Y,LCS,S);
		System.out.println("Length="+LCS[X.length-1][Y.length-1]);
		printLCS(S,X,X.length-1,Y.length-1);
		
		

	}

	private static void printLCS(char[][] s, char[] x, int i, int j) {
		if(i!=0 && j!=0)
		{
			char action = s[i][j];
			switch(action)
			{
				case 'B':
					printLCS(s, x, i-1, j-1);
					System.out.print(x[i]);
					break;
				case 'X':
					printLCS(s,x,i-1,j);
					break;
				case 'Y':
					printLCS(s,x,i,j-1);
					break;
			}
		}		
	}

	private static void getLongestCommonSequence(char[] x, char[] y, int[][] lcs, char[][] s) 
	{
		for(int j=0;j<y.length;j++)
			lcs[0][j] = 0;
		for(int i=0;i<x.length;i++)
			lcs[i][0] = 0;
		
		for(int i=1;i<x.length;i++)
		{
			for(int j=1;j<y.length;j++)
			{
				if(x[i] == y[j])
				{
					lcs[i][j] = 1+ lcs[i-1][j-1];
					s[i][j] = 'B';
				}
				else
				{
					if(lcs[i-1][j]> lcs[i][j-1])
					{
						lcs[i][j] = lcs[i-1][j];
						s[i][j] = 'X';
					}
					else
					{
						lcs[i][j] = lcs[i][j-1];
						s[i][j] = 'Y';
					}
				}
			}
		}
	}

}
