class Solution {

    public int minEatingSpeed(int[] piles, int h) {

        int low = 1, high = maxele(piles);

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long tothrs = TotalHours(piles, mid);

            if (tothrs <= h) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int maxele(int[] piles) {

        int max = 0;

        for (int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        return max;
    }

    public long TotalHours(int[] piles, int k) {

        long tothrs = 0;

        for (int i = 0; i < piles.length; i++) {

            tothrs += (piles[i] + k - 1) / k;

        }

        return tothrs;
    }
}