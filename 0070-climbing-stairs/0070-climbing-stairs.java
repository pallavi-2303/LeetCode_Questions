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
       // Arrays.fill(dp,-1);
       dp[0]=1;
       dp[1]=1;
       for(int i=2;i<=n;i++){
    dp[i]=dp[i-1]+dp[i-2];
       }
        return dp[n];
    }
}