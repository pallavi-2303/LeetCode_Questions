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
int[][][] dp=new int[n+1][2][3];
for(int i=0;i<=n;i++){
for(int j=0;j<2;j++){
for(int k=0;k<=2;k++){
dp[i][j][k]=-1;}}}
return findProfit(0,1,2,nums,dp);
    }
}