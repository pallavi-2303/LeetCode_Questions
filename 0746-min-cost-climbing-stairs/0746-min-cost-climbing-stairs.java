class Solution {
    public int find(int idx,int[] cost,int[] dp){
     int n=cost.length;
     if(idx>=n) return 0;
     if(dp[idx]!=-1) return dp[idx];
    int step1=cost[idx]+find(idx+1,cost,dp);
     int step2=cost[idx]+find(idx+2,cost,dp);
     return dp[idx]=Math.min(step1,step2);
    }
    public int minCostClimbingStairs(int[] cost) {
    int n=cost.length;
    int[] dp=new int[n];
    Arrays.fill(dp,-1);
    int ans1=find(0,cost,dp);
    int ans2=find(1,cost,dp);
    return Math.min(ans1,ans2); 
    }
}