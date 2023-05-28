class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = n - 1;
                int target = -nums[i];
                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        // Highlighted Change:
                        while (low < high && nums[low] == nums[low + 1]) low++;  // Skip duplicates for nums[low]
                        while (low < high && nums[high] == nums[high - 1]) high--;  // Skip duplicates for nums[high]
                        low++;
                        high--;
                    } else if (sum < target) {
                        low++;
                    } else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}