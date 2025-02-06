class Solution {
    public int findMax(int i,int[] arr,int k,int[] dp){
    int n=arr.length;
    if(i==n) return 0;
    if(dp[i]!=-1) return dp[i];
int maxi=-(int)1e9;
int sum=0;
int len=0;
int max=-1;
for(int j=i;j<Math.min(i+k,n);j++){
len++;
max=Math.max(max,arr[j]);
sum=len*max+findMax(j+1,arr,k,dp);
maxi=Math.max(maxi,sum);
}
return dp[i]=maxi;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
      //this problem is a type of front partioning
      int n=arr.length;
      int[] dp=new int[n];
      Arrays.fill(dp,-1) ;
      return findMax(0,arr,k,dp) ;
    }
}