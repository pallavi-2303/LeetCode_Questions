class Solution {
    public int memo(int idx,int[] arr,int target,int[][] dp){
     if(idx==0) {
  if(target%arr[0]==0)  return 1;
  else return 0;    
     }  
     if(dp[idx][target]!=-1) return dp[idx][target];
     int take=0;
     if(arr[idx]<=target)
     take=memo(idx,arr,target-arr[idx],dp);
     int nottake=memo(idx-1,arr,target,dp);
     return dp[idx][target]=(take+nottake);
    }
    public int change(int amount, int[] arr) {
     int n=arr.length;
     int[][] dp=new int[n][amount+1];
     for(int[] a:dp) Arrays.fill(a,-1);
     return memo(n-1,arr,amount,dp);  
    }
}