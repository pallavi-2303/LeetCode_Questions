class Solution {
    int n;
    public int findProfit(int idx,int[] prices,int buy,int k,int[][][] dp){
    //base case if number of transction is finded means buy and cell is finished one trasaction completed
    if(k==0 ||idx>=n) return 0;
    if(dp[idx][k][buy]!=-1){
    return dp[idx][k][buy];
    }
    int profit=0;
    if(buy==1){
        //we have two options wheather we can buy or not buy
    profit=Math.max(-prices[idx]+findProfit(idx+1,prices,0,k,dp),0+findProfit(idx+1,prices,1,k,dp));
    }
    else {
  //we can sell and not cell at this index
  profit=Math.max(prices[idx]+findProfit(idx+1,prices,1,k-1,dp),findProfit(idx+1,prices,0,k,dp));
    }
    return dp[idx][k][buy]= profit;
    }
    public int maxProfit(int k, int[] prices) {
    //here at particular index we have two options wheather we will buy at that index if we are ahaving buy or not buy at that index or sell at particlar index or not cell
 n=prices.length;
int[][][] dp=new int[n+1][k+1][2];
for(int[][] a:dp){
for(int[] b:a){
Arrays.fill(b,-1);
}
}
return findProfit(0,prices,1,k,dp);
    }
}