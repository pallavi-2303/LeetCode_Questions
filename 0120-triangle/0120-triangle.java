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
for(int[] a:dp)
Arrays.fill(a,-1);
return findSum(0,0,arr,dp); 
    }
}