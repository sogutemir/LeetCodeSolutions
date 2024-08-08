import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int concatLength = wordLength * totalWords;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - concatLength; i++) {
            String substring = s.substring(i, i + concatLength);
            if (isValid(substring, wordCount, wordLength)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isValid(String substring, Map<String, Integer> wordCount, int wordLength) {
        Map<String, Integer> seen = new HashMap<>();
        for (int j = 0; j < substring.length(); j += wordLength) {
            String word = substring.substring(j, j + wordLength);
            seen.put(word, seen.getOrDefault(word, 0) + 1);
        }
        return seen.equals(wordCount);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));

        System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"}));

        System.out.println(sol.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));

    }
}
