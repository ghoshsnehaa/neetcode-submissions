class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int low = 0, high = 0;

        // Find minimum and maximum capacity
        for (int i = 0; i < weights.length; i++) {
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        // Binary Search
        while (low <= high) {

            int mid = low + (high - low) / 2;

            int requiredDays = findDays(weights, mid);

            if (requiredDays <= days) {
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    // Calculate required days for a given capacity
    public int findDays(int[] weights, int capacity) {

        int days = 1;
        int load = 0;

        for (int i = 0; i < weights.length; i++) {

            if (load + weights[i] > capacity) {
                days++;
                load = weights[i];
            } 
            else {
                load += weights[i];
            }
        }

        return days;
    }
}