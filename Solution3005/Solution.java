import java.util.HashMap;

public class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int maxFreq = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, map.get(num));
        }

        int res = 0;

        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                res += map.get(key);
            }
        }

        return res;
    }
}