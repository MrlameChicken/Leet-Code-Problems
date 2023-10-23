//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        Set<Character> s = new HashSet<>();
        int i = 0;
        int j = 0;
        int max = 0;
        
        while(j<S.length()) {
            
            if (s.contains(S.charAt(j))) {
                while(S.charAt(i) != S.charAt(j)) {
                    s.remove(S.charAt(i));
                    i++;
                }
                i++;
                
            } else {
                s.add(S.charAt(j));
                max = Math.max(max,j-i+1);
            }
            
            j++;
            
            
        }
        
        return max;
        
    }
}