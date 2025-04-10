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
    // for(int[] a:dp)  Arrays.fill(a,-1);
    // return findSum(n-1,m-1,grid,dp);

  for(int row=0;row<n;row++) {
for(int col=0;col<m;col++){
if(row==0 && col==0){
dp[row][col]=grid[0][0];
}
else {
int up=(int)1e9;
int left=(int)1e9;
if(row>0) up=grid[row][col]+dp[row-1][col];
if(col>0) left=grid[row][col]+dp[row][col-1];
dp[row][col]=Math.min(up,left);
}
}
  } 
  return dp[n-1][m-1];
    }
}