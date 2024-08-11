public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        int start = nums[0];
        int end = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == end + 1) {
                end = nums[i];
            } else {
                if (start == end) {
                    result.add(String.valueOf(start));
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            }
        }

        if (start == end) {
            result.add(String.valueOf(start));
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(sol.summaryRanges(nums1));

        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(sol.summaryRanges(nums2));
    }
}
