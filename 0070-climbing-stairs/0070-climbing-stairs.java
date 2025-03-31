class Solution {
    public int climb(int n,int[] dp) {
if(n<=1) return 1;
if(dp[n]!=-1) return dp[n];
return dp[n]=climb(n-1,dp)+climb(n-2,dp);
}
    public int climbStairs(int n) {
 int[] dp=new int[n+1];
Arrays.fill(dp,-1);
return climb(n,dp);
/*int prev=1;
int prev2=1;*/
/*dp[0]=1;
dp[1]=1;
int curr=0;
for(int i=2;i<=n;i++){
/*curr=prev+prev2;
prev2=prev;
prev=curr;
dp[i]=dp[i-1]+dp[i-2];
}
return dp[n];*/
// return prev;   
    }
}