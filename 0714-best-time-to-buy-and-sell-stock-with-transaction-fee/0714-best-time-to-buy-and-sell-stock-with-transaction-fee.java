class Solution {
    public int findMax(int idx,int buy,int[] arr,int fee,int[][] dp){
    if(idx==arr.length) return 0;
    if(dp[idx][buy]!=-1) return dp[idx][buy];
    int profit=0;
    if(buy==1){
        profit=Math.max(-arr[idx]+findMax(idx+1,0,arr,fee,dp),findMax(idx+1,1,arr,fee,dp));
    }
    else {
         profit=Math.max(arr[idx]-fee+findMax(idx+1,1,arr,fee,dp),findMax(idx+1,0,arr,fee,dp));
    }
    return dp[idx][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
     int n=prices.length;
     int[][] dp=new int[n+1][2];
     for(int[] a:dp) Arrays.fill(a,-1) ;
     return findMax(0,1,prices,fee,dp);
    }
}