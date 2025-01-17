class Solution {
    public void dfs(int row,int col,int[][] grid,int[][] vis,int[] delrow,int[] delcol){
        vis[row][col]=1;
         int n=grid.length;
    int m=grid[0].length;
    for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
    dfs(nrow,ncol,grid,vis,delrow,delcol);
}
    }
    }
    public int numEnclaves(int[][] grid) {
    //we will perform dfs to mark the cell which are on the boundary
    int n=grid.length;
    int m=grid[0].length;
    int[][] vis=new int[n][m];
    int[] delrow={-1,1,0,0};
    int[] delcol={0,0,-1,1};
    //markingthe 1 which areon the boundary
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(i==0 || j==0 || i==n-1 || j==m-1){
            if(vis[i][j]==0 && grid[i][j]==1){
                dfs(i,j,grid,vis,delrow,delcol);
            }
            }
        }
    }
    int count=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(vis[i][j]==0 && grid[i][j]==1){
                count++;
            }
        }
    }
    return count;
    }
}