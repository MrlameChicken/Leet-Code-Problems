class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0,totalCost = 0;
        int result = 0;
        int currentTotalCost = 0;
        
        for(int i = 0;i<gas.length;i++) {
                totalGas += gas[i];
                totalCost += cost[i];
            } 
        if (totalGas < totalCost) {
            return -1;
        }
        
        for(int j = 0;j<gas.length;j++) {
                currentTotalCost += gas[j] - cost[j];
                if (currentTotalCost < 0) {
                    currentTotalCost = 0;
                    result = j + 1;
                }
        }
        
        return result;
    }
}