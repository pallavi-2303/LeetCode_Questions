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
    int[][] dp=new int[n+1][2];
    // for(int[] a:dp)  Arrays.fill(a,-1);
    // return findProfit(0,prices,1,dp,fee);
for(int i=n-1;i>=0;i--){
for(int buy=0;buy<=1;buy++){
int profit=0;
if(buy==1){
profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
}
else {
profit=Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
}
dp[i][buy]=profit;
}

}
return dp[0][1];
    }
}