class Solution {
    public int find(int n,int[] dp){
    if(n==0) return 0;
    if(n==1 || n==2) return 1;
    if(dp[n]!=-1) return  dp[n];
    return dp[n]=find(n-1,dp)+find(n-2,dp)+find(n-3,dp);
    }
    public int tribonacci(int n) {
    int[] dp=new int[n+1];
    // Arrays.fill(dp,-1);
    // return find(n,dp);
    if(n==0) return 0;
    if(n==1 || n==2) return 1;
    dp[0]=0;
    dp[1]=1;
    dp[2]=1;
    for(int i=3;i<=n;i++) {
    dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
    } 
    return dp[n]; 
    }
}