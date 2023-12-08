class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }
        
        String maxAns = s.substring(0,1);
        
        
        for(int i=0;i<s.length();i++) {
            String odd = expandFromCenter(s,i,i);
            String even = expandFromCenter(s,i,i+1);
            
            maxAns = odd.length()>maxAns.length()?odd:maxAns;
            maxAns = even.length()>maxAns.length()?even:maxAns;
        }
        
        return maxAns;
    }
    
    private static String expandFromCenter(String s,int left,int right) {
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            
            left --;
            right ++;
        }
        return s.substring(left+1,right);
    }
}