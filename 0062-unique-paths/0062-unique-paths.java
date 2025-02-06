class Solution {
    public int findPath(int i,int j,int[][] dp) {
//base case
if(i<0 || j<0) return 0;
if(i==0 && j==0) return 1;
if(dp[i][j]!=-1) return dp[i][j];
int up=findPath(i-1,j,dp);
int left=findPath(i,j-1,dp);
return dp[i][j]=up+left;
}
    public int uniquePaths(int n, int m) {
        int[][] dp=new int[n][m];
for(int[] a:dp)
Arrays.fill(a,-1);
return findPath(n-1,m-1,dp);
    }
}