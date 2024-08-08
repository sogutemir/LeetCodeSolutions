class Solution {
    int idx;
    public int calculate(String s) {
            idx=0;
           return calc(s);
    }
    private int calc(String s) {
        int num = 0, res = 0;
        int sign = 1;
       while (idx< s.length()) {
            char c = s.charAt(idx++);
           if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
            } else if (c == '(') {
               num = calc(s);
            } else if (c == ')') {
                return res += num * sign;
           } else if (c == '+' || c == '-') {
                res += num * sign;
                num = 0;
                sign = (c == '-') ? -1 : 1;
            }
        }
        res += num * sign;
        return res;
   }
}