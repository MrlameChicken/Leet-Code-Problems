class Solution {
    public int subarraySum(int[] nums, int k) {
        
       int j = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        
        map.put(0,1);
        
        while(j<nums.length) {
            sum += nums[j];
            
            
            if (map.get(sum - k) != null) {
                ans += map.get(sum-k);
            }
            
             map.put(sum,map.getOrDefault(sum,0)+1);
            
            j++;
            
            
        }
        
        return ans;
        
    }
}