class Solution {
    public int minimumRecolors(String blocks, int k) {
        int strt = 0, n = blocks.length(), count = 0, min = Integer.MAX_VALUE;
        for (int end = 0; end < n; end++) {
            if (blocks.charAt(end) == 'W')
                count++;
            while (end - strt + 1 >= k) {

                min = Math.min(min, count);
                if (blocks.charAt(strt) == 'W')
                    count--;
                strt++;
            }
        }
        return min;
    }
}