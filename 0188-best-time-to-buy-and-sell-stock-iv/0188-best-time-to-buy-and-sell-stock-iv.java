class Solution {
    public int findMax(int idx,int buy,int cap,int[] arr,int[][][] dp){
        //base case
        if(cap==0 || idx==arr.length) return 0;
        if(dp[idx][buy][cap]!=-1) return dp[idx][buy][cap];
       int profit=0;
        if(buy==1){
            profit=Math.max(-arr[idx]+findMax(idx+1,0,cap,arr,dp),0+findMax(idx+1,1,cap,arr,dp));
        }
        else {
        profit=Math.max(arr[idx]+findMax(idx+1,1,cap-1,arr,dp),0+findMax(idx+1,0,cap,arr,dp));
        }
        return dp[idx][buy][cap]=profit;
    }
    public int maxProfit(int k, int[] prices) {
     int n=prices.length;
     int[][][] dp=new int[n+1][2][k+1] ;
    //  for(int i=0;i<=n;i++){
    //     for(int j=0;j<2;j++){
    //     for(int l=0;l<=k;l++){
    //         dp[i][j][l]=-1;}}}
    //    return findMax(0,1,k,prices,dp);
    //base case for every value of buy and index cap=0=0
    int[][] prev=new int[2][k+1];
    int[][] curr=new int[2][k+1];
   // for(int i=0;i<=n;i++){
        for(int buy=0;buy<=1;buy++){
           // dp[i][buy][0]=0;
           prev[buy][0]=0;
        }
   // }
    for(int buy=0;buy<=1;buy++){
        for(int cap=0;cap<=k;cap++){
           // dp[n][buy][cap]=0;
           prev[buy][cap]=0;
        }
    }
    for(int i=n-1;i>=0;i--){
        for(int buy=0;buy<=1;buy++){
            for(int cap=1;cap<=k;cap++){
            int profit=0;
            if(buy==1){
       //  profit=Math.max(-prices[i]+dp[i+1][0][cap],0+dp[i+1][1][cap]);  
        profit=Math.max(-prices[i]+prev[0][cap],0+prev[1][cap]);            
            }
            else {
            // profit=Math.max(prices[i]+dp[i+1][1][cap-1],0+dp[i+1][0][cap]);
             profit=Math.max(prices[i]+prev[1][cap-1],0+prev[0][cap]);
            }
           // dp[i][buy][cap]=profit;
           curr[buy][cap]=profit;
            }
        }
        prev=curr.clone();
    }
   // return  dp[0][1][k];
   return prev[1][k];
    }
}