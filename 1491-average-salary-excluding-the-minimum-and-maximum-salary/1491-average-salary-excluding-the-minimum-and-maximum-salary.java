class Solution {
    public double average(int[] salary) {
        int total = 0;
        double sum = 0;
        int max = salary[0];
        int min = salary[0];
        for (int i = 0; i< salary.length; i++) {
            if (min > salary[i]) {
                min = salary[i];
            }
            if (max < salary[i]) {
                max = salary[i];
            }
        }
        
        for (int i = 0;i<salary.length;i++) {
            if (salary[i] != max && salary[i] != min) {
                sum += salary[i];
                total++;
            }
        }
        
        return sum/total;
        
    }
}