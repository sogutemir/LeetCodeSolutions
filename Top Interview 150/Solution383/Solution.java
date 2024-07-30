import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> magazineCounts = new HashMap<>();
        
        for (char c : magazine.toCharArray()) {
            magazineCounts.put(c, magazineCounts.getOrDefault(c, 0) + 1);
        }
        
        for (char c : ransomNote.toCharArray()) {
            if (!magazineCounts.containsKey(c) || magazineCounts.get(c) == 0) {
                return false; 
            }
            magazineCounts.put(c, magazineCounts.get(c) - 1);
        }
        
        return true; 
    }
}
