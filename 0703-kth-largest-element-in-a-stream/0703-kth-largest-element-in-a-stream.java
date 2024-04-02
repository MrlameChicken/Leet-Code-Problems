class KthLargest {
    
    private int k;
    
    private final PriorityQueue<Integer> nums = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int n:nums) {
            add(n);
        }
        
    }
    
    public int add(int val) {
        
        if (nums.size() < k) {
            nums.add(val);
        } else if (val > nums.peek()) {
            nums.poll();
            nums.add(val);
        }
        
        return nums.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */