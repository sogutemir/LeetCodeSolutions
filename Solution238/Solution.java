class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
        int[] left_products = new int[n];
        left_products[0] = 1;
        for (int i = 1; i < n; i++) {
            left_products[i] = left_products[i - 1] * nums[i - 1];
        }
        
        int right_product = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = left_products[i] * right_product;
            right_product *= nums[i];
        }
        
        return result;
    }
}
