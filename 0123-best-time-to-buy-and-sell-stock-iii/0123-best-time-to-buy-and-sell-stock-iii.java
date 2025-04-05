class Solution {
    public int findProfit(int idx,int buy,int cap,int[] nums,int[][][] dp){
if(cap==0  || idx==nums.length) 
return 0;
if(dp[idx][buy][cap]!=-1)
return dp[idx][buy][cap];
int profit=0;
if(buy==1){
//We have 2 option buy or not buy
profit=Math.max(-nums[idx]+findProfit(idx+1,0,cap,nums,dp),0+findProfit(idx+1,1,cap,nums,dp));}
else {
profit=Math.max(nums[idx]+findProfit(idx+1,1,cap-1,nums,dp),0+findProfit(idx+1,0,cap,nums,dp));}
return dp[idx][buy][cap]=profit;}
    public int maxProfit(int[] nums) {
        int n=nums.length;
// int[][][] dp=new int[n+1][2][3];
// for(int i=0;i<=n;i++){
// for(int j=0;j<2;j++){
// for(int k=0;k<=2;k++){
// dp[i][j][k]=-1;}}}
// return findProfit(0,1,2,nums,dp);
int[][][] dp=new int[n+1][2][3];
for(int i=n-1;i>=0;i--){
for(int buy=0;buy<=1;buy++){
for(int cap=1;cap<=2;cap++){
int profit=0;
if(buy==1){
profit=Math.max(-nums[i]+dp[i+1][0][cap],0+dp[i+1][1][cap]);}
else {
profit=Math.max(nums[i]+dp[i+1][1][cap-1],0+dp[i+1][0][cap]);}
dp[i][buy][cap]=profit;}}}
return dp[0][1][2];
    }
}