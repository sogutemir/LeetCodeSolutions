public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        
        return left << shift;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.rangeBitwiseAnd(5, 7));
        System.out.println(sol.rangeBitwiseAnd(0, 0));
        System.out.println(sol.rangeBitwiseAnd(1, 2147483647));
    }
}
