class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int left = 0; //buy
        int right = 1; //sell
        while (right< prices.length) {
            if (prices[left] > prices[right]) {
                left = right;
                right++;
            }
            else {
                maxProfit = Math.max(prices[right] - prices[left], maxProfit);
                right++;
            }
        }

        return maxProfit;
    }
}