class Solution {
       public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1,p2)->Integer.compare(p2[0]*p2[0] + p2[1]*p2[1],p1[0]*p1[0] + p1[1]*p1[1]));
            
      int i = 0;
       while(i < points.length) {
           pq.offer(points[i]);
           if(pq.size()>k) {
               pq.poll();
           }
           i++;
       }
                                                      
       int count = 0;
               int[][] ans = new int[k][2];                                       
        while(pq.size()!=0) {
            ans[count++] = pq.poll();
        }
           return ans;
    }
}