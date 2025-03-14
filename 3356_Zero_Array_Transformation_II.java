class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int index = 0;
        int[] arr = new int[n + 2];
        int sum = 0, ans = 0;
        for (int[] que : queries) {
            while (sum + arr[index] >= nums[index]) {
                sum += arr[index];
                index++;
                if (index == n)
                    return ans;
            }
            ans++;
            int end = que[1];
            if (end < index)
                continue;
            int strt = Math.max(index, que[0]);
            int val = que[2];

            arr[strt] += val;
            arr[end + 1] -= val;

        }
        while (sum + arr[index] >= nums[index]) {
            sum += arr[index];
            index++;
            if (index == n)
                return ans;
        }

        return -1;

    }

}
