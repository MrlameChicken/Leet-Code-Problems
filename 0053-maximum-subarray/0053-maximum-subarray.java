class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0,max = Integer.MIN_VALUE;
        int j = 0;
        
        while(j<nums.length) {
            
            sum += nums[j];
            
            max  = Math.max(max,sum);
            
            if (sum<0) {
                sum = 0;
            }
            
            j++;
        }
        return max;
    }
}