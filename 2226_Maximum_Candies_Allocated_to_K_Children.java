
class Solution {
    long ans = 0;

    public void binarySearch(int[] can, long low, long high, long k) {
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long sum = 0;
            for (int i : can) {

                sum += i / mid;
            }
            if (sum >= k) {
                ans = Math.max(ans, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

    }

    public int maximumCandies(int[] candies, long k) {
        long max = 0, sum = 0;
        for (int i : candies) {
            max = Math.max(max, i);
            sum += i;
        }
        if (k == 1)
            return (int) max;
        if (sum < k)
            return 0;

        binarySearch(candies, 1, max, k);
        return (int) ans;
    }
}
