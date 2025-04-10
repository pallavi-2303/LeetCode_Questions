class Solution {
    public int findSum(int row,int col,int[][] grid,int[][] dp){
    if(row<0 || col<0) return (int)1e9;
    if(row==0 && col==0){
    return grid[0][0];
    }
if(dp[row][col]!=-1) return dp[row][col];
//we have two path either to move up or left
int up=grid[row][col]+findSum(row-1,col,grid,dp);
int left=grid[row][col]+findSum(row,col-1,grid,dp);
return dp[row][col]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
    int n=grid.length;
    int m=grid[0].length;
    int[][] dp=new int[n][m];
    for(int[] a:dp)  Arrays.fill(a,-1);
    return findSum(n-1,m-1,grid,dp);
    }
}