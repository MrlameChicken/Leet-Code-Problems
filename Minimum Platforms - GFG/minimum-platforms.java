//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        ArrayList<trainTime> ttStart = new ArrayList<>();
        ArrayList<trainTime> ttEnd = new ArrayList<>();
        // add your code here
        for (int i=0;i<n;i++) {
            ttStart.add(new trainTime(arr[i]));
            ttEnd.add(new trainTime(dep[i]));
        }
        trainTimeComparator tc = new trainTimeComparator();
        ttStart.sort(tc);
        ttEnd.sort(tc);

        int answer = 1;
        int platforms = 1;
        int i=1;
        int j=0;

        while(i<n && j<n) {
            if(ttStart.get(i).time <= ttEnd.get(j).time) {
                platforms++;
                i++;
            }
            else {
                platforms--;
                j++;
            }

            answer = Math.max(answer, platforms);
        }
        return answer;

    }
}
class trainTime {
    int time;

    trainTime(int time) {
        this.time = time;
    }
}

class trainTimeComparator implements Comparator<trainTime> {
    @Override
    public int compare(trainTime o1, trainTime o2) {
        return Integer.compare(o1.time, o2.time);
    }
}
