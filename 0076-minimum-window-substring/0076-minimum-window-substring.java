class Solution {
    public String minWindow(String s, String t) {
        int i = 0;
        int j = 0;
        Map<Character,Integer> map = new HashMap<>();
        String ans = "";
        int min = Integer.MAX_VALUE;
        
        
        for(char c:t.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        int count = map.size();
        
        while(j<s.length()) {
            if (map.get(s.charAt(j))!=null) {
                map.put(s.charAt(j),map.get(s.charAt(j))-1);
                if (map.get(s.charAt(j)) == 0) {
                    count--;
                }
            }
            
           
            
            if (count == 0) {
                 while (!map.containsKey(s.charAt(i)) || map.get(s.charAt(i)) < 0) {
                    if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i),map.get(s.charAt(i))+1);
                    }  
                    
                     i++;  
                }
                
                if (min>j-i+1) {
                    ans = s.substring(i,j+1);
                    min = j-i+1;
                }
                
            }
            j++;
        }
        return ans;
        
    }
}