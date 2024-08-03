class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        
        int insertPos = 2; // Start third position
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[insertPos - 2]) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }
        
        return insertPos;
    }
}
