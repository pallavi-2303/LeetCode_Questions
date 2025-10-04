class Solution {
int n;
public int solve(int idx,int prev,int[] nums,int rem,int[][] dp){
if(idx>=n) return 0;
if(prev!=-1 && dp[idx][prev]!=-1){
return dp[idx][prev];
}
//at any index we have two two option either to take the current elemnt or skip that
int notTake=solve(idx+1,prev,nums,rem,dp);
int take=0;
if(prev==-1 || (nums[prev]+nums[idx])%2==rem){
take=1+solve(idx+1,idx,nums,rem,dp);
}
int result=Math.max(take,notTake);
if(prev!=-1){
dp[idx][prev]=result;
}
return result;
}
public int solve2(int[] nums,int rem){
int[] dp=new int[n];
int maxi=0;
Arrays.fill(dp,1);//1 length sussequnce is always valid 
for(int i=1;i<n;i++){
for(int j=0;j<i;j++){
//check if i can join j or not
if((nums[i]+nums[j])%2==rem && dp[j]+1>dp[i]){
dp[i]=dp[j]+1;// for i 
}
}
maxi=Math.max(maxi,dp[i]);
}
return maxi;
}
    public int maximumLength(int[] nums) {
     //since we have to fins the legth of the longest valid subsequcnce it is avariant of lis and any number didvied by 2 gives remainter eother 0 or 1so will will find out the subsequnce with remainder 0 and 1
n=nums.length;
// int[][] dp1=new int[n+1][n+1];
// int[][] dp0=new int[n+1][n+1];
// for(int[] a:dp0) Arrays.fill(a,-1);
// for(int[] a:dp1) Arrays.fill(a,-1);
// return Math.max(solve(0,-1,nums,0,dp0),solve(0,-1,nums,1,dp1));
return Math.max(solve2(nums,0),solve2(nums,1));
    }
}