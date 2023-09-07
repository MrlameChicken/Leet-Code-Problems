class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet hs = new HashSet<Integer>();
        int length = 0;
        int currentLength = 0;
        int currentNum = 0;
        for (int num: nums) {
            hs.add(num);
        }
        for (int num: nums) {
            if(!hs.contains(num - 1)) {
                currentNum = num;
                currentLength = 1;
                while (hs.contains(currentNum + 1)) {
                    currentLength = currentLength + 1;
                    currentNum = currentNum + 1;
                }
            }
            length = Math.max(currentLength,length);
        }
        return length;
    }
}