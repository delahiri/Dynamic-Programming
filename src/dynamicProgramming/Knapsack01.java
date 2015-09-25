package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

//http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/

public class Knapsack01 {
	public static void main(String args[])
	{
		int vl[] = {60, 100, 120,15,140,160,170};
	    int wt[] = {10, 20, 25, 30,35, 40,55};
	    int  tot = 540;
	    Map<String,Integer> mem = new HashMap<String,Integer>();
		int maxWt = getMaxValue(wt,vl,wt.length-1,tot,mem);
		System.out.println(maxWt);
		
	}

	private static int getMaxValue(int[] wt, int[] vl, int m,int tot,Map<String,Integer> mem) {

		if(tot == 0)
		return 0;
		else if(m<0)
			return 0;
		else if(mem.containsKey(tot+"_"+m))
		{
		//	System.out.println("Got from mem"+tot+"_"+mem);
			return mem.get(tot+"_"+m);
		}
		else
		{
			// either i take mth or i dont;
			int val1 = vl[m] + getMaxValue(wt, vl, m-1, tot-wt[m],mem);
			int val2 = getMaxValue(wt, vl, m-1, tot,mem);
			if(val1 > val2)
			{
				mem.put(tot+"_"+m, val1);
				return val1;
			}
			else	
			{
				mem.put(tot+"_"+m, val2);
				return val2;
			}
				
		}
	}
	
	//
	

}
