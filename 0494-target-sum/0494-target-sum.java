class Solution {
    public int findSumTabu(int[] arr,int target) {
 int n=arr.length;
 //int[][] dp=new int[n][target+1];
 int[] prev=new int[target+1];
 int[] curr=new int[target+1];
 if(arr[0]==0)
 //dp[0][0]=2;
 prev[0]=2;
 else {
 //dp[0][0]=1;
 prev[0]=1;}
 if(arr[0]!=0 && arr[0]<=target)
 //dp[0][arr[0]]=1;
 prev[arr[0]]=1;
for(int i=1;i<n;i++) {
 curr[0]=1;
for(int tar=0;tar<=target;tar++){
int pick=0;
if(arr[i]<=tar)
//pick=dp[i-1][tar-arr[i]];
pick=prev[tar-arr[i]];
//int notpick=dp[i-1][tar];
int notpick=prev[tar];
//dp[i][tar]=(pick+notpick);
curr[tar]=(pick+notpick);
}
prev=curr.clone();
}
//return dp[n-1][target];
return prev[target];
}
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
return findSumTabu(nums,target2);
    }
}