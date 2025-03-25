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
    int[][] dp=new int[n+1][2];
   // for(int[] a:dp)
   // Arrays.fill(a,-1);
    //return findProfit(0,1,prices,dp); 
//dp[n][0]=0;
//dp[n][1]=0;
int[] ahead=new int[2];
int[] curr=new int[2];
for(int i=n-1;i>=0;i--){
for(int buy=0;buy<=1;buy++){
int profit=0;
if(buy==1){
//profit=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
profit=Math.max(-prices[i]+ahead[0],ahead[1]);
}
else {
//profit=Math.max(prices[i]+dp[i+1][1],dp[i+1][0]);
profit=Math.max(prices[i]+ahead[1],ahead[0]);
}
//dp[i][buy]=profit;
curr[buy]=profit;
}
ahead=curr;
}
//return dp[0][1];
return ahead[1];
    }
}