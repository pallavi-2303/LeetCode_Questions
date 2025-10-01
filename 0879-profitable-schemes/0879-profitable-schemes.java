class Solution {
int N;
int mod=(int)1e9+7;
int[][][] dp;
public int solve(int idx,int currProfit,int currSize,int n, int minProfit, int[] group, int[] profit){
if(currSize>n){
//we canot take this path
return 0;
}
if(idx>=N){
return currProfit>=minProfit ? 1 :0; 
}
if(dp[idx][currProfit][currSize]!=-1) return dp[idx][currProfit][currSize];
int notTake=solve(idx+1,currProfit,currSize,n,minProfit,group,profit);
int take=solve(idx+1,Math.min(currProfit+profit[idx],minProfit),currSize+group[idx],n,minProfit,group,profit);
return dp[idx][currProfit][currSize]= (take+notTake)%mod;
}
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
  N=profit.length;
  dp=new int[N+1][minProfit+1][n+1];
  for(int[][] a:dp){
for(int[] b:a){
Arrays.fill(b,-1);
}
  }
  return solve(0,0,0,n,minProfit,group,profit);     
    }
}