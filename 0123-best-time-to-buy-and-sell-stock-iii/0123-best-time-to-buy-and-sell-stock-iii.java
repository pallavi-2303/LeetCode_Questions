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
// for(int i=0;i<=n;i++){
// for(int j=0;j<2;j++){
// for(int k=0;k<3;k++){
// dp[i][j][k]=-1;}}}
// return maxprofit(0,1,2,prices,dp); 
//for any index and buy if cap is 0
for(int i=0;i<=n;i++){
for(int buy=0;buy<=1;buy++){
dp[i][buy][0]=0;}}
//for index n
for(int buy=0;buy<=1;buy++){
for(int cap=0;cap<=2;cap++){
dp[n][buy][cap]=0;}}
for(int i=n-1;i>=0;i--){
for(int buy=0;buy<=1;buy++){
for(int cap=1;cap<=2;cap++){
int profit=0;
if(buy==1) {
profit=Math.max(-prices[i]+dp[i+1][0][cap],0+dp[i+1][1][cap]);
}
else {
profit=Math.max(prices[i]+dp[i+1][1][cap-1],0+dp[i+1][0][cap]);
}
dp[i][buy][cap]=profit;
}
}
}
return dp[0][1][2];  
    }
}