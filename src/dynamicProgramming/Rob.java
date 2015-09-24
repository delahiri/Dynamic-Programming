package dynamicProgramming;

public class Rob {
	
	public static void main(String args[])
	{
		int nums[] = {2,7,9,3,1,3,6,8,3,2,9,5,6,2,9,2,4,1,6,8,8,5,3,4,6,8,9};
		System.out.println(rob(nums));
	}
    public static int rob(int[] nums) {
        if(nums.length == 0)
        return 0;
        int[][] mem = new int[nums.length][nums.length];
        return rob(nums,mem,0,nums.length-1);
    }
    
    static int rob(int[] nums, int[][] mem, int start, int end)
    {
        if(mem[start][end] != 0)
        {
        	System.out.println("got"+start+","+end);
            return mem[start][end];
        }
        else if(start == end)
        {
            mem[start][start] = nums[start];
            return nums[start];
        }
        else if(end == (start+1))
        {
            int r = Math.max(nums[start],nums[end]);
            mem[start][end] = r;
            return r;
        }
        else
        {
            int max = 0;
            for(int i=start;i<=end;i++)
            {
               int leftEnd = i-2;
               int rightStart = i+2;
               int q=0;
               if(leftEnd >=0)
               {
                   q+=rob(nums,mem,0,leftEnd);
               }
               if(rightStart <=end)
               {
                   q+=rob(nums,mem,rightStart,end);
               }
               q+=nums[i];
               max = Math.max(q,max);
            }
            mem[start][end] = max;
            return max;
        }
    }
}