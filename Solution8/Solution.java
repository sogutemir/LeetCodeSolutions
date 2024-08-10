public class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        long result = 0;
        
        while (i < n && Character.isDigit(s.charAt(i))) {
            result = result * 10 + (s.charAt(i) - '0');
            
            if (result > Integer.MAX_VALUE) {
                break;
            }
            i++;
        }

        result *= sign;

        if (result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.myAtoi("42"));
        System.out.println(sol.myAtoi("   -042"));
        System.out.println(sol.myAtoi("1337c0d3"));
        System.out.println(sol.myAtoi("0-1"));
        System.out.println(sol.myAtoi("words and 987"));
    }
}
