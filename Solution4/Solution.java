class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] arr = new double[nums1.length + nums2.length];
        int j = 0;
        for (int i : nums1) arr[j++] = i;
        for (int i : nums2) arr[j++] = i;

        Arrays.sort(arr);

        if (arr.length % 2 == 0) {
            return (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else return arr[arr.length / 2];
    }
}