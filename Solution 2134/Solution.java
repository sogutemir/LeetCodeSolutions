class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        
        int totalOnes = 0;
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }
        
        if (totalOnes == 0) {
            return 0;
        }
        
        int maxOnesInWindow = 0;
        int currentOnesInWindow = 0;
        
        for (int i = 0; i < totalOnes; i++) {
            if (nums[i] == 1) {
                currentOnesInWindow++;
            }
        }
        
        maxOnesInWindow = currentOnesInWindow;
        
        for (int i = totalOnes; i < n + totalOnes; i++) {
            if (nums[i % n] == 1) {
                currentOnesInWindow++;
            }
            if (nums[(i - totalOnes) % n] == 1) {
                currentOnesInWindow--;
            }
            
            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnesInWindow);
        }
        
        return totalOnes - maxOnesInWindow;
    }
}
