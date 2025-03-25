class Solution {
    public int findProfit(int idx,int buy,int[] prices,int[][] dp){
    if(idx==prices.length) return 0;
    if(dp[idx][buy]!=-1) return dp[idx][buy];
int profit=0;
if(buy==1){
profit=Math.max(-prices[idx]+findProfit(idx+1,0,prices,dp),findProfit(idx+1,1,prices,dp));
}
else {
profit=Math.max(prices[idx]+findProfit(idx+1,1,prices,dp),findProfit(idx+1,0,prices,dp));
}
return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
    int n=prices.length;
    int[][] dp=new int[n][2];
    for(int[] a:dp)
    Arrays.fill(a,-1);
    return findProfit(0,1,prices,dp);  
    }
}