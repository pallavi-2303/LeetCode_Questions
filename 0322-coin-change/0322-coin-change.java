class Solution {
    public int memo(int idx,int[] nums,
int[][] dp,int target) {
if(target==0) return 0;
if(idx<0 && target>0) return (int)1e9;
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
    public int coinChange(int[] coins, int amount) {
       int n=coins.length;
       int[][] dp=new int[n][amount+1];
       for(int[] a:dp) Arrays.fill(a,-1);
int ans= memo(n-1,coins,dp,amount);
return ans==(int)1e9 ? -1 :ans;

    }
}