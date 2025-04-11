class Solution {
    public int findPath(int i,int j,int[][] grid,int[][] dp){
if(j<0 || i<0 ) return 0;
if(grid[i][j]==1) return 0;
if(i==0 && j==0){
if(grid[i][j]==0) return 1;
else return 0;}
if(dp[i][j]!=-1) return dp[i][j];
int up=findPath(i-1,j,grid,dp);
int left=findPath(i,j-1,grid,dp);
return dp[i][j]=up+left;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
     int n=grid.length;
     int m=grid[0].length;
     if(grid[n-1][m-1]==1) return 0;
     int[][] dp=new int[n][m];
     for(int[] a:dp) Arrays.fill(a,-1);

     return findPath(n-1,m-1,grid,dp);
    }
}