class Solution {
    public int findPath(int i,int j,int[][] mat,int[][] dp) {
//base cases
if(i<0 || j<0) return 0;
if(mat[i][j]==1) return 0;
if(i==0 && j==0) return 1;
if(dp[i][j]!=-1) return dp[i][j];
int up=findPath(i-1,j,mat,dp);
int left=findPath(i,j-1,mat,dp);
return dp[i][j]=up+left;
}
    public int uniquePathsWithObstacles(int[][] mat) {
    int n=mat.length;
    int m=mat[0].length;
     int[][] dp=new int[n][m];
for(int[] a:dp)
Arrays.fill(a,-1);
return findPath(n-1,m-1,mat,dp);   
    }
}