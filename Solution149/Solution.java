import java.util.*;

public class Solution {
    public int maxPoints(int[][] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        
        int maxPoints = 1;
        
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 0;
            int curMax = 0;
            
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];
                
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }
                
                int gcd = gcd(dx, dy);
                dx /= gcd;
                dy /= gcd;
                
                String slope = dy + "/" + dx;
                slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                curMax = Math.max(curMax, slopeMap.get(slope));
            }
            
            maxPoints = Math.max(maxPoints, curMax + duplicate + 1);
        }
        
        return maxPoints;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(sol.maxPoints(points1));
        
        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println(sol.maxPoints(points2));
    }
}
