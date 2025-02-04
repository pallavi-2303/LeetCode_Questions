class Solution {
    public int profitStock(int idx,int buy,int[] prices,int[][] dp){
    //base case buy can be anyhting if arr is fimisehd we cannot buy
        if(idx==prices.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
    //there are 2 caes buy and sell on particular day we can decide to buy or sell
    if(buy==1) {
    profit=Math.max(-prices[idx]+profitStock(idx+1,0,prices,dp),0+profitStock(idx+1,1,prices,dp));
    }
    else if(buy==0){
    profit=Math.max(prices[idx]+profitStock(idx+1,1,prices,dp),0+profitStock(idx+1,0,prices,dp));
    }
        return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
    int n=prices.length;
       // int[][] dp=new int[n+1][2];
       // for(int[] a:dp) Arrays.fill(a,-1);
       // return profitStock(0,1,prices,dp);
        int[] curr=new int[2];
        int[] prev=new int[2];
    //base case
    //dp[n][0]=0;
   // dp[n][1]=0;
  /*  prev[0]=0;
    prev[1]=0;
    for(int i=n-1;i>=0;i--){
for(int buy=0;buy<=1;buy++){
int profit=0;
   if(buy==1) {
//profit=Math.max(-prices[i]+dp[i+1][0],0+dp[i+1][1]);
       profit=Math.max(-prices[i]+prev[0],0+prev[1]);
   }
    else if(buy==0){
//profit=Math.max(prices[i]+dp[i+1][1],0+dp[i+1][0]);
        profit=Math.max(prices[i]+prev[1],0+prev[0]);
    }
   // dp[i][buy]=profit;
    curr[buy]=profit;
}
        prev=curr;
    }
    // return dp[0][1]  ; 
        return prev[1];*/
    int aheadbuy=0;
    int aheadnotbuy=0;
    int currnotbuy=0;
    int currbuy=0;
        for(int i=n-1;i>=0;i--){
currbuy=Math.max(-prices[i]+aheadnotbuy,0+aheadbuy);
//profit=Math.max(prices[i]+dp[i+1][1],0+dp[i+1][0]);
        currnotbuy=Math.max(prices[i]+aheadbuy,0+aheadnotbuy);
    
  aheadbuy=currbuy;
aheadnotbuy=currnotbuy;
}
       return aheadbuy; 
        
    }
}