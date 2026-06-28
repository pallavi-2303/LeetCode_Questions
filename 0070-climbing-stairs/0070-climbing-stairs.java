class Solution {
    int[] dp;
    public int solve(int n){
   if(n<=1) return 1;
   if(dp[n]!=-1) return dp[n];
   int op1=solve(n-1);
   int op2=solve(n-2);
   return dp[n]= op1+op2;
    }
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }
}