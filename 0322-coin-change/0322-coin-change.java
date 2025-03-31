class Solution {
    public int memo(int idx,int[] nums,
int[][] dp,int target) {
if(target==0) return 0;
if(idx==0) {
if(target%nums[0]==0) {
return target/nums[0];
}
else {
return (int)1e9;
}
}
if(dp[idx][target]!=-1) return dp[idx][target];
int take=(int)1e9;
if(nums[idx]<=target) 
take=1+memo(idx,nums,dp,
target-nums[idx]);
int nottake=0+memo(idx-1,nums,dp,
target);
return dp[idx][target]=
Math.min(take,nottake);
}
public int tabulation(int[] nums,int target){
int n=nums.length;
int[][] dp=new int[n][target+1];
for(int tar=0;tar<=target;tar++){
if(tar%nums[0]==0){
dp[0][tar]=tar/nums[0];
}
else {
dp[0][tar]=(int)1e9;
}
}
for(int i=0;i<n;i++){
dp[i][0]=0;
}
for(int i=1;i<n;i++){
for(int tar=0;tar<=target;tar++){
int take=(int)1e9;
if(nums[i]<=tar){
take=1+dp[i][tar-nums[i]];
}
int nottake=0+dp[i-1][tar];
dp[i][tar]=Math.min(take,nottake);
}
}
return dp[n-1][target];
}
    public int coinChange(int[] coins, int amount) {
       int n=coins.length;
       int[][] dp=new int[n][amount+1];
       for(int[] a:dp) Arrays.fill(a,-1);
//int ans= memo(n-1,coins,dp,amount);
int ans=tabulation(coins,amount);
return ans==(int)1e9 ? -1 :ans;

    }
}