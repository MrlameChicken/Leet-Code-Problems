class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return map.get(b) - map.get(a);
            }
        });
        
        for (Integer n:map.keySet()) {
            pq.offer(n);
        }
        
        int[] ans = new int[k];
        
        for(int i=0; i<k; i++){
            ans[i]=pq.poll();
        }
        
        return ans;
        
    }
}