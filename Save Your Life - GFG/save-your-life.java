//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
    static String maxSum(String w,char x[],int b[], int n){
        //code here
        
        int sum = 0,max = Integer.MIN_VALUE;
        int start = 0, end = 0,i=0;
        int j = 0;
        while(j<w.length()) {
            sum += getAscii(w.charAt(j),x,b);
            
            if (sum > max) {
                max = sum;
                start = i;
                end = j;
            }
            
            if (sum < 0) {
                sum = 0;
                i = j+1;
            }
            j++;
        }
        
        return w.substring(start,end+1);
        
        
    }
    
    static int getAscii(char c,char x[],int b[]) {
        
        int i = 0;
        for ( ;i<x.length;) {
            if (x[i] == c) {
                break;
            }
            i++;
        }
        
        if (i == x.length) {
            return (int) c;
        } else {
            return b[i]; 
        }

       
    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends