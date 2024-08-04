class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
       
        int MOD = 1000000007;

        List<Integer> subarraySums = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += nums[j];
                subarraySums.add(currentSum);
            }
        }
        
        Collections.sort(subarraySums);
        
        long result = 0;

        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % MOD;
        }
        
        return (int) result;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(sol.rangeSum(nums1, 4, 1, 5)); 
        
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(sol.rangeSum(nums2, 4, 3, 4));
        
        int[] nums3 = {1, 2, 3, 4};
        System.out.println(sol.rangeSum(nums3, 4, 1, 10));
    }
}
