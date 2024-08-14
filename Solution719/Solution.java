public class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int left = 0;
        int right = nums[nums.length - 1] - nums[0];
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (countPairs(nums, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private int countPairs(int[] nums, int mid) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i;
            while (j < nums.length && nums[j] - nums[i] <= mid) {
                j++;
            }
            count += j - i - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {1, 3, 1};
        int k1 = 1;
        System.out.println(sol.smallestDistancePair(nums1, k1));

        int[] nums2 = {1, 1, 1};
        int k2 = 2;
        System.out.println(sol.smallestDistancePair(nums2, k2));

        int[] nums3 = {1, 6, 1};
        int k3 = 3;
        System.out.println(sol.smallestDistancePair(nums3, k3));
    }
}
