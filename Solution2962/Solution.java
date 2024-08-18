class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();
        int maxi = Arrays.stream(nums).max().getAsInt();
        int i = 0, j = 0;
        long ans = 0;
        while (j < n) {
            freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            while (freq.getOrDefault(maxi, 0) >= k) {
                ans += n - j;
                freq.put(nums[i], freq.get(nums[i]) - 1);
                i++;
            }
            j++;
        }
        return ans;
    }
}