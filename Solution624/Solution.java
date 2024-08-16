class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
     
        int minSoFar = arrays.get(0).get(0);
        int maxSoFar = arrays.get(0).get(arrays.get(0).size() - 1);
        int maxDistance = 0;

        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> currentArray = arrays.get(i);
            int currentMin = currentArray.get(0);
            int currentMax = currentArray.get(currentArray.size() - 1);

            maxDistance = Math.max(maxDistance, Math.abs(currentMax - minSoFar));
            maxDistance = Math.max(maxDistance, Math.abs(maxSoFar - currentMin));

            minSoFar = Math.min(minSoFar, currentMin);
            maxSoFar = Math.max(maxSoFar, currentMax);
        }

        return maxDistance;
    }
}
