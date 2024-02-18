class Solution {
    public char slowestKey(int[] releaseTimes, String keysPressed) {
        int keyTime = releaseTimes[0];
        char keyPressed = keysPressed.charAt(0);
        
        for (int i=1;i<releaseTimes.length;i++) {
            int diff = releaseTimes[i] - releaseTimes[i-1];
            if (diff > keyTime || (diff == keyTime && keyPressed < keysPressed.charAt(i))) {
                keyTime = diff;
                keyPressed = keysPressed.charAt(i);
            }
        }
        return keyPressed;
    }
}