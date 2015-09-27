package dynamicProgramming;

public class MaxSumIncreasingSubsequence {

	public static void main(String[] args) {
		
		int [] arr = {1, 101, 2, 3, 100, 4, 5};
		int [] maxSumIncludingMe = new int[arr.length];
		maxSumIncludingMe[0] = arr[0];	
		int maxSum = Integer.MIN_VALUE;
		for(int i=1;i<arr.length;i++)
		{
			
			for(int j=i-1;j>=0;j--)
			{
				if(arr[j] < arr[i])
				{
					maxSum = Math.max(maxSum, maxSumIncludingMe[j]);
				}
				maxSumIncludingMe[i] = Math.max(maxSum+arr[i],arr[i]);
			}
			
		}
		maxSum = Integer.MIN_VALUE;
		for(int n:maxSumIncludingMe)
		{
			maxSum = Math.max(maxSum, n);
		}
		System.out.println(maxSum);

	}

}
