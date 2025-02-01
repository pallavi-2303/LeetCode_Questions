class Solution {
    public int memo(int idx,int[] arr,int target,int[][] dp) {
//we will go till zero index
if(idx==0) {
if(target%arr[0]==0) 
return target/arr[0];//number of coins to form the answer
else return (int)(1e9);//if not possible to form the target
}
if(dp[idx][target]!=-1) return dp[idx][target];
//if we take a particular index for
int pick=(int)1e9;
if(arr[idx]<=target)
pick=1+memo(idx,arr,target-arr[idx],dp);
int notpick=0+memo(idx-1,arr,target,dp);
return dp[idx][target]=Math.min(pick,notpick);
}
    public int coinChange(int[] arr, int amount) {
       int n=arr.length;
int[][] dp=new int[n][amount+1];
for(int[] a:dp) Arrays.fill(a,-1);
int ans= memo(n-1,arr,amount,dp);
return ans==(int)1e9 ? -1 :ans;
    }
}