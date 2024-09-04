class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        Set<String> obstacleSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "," + obstacle[1]);
        }
        
        int x = 0, y = 0;
        int directionIndex = 0;
        int maxDistance = 0;
        
        for (int command : commands) {
            if (command == -2) {

                directionIndex = (directionIndex + 3) % 4;

            } else if (command == -1) {

                directionIndex = (directionIndex + 1) % 4;

            } else {

                int dx = directions[directionIndex][0];
                int dy = directions[directionIndex][1];
                
                for (int i = 0; i < command; i++) {
                    int newX = x + dx;
                    int newY = y + dy;
                    
                    if (obstacleSet.contains(newX + "," + newY)) {
                        break;
                    }
                    
                    x = newX;
                    y = newY;
                    
                    maxDistance = Math.max(maxDistance, x * x + y * y);
                }
            }
        }
        
        return maxDistance;
    }
}