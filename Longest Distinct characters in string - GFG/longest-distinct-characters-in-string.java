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
        int i=0;
        int j = 0;
        int max = 0;
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        
        while(j<S.length()) {
            
            i = Math.max(i,lastIndex[S.charAt(j)]+1);
            
            max = Math.max(max,j-i+1);
            
            lastIndex[S.charAt(j)] = j;
            j++;
        }
        
        return max;
        
        
    }
}