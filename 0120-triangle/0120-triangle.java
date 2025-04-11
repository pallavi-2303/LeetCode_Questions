class Solution {
    public int findSum(int i,int j,List<List<Integer>> arr,int[][] dp){
if(i==arr.size()-1)
return arr.get(i).get(j);
if(dp[i][j]!=-1) return dp[i][j];
int take=arr.get(i).get(j)+findSum(i+1,j,arr,dp);
int nottake=arr.get(i).get(j)+findSum(i+1,j+1,arr,dp);
return dp[i][j]=Math.min(take,nottake);
}
    public int minimumTotal(List<List<Integer>> arr) {
       int n=arr.size();
int[][] dp=new int[n][n];
// for(int[] a:dp)
// Arrays.fill(a,-1);
// return findSum(0,0,arr,dp); 


//space optimization
int[] prev=new int[n];
int[] curr=new int[n];
for(int j=0;j<n;j++){
 dp[n-1][j]=arr.get(n-1).get(j);
 prev[j]=arr.get(n-1).get(j);
}
for(int i=n-2;i>=0;i--){
for(int j=i;j>=0;j--){
//int take=arr.get(i).get(j)+dp[i+1][j];
int take=arr.get(i).get(j)+prev[j];
//int notake=arr.get(i).get(j)+dp[i+1][j+1];
int nottake=arr.get(i).get(j)+prev[j+1];
//dp[i][j]=Math.min(take,nottake);
curr[j]=Math.min(take,nottake);
}
prev=curr.clone();
}
//return dp[0][0];
return prev[0];
    }
}