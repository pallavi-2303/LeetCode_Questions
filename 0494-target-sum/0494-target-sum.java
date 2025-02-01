class Solution {
    public int findSum(int idx,int[] arr,int target,int[][] dp) {
if(idx==0) {
if(arr[0]==0 && target==0)
return 2;
if(target==0 || arr[0]==target)
return 1;
 return 0;
}
if(dp[idx][target]!=-1)
return dp[idx][target];
int pick=0;
if(arr[idx]<=target)
pick=findSum(idx-1,arr,target-arr[idx],dp);
int notpick=findSum(idx-1,arr,target,dp);
return dp[idx][target]=(pick+notpick);
}
    public int findTargetSumWays(int[] nums, int target) {
       // since we have to find the total subsets of + and - it is same as s1-s2=d
int n=nums.length;
int total=0;
for(int it:nums)
total+=it;
if((total-target)<0 || (total-target)%2!=0)
return 0;
int target2=(total-target)/2;

int[][] dp=new int[n][target2+1];
for(int[] a:dp) Arrays.fill(a,-1);
return findSum(n-1,nums,target2,dp);
    }
}