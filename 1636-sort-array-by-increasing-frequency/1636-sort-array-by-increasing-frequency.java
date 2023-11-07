class Solution {
    public int[] frequencySort(int[] nums) {
      // PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(Map.Entry.comparingByValue());
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((x,y) -> {
            if(x.getValue().equals(y.getValue())) {
                return y.getKey().compareTo(x.getKey());
            }
           return x.getValue().compareTo(y.getValue());
        });
        
        //PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((x,y) -> y.getValue().compareTo(x.getValue()));
        
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int num:nums) {
            //pq.offer(num);
            map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            pq.offer(entry);
        }
        
        int[] ans = new int[nums.length];
        int count = 0;
        
        while(!pq.isEmpty()) {
            for (int i = 0;i<pq.peek().getValue();i++)
                ans[count++] = pq.peek().getKey();
            pq.poll();
        }
        
        return ans;
        
        
    }
}