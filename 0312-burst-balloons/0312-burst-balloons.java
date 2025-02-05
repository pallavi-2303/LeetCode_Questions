class Solution {
    public int memo(int i,int j,List<Integer> arr,int[][] dp) {
if(i>j) return 0;
if(dp[i][j]!=-1) return dp[i][j];
int maxi=-(int)(1e9);
for(int idx=i;idx<=j;idx++){
int cost=arr.get(idx)*arr.get(i-1)*arr.get(j+1)+memo(i,idx-1,arr,dp)+memo(idx+1,j,arr,dp);
maxi=Math.max(maxi,cost);
}
return dp[i][j]=maxi;
}
    public int maxCoins(int[] nums) {
      int n=nums.length;
List<Integer> temp=new ArrayList<>();
temp.add(1);
for(int i=0;i<n;i++){
temp.add(nums[i]);
}
temp.add(1);
int[][] dp=new int[n+1][n+1];
for(int[] a:dp)
Arrays.fill(a,-1);
return memo(1,n,temp,dp);  
    }
}