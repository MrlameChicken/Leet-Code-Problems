class Solution {
    public int jump(int[] nums) {
        int j = 0;
        int farthest = 0;
        int currentEnd = 0;
        int jumps = 0;
        
        if (nums.length == 1) {
            return 0;
        }
        
        while(j<nums.length-1) {
            
             farthest = Math.max(farthest, j + nums[j]);

            // If you reach the currentEnd, update it to the farthest position and increment jumps
            if (j == currentEnd) {
                currentEnd = farthest;
                jumps++;
            }
            
            j++;
        }
        
        return jumps;
    }
}