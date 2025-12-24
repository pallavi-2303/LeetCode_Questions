class Solution {
    public int longestSubarray(int[] nums) {
     int n=nums.length;
     int maxLen=0;
     int l=0;
     int r=0;
     int zero=0;
     while(r<n) {
    if(nums[r]==0) zero++;
    while(zero>1){
    if(nums[l]==0) zero--;
    l++;
    }
    maxLen=Math.max(maxLen,r-l+1);
    r++;
     } 
     return maxLen-1; 
    }
}