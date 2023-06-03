class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int current = 0;
        int max = 0;
        for (int num: nums) { 
            if (num == 0) {
                current = 0;
            }
            else {
              current++;
               max = Math.max(current,max);
            }
        }
        System.gc();
        return max;
    }
}