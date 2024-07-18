import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        // Frekansları, ilk ve son görünüm indekslerini saklamak için üç HashMap oluşturuyoruz
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        Map<Integer, Integer> lastIndexMap = new HashMap<>();
        
        int degree = 0; // Dizinin derecesini tutmak için bir değişken
        
        // Adım 1: Frekansları ve ilk/son görünüm indekslerini belirlemek
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // Frekansı güncelle
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            
            // İlk görünüm indeksini kaydet, eğer zaten kayıtlı değilse
            if (!firstIndexMap.containsKey(num)) {
                firstIndexMap.put(num, i);
            }
            
            // Son görünüm indeksini her zaman güncelle
            lastIndexMap.put(num, i);
            
            // Dereceyi güncelle
            degree = Math.max(degree, countMap.get(num));
        }
        
        // Adım 2: Aynı dereceye sahip en küçük alt diziyi bulmak
        int minLength = nums.length;
        for (int num : countMap.keySet()) {
            // Eğer elemanın frekansı dereceli ise
            if (countMap.get(num) == degree) {
                // İlk ve son indeksleri al
                int firstIndex = firstIndexMap.get(num);
                int lastIndex = lastIndexMap.get(num);
                // Alt dizinin uzunluğunu hesapla
                int length = lastIndex - firstIndex + 1;
                // En küçük uzunluğu güncelle
                minLength = Math.min(minLength, length);
            }
        }
        
        return minLength; 
    }
}
