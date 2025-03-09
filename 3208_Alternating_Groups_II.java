class Solution {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int n = colors.length, end = 1, strt = 0, count = 0;

        while (true) {
            if (colors[(end - 1) % n] != colors[end % n]) {
                if (end - strt + 1 == k) {
                    count++;
                    strt++;
                    if (strt == n)
                        return count;
                }
                end++;
            } else {
                if (strt > (end % n))
                    return count;
                strt = end;
                end++;
            }
        }

        // return 0;
    }
}