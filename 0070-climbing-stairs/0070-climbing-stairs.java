class Solution {
    public int memo(int n,int[] dp){
if(n==0 || n==1){
return 1;}
if(dp[n]!=-1) return dp[n];
return dp[n]=memo(n-1,dp)+memo(n-2,dp);}
    public int climbStairs(int n) {
      int[] dp=new int[n+1];
//Arrays.fill(dp,-1);
//return memo(n,dp);
// dp[0]=1;
// dp[1]=1;
int prev2=1;
int prev=1;
for(int i=2;i<=n;i++){
//dp[i]=dp[i-1]+dp[i-2];}
curr=prev+prev2;
prev2=prev;
prev=curr;}
//return dp[n]; 
return prev; 
    }
}