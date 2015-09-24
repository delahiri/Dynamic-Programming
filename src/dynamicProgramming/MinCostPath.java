package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class MinCostPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a = {{9,3,1},{14,18,7},{10,15,13}};
		Map<String,Integer> mem = new HashMap<String, Integer>();
		
		int pathCost = getMinPath(a,0,0,2,2,mem);
		System.out.println(pathCost);
		

	}

	private static int getMinPath(int[][] a,int i, int j, int k, int l,Map<String,Integer> mem)
	{
		if(i==k && j== l)
		{
		return a[i][j];
		}
		else if(mem.containsKey(i+"_"+j+"_"+k+"_"+l))
		{System.out.println("read from map"+i+","+j+","+k+","+l);
		return mem.get(i+"_"+j+"_"+k+"_"+l);
		}
		else
		{
			int right =Integer.MAX_VALUE,diag = Integer.MAX_VALUE,down = Integer.MAX_VALUE;
			if((i+1)<a.length)
			{
				down = a[i][j] + getMinPath(a, i+1, j, k, l, mem);
			}
			if((j+1)<a[0].length)
			{
				right = a[i][j] + getMinPath(a, i, j+1, k, l, mem);
			}
			if((i+1) < a.length && (j+1) <a[0].length)
			{
				diag = a[i][j] + getMinPath(a, i+1, j+1, k, l, mem);
			}
			int val = Math.min(down,Math.min(diag, right));
			
			 mem.put(i+"_"+j+"_"+k+"_"+l,val);
			 return val;
			
			
		}
		
	}

}
