class Solution {
    public int longestNiceSubarray(int[] nums) {
        int strt =0, n = nums.length, ans=1,max=1;
        int sum=nums[0];
        for(int end = 1 ; end < n ; end++){
            
        
            while(sum&nums[end])!=0){
                sum^=nums[strt];
                strt++;
                ans-=1;
            }
                sum|=nums[end];
                ans++;
            
            max = Math.max(max, ans);
        }
            return max;
    }
}
