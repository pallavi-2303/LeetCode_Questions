class Solution {
    public int findProfit(int idx,int[] arr,int buy,int[][] dp){
        if(idx==arr.length) return 0;
        if(dp[idx][buy]!=-1) return dp[idx][buy];
        int profit=0;
    if(buy==1){
    profit=Math.max(-arr[idx]+findProfit(idx+1,arr,0,dp),0+findProfit(idx+1,arr,1,dp));
    }
    else {
    profit=Math.max(arr[idx]+findProfit(idx+1,arr,1,dp),0+findProfit(idx+1,arr,0,dp));
    }
    return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices) {
     int n=prices.length;
     int[][] dp=new int[n+1][2];
     for(int[] a:dp) Arrays.fill(a,-1);
     return findProfit(0,prices,1,dp);
    }
}