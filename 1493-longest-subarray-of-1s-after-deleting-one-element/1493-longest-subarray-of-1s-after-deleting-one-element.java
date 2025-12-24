class Solution {
    public int longestSubarray(int[] nums) {
     //longest subaray with max 1 zero 
     int n=nums.length;
     int maxLen=0;
     for(int i=0;i<n;i++) {
    int zero=0;
    for(int j=i;j<n;j++){
    if(nums[j]==0) zero++;
    if(zero>1) break;
    maxLen=Math.max(maxLen,j-i+1);
    }
     } 
     return maxLen-1;//-1 for deletion of one zero 
    }
}