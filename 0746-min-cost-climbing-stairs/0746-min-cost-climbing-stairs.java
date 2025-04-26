class Solution {
    // public int find(int idx,int[] cost,int[] dp){
    //  int n=cost.length;
    //  if(idx>=n) return 0;
    //  if(dp[idx]!=-1) return dp[idx];
    // int step1=cost[idx]+find(idx+1,cost,dp);
    //  int step2=cost[idx]+find(idx+2,cost,dp);
    //  return dp[idx]=Math.min(step1,step2);
    // }
    public int find(int i,int[] cost,int[] dp){
    
     int n=cost.length;
     dp[n]=0;
    for(int idx=n-1;idx>=i;idx--){
    int step1=cost[idx];
    if(idx+1<=n) step1+=dp[idx+1];
    int step2=cost[idx];
    if(idx+2<=n) step2+=dp[idx+2];
    dp[idx]=Math.min(step1,step2);
    }
    return dp[i];
    }
    public int minCostClimbingStairs(int[] cost) {
    int n=cost.length;
    int[] dp=new int[n+1];
    //Arrays.fill(dp,-1);
    int ans1=find(0,cost,dp);
    int ans2=find(1,cost,dp);
    return Math.min(ans1,ans2); 
    }
}