class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length, ans = 0;
        for (int end = 0; end < n - 2; end++) {
            if (nums[end] == 0) {
                ans++;
                nums[end + 1] ^= 1;
                nums[end + 2] ^= 1;
            }
        }
        return (nums[n - 1] == 1 && nums[n - 2] == 1) ? ans : -1;

    }
}