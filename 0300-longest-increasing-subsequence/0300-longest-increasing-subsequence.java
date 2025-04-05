class Solution {
    public int LIS(int idx,int prev,int[] nums,int[][] dp){
    //basecase
    if(idx==nums.length) return 0;
    if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];
    int nottake=LIS(idx+1,prev,nums,dp);
    int take=0;
    if(prev==-1 || nums[idx]>nums[prev]){
    take=1+LIS(idx+1,idx,nums,dp);
    }
    return dp[idx][prev+1]=Math.max(take,nottake);
    }
    public int lengthOfLIS(int[] nums) {
      int n=nums.length;
      int[][] dp=new int[n+1][n+1];
      for(int[] a:dp) {
    Arrays.fill(a,-1);
      }
      return LIS(0,-1,nums,dp);
    }
}