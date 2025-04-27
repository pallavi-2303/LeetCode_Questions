class Solution {
    public int findProfit(int idx,int[] prices,int buy,int[][] dp,int fee){
    if(idx==prices.length) return 0;
    if(dp[idx][buy]!=-1) return dp[idx][buy];
    int profit=0;
    //we have two options we can buy or not buy
    if(buy==1){
    profit=Math.max(-prices[idx]+findProfit(idx+1,prices,0,dp,fee),findProfit(idx+1,prices,1,dp,fee));
    }
    else {
    profit=Math.max(prices[idx]-fee+findProfit(idx+1,prices,1,dp,fee),findProfit(idx+1,prices,0,dp,fee));
    }
    return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
    //since we have to find out the transaction 
    int n=prices.length;
    int[][] dp=new int[n][2];
    for(int[] a:dp)  Arrays.fill(a,-1);
    return findProfit(0,prices,1,dp,fee);
    }
}