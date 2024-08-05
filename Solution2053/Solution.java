import java.util.*;

class Solution {
    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        
        for (String str : arr) {
            frequencyMap.put(str, frequencyMap.getOrDefault(str, 0) + 1);
        }
        
        List<String> distinctStrings = new ArrayList<>();
        for (String str : arr) {
            if (frequencyMap.get(str) == 1) {
                distinctStrings.add(str);
            }
        }
        
        if (k <= distinctStrings.size()) {
            return distinctStrings.get(k - 1);
        } else {
            return "";
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String[] arr1 = {"d", "b", "c", "b", "c", "a"};
        int k1 = 2;
        System.out.println(sol.kthDistinct(arr1, k1)); 
        
        String[] arr2 = {"aaa", "aa", "a"};
        int k2 = 1;
        System.out.println(sol.kthDistinct(arr2, k2)); 
        
        String[] arr3 = {"a", "b", "a"};
        int k3 = 3;
        System.out.println(sol.kthDistinct(arr3, k3)); 
    }
}
