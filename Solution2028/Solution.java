class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalSum = mean * (n + m);
        int currentSum = 0;
        
        for (int roll : rolls) {
            currentSum += roll;
        }
        
        int missingSum = totalSum - currentSum;
        
        if (missingSum < n * 1 || missingSum > n * 6) {
            return new int[0];
        }
        
        int[] result = new int[n];
        Arrays.fill(result, 1);
        missingSum -= n;
        
        for (int i = 0; i < n && missingSum > 0; i++) {
            int add = Math.min(5, missingSum);
            result[i] += add;
            missingSum -= add;
        }
        
        return result;
    }
    
}
