class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int max = 0;
        for (int num: nums) { 
            if (num == 0) {
                max = Math.max(current,max); 
                current = 0;
            }
            else {
              current++;
               
            }
        }
        max = Math.max(current,max); 
        return max;
    }
}