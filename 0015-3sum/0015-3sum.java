class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int length = nums.length;
        
        
        for(int i=0;i<length-2;i++){
            if (i == 0 || nums[i]!=nums[i-1]) {
                 int low = i+1; int sum = - nums[i]; int high = length - 1;
                while(low < high) {
                    int currentSum = nums[low] + nums[high];
                    if (currentSum == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        high--;
                    }
                    else if (currentSum < sum){
                        low++;
                    }
                    else {
                        high--;
                    }
                }
            }
        }
        return result;
    }
}