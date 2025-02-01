class Solution {
public int memoSum(int idx,int[] arr,int target,int[][] dp) {
//base case
if(idx==0) {
if(target==0 && arr[0]==0) 
    return 2;
 if(target==0 || arr[0]==target)
     return 1;
return 0;}
 if(dp[idx][target]!=-1)
   return dp[idx][target];
int nottake=memoSum(idx-1,arr,target,dp);
 int take=0;
 if(arr[idx]<=target)
  take=memoSum(idx-1,arr,target-arr[idx],dp);
 return dp[idx][target]=(take+nottake);}
    public int findTargetSumWays(int[] nums, int target) {
/* if we use the problem s1-s2=d
x1+x2+x3-x4-x5 it is same as that problem as s1+s2=total
total-s2-s2=d s2=(total-d)/2;*/
int n=nums.length;
int total=0;
for(int num:nums) total+=num;
if((total-target)<0 || (total-target)%2!=0) 
    return 0;
 int sum=(total-target)/2;
int[][] dp=new int[n][sum+1];
/* for(int[] a:dp) Arrays.fill(a,-1);
  return memoSum(n-1,nums,sum,dp);*/
//tabulation
int[] prev=new int[sum+1];

if(nums[0]==0) 
 //dp[0][0]=2;
prev[0]=2;
else 
//dp[0][0]=1;
 prev[0]=1;
if(nums[0]!=0 && nums[0]<=sum)
 // dp[0][nums[0]]=1;
  prev[nums[0]]=1;
for(int i=1;i<n;i++) {
int[] curr=new int[sum+1];
 if(nums[0]==0) curr[0]=2;
 else curr[0]=1;
for(int tar=0;tar<=sum;tar++) {
//int nottake=dp[i-1][tar];
int nottake=prev[tar];
int take=0;
if(nums[i]<=tar)
 //take=dp[i-1][tar-nums[i]];
 take=prev[tar-nums[i]];
//dp[i][tar]=take+nottake;}}
 curr[tar]=take+nottake;}
  prev=curr;}
    // return dp[n-1][sum];
 return prev[sum];



        
    }
}