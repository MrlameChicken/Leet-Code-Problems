class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> mp = new HashMap<>();
        int i=0;
        for (int num: nums) {
            if (mp.containsKey(target - num)) {
                return new int[]{i,mp.get(target-num)};
            }
            else {
                mp.put(num,i);
            }
            i++;
        }

        return new int[]{-1,-1};
    }
}