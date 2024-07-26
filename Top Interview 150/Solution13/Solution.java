class Solution {
    public int romanToInt(String s) {

        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int total = 0;
        int prevValue = 0;
        
        // Iterate through the string from left to right
        for (int i = 0; i < s.length(); i++) {
            int currValue = romanMap.get(s.charAt(i));
            
            if (currValue > prevValue) {
                total += currValue - 2 * prevValue;
            } else {
                total += currValue;
            }
            
            prevValue = currValue;
        }
        
        return total;
    }
}
