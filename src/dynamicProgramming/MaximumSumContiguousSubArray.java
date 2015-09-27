package dynamicProgramming;

public class MaximumSumContiguousSubArray {

	public static void main(String[] args) {
		int arr[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		int MaxSumTillHere[] = new int[arr.length];
		MaxSumTillHere[0] = arr[0];
			
		for(int i=1;i<arr.length;i++)
		{
			int j=i-1;
			MaxSumTillHere[i] = Math.max(MaxSumTillHere[j]+arr[i],arr[i]);
		}
		
		int maxSum = Integer.MIN_VALUE;
		for(int i:MaxSumTillHere)
		{
			maxSum = Math.max(i, maxSum);
		}
		System.out.println(maxSum);
	}

}
