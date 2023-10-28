class Solution {
  public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.getValue(),a.getValue()));

        HashMap<Character,Integer> hashMap = new HashMap<>();

        char[] c = s.toCharArray();
        for(char ch: c) {
            hashMap.put(ch,hashMap.getOrDefault(ch,0)+1);
        }

        for (Map.Entry<Character,Integer> mp: hashMap.entrySet()) {
            pq.offer(mp);
        }

        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()) {
            int i = 0;
            while (i < pq.peek().getValue()) {
                sb.append(pq.peek().getKey());
                i++;
            }
            pq.poll();
        }
        
        return sb.toString();

    }
}