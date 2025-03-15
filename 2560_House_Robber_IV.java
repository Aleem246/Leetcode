class Solution {
    public boolean possible(int[] nums, int mid, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                count++;
                i++;
            }

        }
        return count >= k;

    }

    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = 0;
        int ans = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (possible(nums, mid, k)) {
                ans = Math.min(ans, mid);
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return ans;
    }
}