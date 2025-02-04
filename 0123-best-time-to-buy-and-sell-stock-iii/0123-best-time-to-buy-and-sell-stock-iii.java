class Solution {
    public int maxprofit(int idx,int buy,int cap,int[] arr,int[][][] dp){
if(cap==0 || idx==arr.length)
return 0;
if(dp[idx][buy][cap]!=-1)
return dp[idx][buy][cap];
int profit=0;
if(buy==1){
profit=Math.max(-arr[idx]+maxprofit(idx+1,0,cap,arr,dp),0+maxprofit(idx+1,1,cap,arr,dp));
}
else {
 profit=Math.max(arr[idx]+maxprofit(idx+1,1,cap-1,arr,dp),0+maxprofit(idx+1,0,cap,arr,dp));
}
return dp[idx][buy][cap]=profit;
}
    public int maxProfit(int[] prices) {
     int n=prices.length;
int[][][] dp=new int[n+1][2][3];
for(int i=0;i<=n;i++){
for(int j=0;j<2;j++){
for(int k=0;k<3;k++){
dp[i][j][k]=-1;}}}
return maxprofit(0,1,2,prices,dp);   
    }
}