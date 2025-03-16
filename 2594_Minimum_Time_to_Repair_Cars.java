class Solution {
    public boolean possible(long time, int[] ranks, int cars) {
        long count = 0;

        for (int i : ranks) {
            count += (long) Math.sqrt((time / i));
            if (count >= cars)
                return true;
        }
        return false;
    }

    public long repairCars(int[] ranks, int cars) {
        long ans = Integer.MAX_VALUE;

        long min = 0, max = 100L * cars * cars;

        while (min <= max) {

            long mid = min + (max - min) / 2;
            if (possible(mid, ranks, cars)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;

    }
}