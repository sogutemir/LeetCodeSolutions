class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
       
        int n = nums.length;
        long count = 0;
        int minPosition = -1, maxPosition = -1, leftBound = -1;

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            
            if (num < minK || num > maxK) {
                leftBound = i;
            }
            
            if (num == minK) minPosition = i;
            if (num == maxK) maxPosition = i;
            
            if (minPosition != -1 && maxPosition != -1) {
                count += Math.max(0, Math.min(minPosition, maxPosition) - leftBound);
            }
        }
        
        return count;
    }

}
