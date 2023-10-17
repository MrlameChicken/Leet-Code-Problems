class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return new int[0];

        int[] result = new int[n - k + 1];
        int resultIndex = 0;
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements outside the current sliding window
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            // Remove elements smaller than the current element
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }

            // Add the current element to the deque
            deque.offer(i);

            // Add the maximum element to the result for this window
            if (i >= k - 1) {
                result[resultIndex++] = nums[deque.peek()];
            }
        }

        return result;
    }
}
