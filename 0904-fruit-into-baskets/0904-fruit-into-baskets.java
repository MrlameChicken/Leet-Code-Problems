class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int count,max = 0;
        
        while(j<fruits.length) {
           
            if(map.size()==2 && !map.containsKey(fruits[j]))
            {
                while(i<j && !(map.size()<2)) {
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if (map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                    }
                    i++;
                }
            } else {
                map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
                max = Math.max(max,j-i+1);
                j++;
            }
            
        }
        
        return max;
    }
}