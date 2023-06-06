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

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        ArrayList<trainTime> ttStart = new ArrayList<>();
        ArrayList<trainTime> ttEnd = new ArrayList<>();
        // add your code here
        for (int i=0;i<n;i++) {
            ttStart.add(new trainTime(arr[i],dep[i]));
            ttEnd.add(new trainTime(arr[i],dep[i]));
        }
        trainStartTimeComparator tStart = new trainStartTimeComparator();
        trainEndTimeComparator tEnd = new trainEndTimeComparator();
        Collections.sort(ttStart,tStart);
        Collections.sort(ttEnd,tEnd);

        int answer = 1;
        int platforms = 1;
        int i=1;
        int j=0;
        
        while(i<n && j<n) {
            if(ttStart.get(i).arrival <= ttEnd.get(j).departure) {
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
        int arrival;
        int departure;
        
        trainTime(int arrival, int departure) {
            this.arrival = arrival;
            this.departure = departure;
        }
    }
    
    class trainEndTimeComparator implements Comparator<trainTime> {
        @Override
        public int compare(trainTime o1, trainTime o2) {
            return Integer.compare(o1.departure, o2.departure);
        }
    }
    class trainStartTimeComparator implements Comparator<trainTime> {
        @Override
        public int compare(trainTime o1, trainTime o2) {
            return Integer.compare(o1.arrival, o2.arrival);
        }
    }
