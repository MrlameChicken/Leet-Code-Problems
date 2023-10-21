class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0;
        int j = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int count=0,max = 0;
        
        while(j<fruits.length) {
           
            if(count==2 && map.get(fruits[j]) == null){
                
                while(i<j && count>=2) {
                    map.put(fruits[i],map.get(fruits[i])-1);
                    if (map.get(fruits[i]) == 0) {
                        map.remove(fruits[i]);
                        count--;
                    }
                    i++;
                }
            } else {
                map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
                if (map.get(fruits[j]) == 1) {
                    count++;
                }
                max = Math.max(max,j-i+1);
                j++;
            }
            
        }
        
        return max;
    }
}