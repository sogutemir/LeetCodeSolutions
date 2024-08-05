public class Solution {
    public String reverseWords(String s) {

        s = s.trim();
        
        String[] words = s.split("\\s+");
        
        int left = 0, right = words.length - 1;
        while (left < right) {
            String temp = words[left];
            words[left] = words[right];
            words[right] = temp;
            left++;
            right--;
        }
        
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.reverseWords("the sky is blue"));
        System.out.println(sol.reverseWords("  hello world  "));
        System.out.println(sol.reverseWords("a good   example"));
    }
}
