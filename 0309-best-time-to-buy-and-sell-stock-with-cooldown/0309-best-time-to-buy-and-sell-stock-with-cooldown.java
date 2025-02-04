class Solution {
public int Maxprofit(int idx,int buy,int[] prices,int[][] dp){
if(idx>=prices.length)
 return 0;
if(dp[idx][buy]!=-1)
   return dp[idx][buy];
    int profit=0;
if(buy==1) {
profit=Math.max(-prices[idx]+Maxprofit(idx+1,0, prices,dp),0+Maxprofit(idx+1,1,prices,dp));}
else {
profit=Math.max(prices[idx]+Maxprofit(idx+2,1,prices,dp),Maxprofit(idx+1,0,prices,dp));}
 return dp[idx][buy]=profit;}
    public int maxProfit(int[] prices) {
int n=prices.length;
// int[][] dp=new int[n+2][2];
/*for(int[] a:dp)
 Arrays.fill(a,-1);
  return Maxprofit(0,1,prices,dp);*/
  int[] prev=new int[2];
  int[] curr=new int[2];
 int[] prev2=new int[2];
 prev[0]=0;
 prev[1]=0;
//dp[n+1][1]=dp[n+1][0]=0;
//dp[n][1]=dp[n][0]=0;
for(int i=n-1;i>=0;i--) {
 for(int buy=0;buy<=1;buy++){
 int profit=0;
 if(buy==1) {
//profit=Math.max(-prices[i]+dp[i+1][0],0+dp[i+1][1]);}
 profit=Math.max(-prices[i]+prev[0],0+prev[1]);}
 else {
 //profit=Math.max(prices[i]+dp[i+2][1],0+dp[i+1][0]);}
profit=Math.max(prices[i]+prev2[1],0+prev[0]);}
 curr[buy]=profit;}
prev2=prev.clone();
 prev=curr.clone();}
// dp[i][buy]=profit;}}
            //return dp[0][1];
        return prev[1];
    }
}