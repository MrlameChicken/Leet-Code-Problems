class Solution {
    public boolean canJump(int[] nums) {
        int j = 0;
        int maxReach = 0;
        
        while(j<nums.length) {
            if (j > maxReach) {
                return false;
            }
            
            maxReach = Math.max(maxReach,j+nums[j]);
            
            j++;
        }
        
        return true;
    }
}