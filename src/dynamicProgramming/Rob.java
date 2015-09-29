package dynamicProgramming;

public class Rob {
	
	
    public static void main(String args[]) {
    	
    	int nums[] = {4,6,2,7,6,9,4,6,90,2,3,5,76,34,78};
    	
        if(nums.length ==0)
        System.out.println(0);
        else
        System.out.println(rob(nums, nums.length-1,new int[nums.length]));
        
    }
    
    private static int rob(int[] nums, int n, int[] mem)
    {
        if(n==0)
        {
            return nums[0];
        }
        else if(mem[n] != 0)
        {
            System.out.println("Read "+n);
            return mem[n];
        }
        else
        {
           int q =  nums[n];
           if(n>=2)
           {
            q+=rob(nums,n-2,mem);
           }
           int q1 = rob(nums,n-1,mem);
           int q2 = Math.max(q1,q);
           
           mem[n] = q2;
           return q2;
           
        }
    }
}