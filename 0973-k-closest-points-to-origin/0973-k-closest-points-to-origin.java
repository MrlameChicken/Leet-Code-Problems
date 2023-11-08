class Solution {
       public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<int[],Double>> pq = new PriorityQueue<>((x,y)-> y.getValue().compareTo(x.getValue()));

        Map<int[], Double> map = new HashMap<>();
        for (int[] point : points) {
            map.put(point, Math.pow(point[0], 2) + Math.pow(point[1], 2));
        }

        for(Map.Entry<int[],Double> entry: map.entrySet()) {
            pq.offer(entry);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];
        int count = 0;
        while(!pq.isEmpty()) {
            ans[count++] = pq.poll().getKey();
        }
        
        return ans;
    }
}