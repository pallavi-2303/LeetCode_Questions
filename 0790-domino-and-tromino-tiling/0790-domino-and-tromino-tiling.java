class Solution {
    public int numTilings(int n) {
    int[] dp=new int[n+1];
    int mod=(int)1e9+7;
    if(n==1 || n==2) return n;
    dp[1]=1;
    dp[2]=2;
    dp[3]=5;
    for(int i=4;i<=n;i++){
    dp[i]=(2*dp[i-1]%mod+dp[i-3]%mod)%mod;
    }
     return dp[n];
    }
}