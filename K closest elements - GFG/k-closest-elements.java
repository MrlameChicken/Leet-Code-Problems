//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

  public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        int[] array = new int[k];
        
        for(int a:arr) {
            if (a != x) {
                pq.offer(new Pair(Math.abs(a-x),a));
            }
            
            
            if(pq.size() > k) {
                pq.poll();
            }
        }
        
        int count = 0;
        while(!pq.isEmpty()) {
            array[k - count++ -1] = pq.poll().getData();
        }
        
        //Collections.sort(array);
        
        //Arrays.sort(array);
        
        return array;
    }
}

class Pair implements Comparable<Pair> {
	private int key;
	private int data;

	Pair(int key, int data) {
		this.key = key;
		this.data = data;
	}
	
	public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

	@Override
	public int compareTo(Pair o) {
	    if (this.key == o.getKey()) {
	        return Integer.compare(o.getData(),this.data);
	    }
		return Integer.compare(this.key,o.getKey());
	}

}