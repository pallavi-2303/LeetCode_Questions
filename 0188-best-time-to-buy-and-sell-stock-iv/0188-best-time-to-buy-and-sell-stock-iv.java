class Solution {
    public int maxProfit(int k, int[] prices) {
    int n=prices.length;
    //int[][][] dp=new int[n+1][2][k+1];
     int[][] curr=new int[2][k+1];
      int[][] ahead=new int[2][k+1];
    for(int i=n-1;i>=0;i--){
    for(int buy=0;buy<=1;buy++){
    for(int cap=1;cap<=k;cap++){
    int profit=0;
    if(buy==1){
    // profit=Math.max(-prices[i]+dp[i+1][0][cap],dp[i+1][1][cap]);
    profit=Math.max(-prices[i]+ahead[0][cap],ahead[1][cap]);
    }

    else {
    profit=Math.max(prices[i]+ahead[1][cap-1],ahead[0][cap]);
    }
   // dp[i][buy][cap]=profit;
   curr[buy][cap]=profit;
    }
    }
ahead=curr;
    } 
    return ahead[1][k];  
    }
}