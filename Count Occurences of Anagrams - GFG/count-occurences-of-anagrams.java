//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        // code here
        int i = 0;
        int j = 0;
        Map<String,Integer> map = new HashMap<>();
        String[] str = pat.split("");
        for (String s:str) {
           map.put(s,map.getOrDefault(s,0)+1); 
        }
        int k = pat.length();
        int count = map.size();
        int ans = 0;
        
        String[] text = txt.split("");
        while(j<txt.length()) {
            if (map.get(text[j]) != null) {
              map.put(text[j],map.get(text[j]) - 1);
              if (map.get(text[j]) == 0) {
                  count--;
              }
            }
            
            if (j - i + 1 > k) {
             if (map.get(text[i]) != null) {
                map.put(text[i],map.get(text[i]) + 1);
                    if (map.get(text[i]) == 1) {
                        count++;
                    }
                }
                i++;
            }
            if (j - i + 1 == k) {
                if(count == 0) {
                    ans++;
                }
            }
            j++;
        }
        return ans;
        
    }
}