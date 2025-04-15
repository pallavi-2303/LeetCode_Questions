class Solution {
    public int coinChange2(int idx,int target,int[] nums,int[][] dp){
if(target==0) return 0;
if(idx==0){
if(target%nums[0]==0){
return target/nums[0];}
else return (int)1e9;}
if(dp[idx][target]!=-1)
return dp[idx][target];
int take=(int) 1e9;
if(nums[idx]<=target)
take=1+coinChange2(idx,target-nums[idx],nums,dp);
int nottake=0+coinChange2(idx-1,target,nums,dp);
return dp[idx][target]=Math.min(take,nottake);}
    public int coinChange(int[] coins, int target) {
       int n=coins.length;
int[][] dp=new int[n][target+1];
for(int[] a:dp){
Arrays.fill(a,-1);}
 int ans=coinChange2(n-1,target,coins,dp);
return ans==(int)1e9 ? -1 : ans;
    }
}