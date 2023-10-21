class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        
        while(j<nums.length) {
            sum += nums[j];
            
            if (sum>=target) {
                while(sum-nums[i] >= target) {
                    sum = sum-nums[i];
                    i++;
                }
                min = Math.min(min,j-i+1);
            }
            
            j++;
        }
        
        if(min==Integer.MAX_VALUE) {
            return 0;
        }
            
        return min;
    }
}