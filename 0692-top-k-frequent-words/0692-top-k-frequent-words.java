class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String word:words) {
            map.put(word, map.getOrDefault(word,0)+1);
        }
        
        PriorityQueue<String> queue = new PriorityQueue<>(new Comparator<String>() {
           public int compare(String a, String b) {
               if ( map.get(b) - map.get(a) == 0 ) {
                   return a.compareTo(b);
               } else {
                   return map.get(b) - map.get(a);
               }
           } 
        });
        
        for (String word: map.keySet()) {
            queue.offer(word);
        }
        
        List<String> ans = new ArrayList<>();
        
        for (int i=0;i<k;i++) {
            ans.add(queue.poll());
        }
        
        return ans;
    }
}