class Solution {
    public int firstUniqChar(String s) {
        LinkedHashMap<Character,Integer> hs = new LinkedHashMap<>();
        
        char[] c = s.toCharArray();
        for(char ch: c) {
            hs.put(ch,hs.getOrDefault(ch,0)+1);
        }
        
        for(Map.Entry<Character,Integer> mp: hs.entrySet()) {
            if(mp.getValue() == 1) {
                return s.indexOf(mp.getKey());
            }
        }
        
        return -1;
    }
}