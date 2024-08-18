class Solution {
    public int maxDepth(String s) {
        int currentDepth = 0;
        int maxDepth = 0;
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                currentDepth++;
                if (currentDepth > maxDepth) {
                    maxDepth = currentDepth;
                }
            } else if (c == ')') {
                currentDepth--;
            }
        }
        
        return maxDepth;
    }
}
