class Solution {
    public void dfs(int row,int col,char[][] board,int[][] vis,int[] delrow,int[] delcol){
         int n=board.length;
     int m=board[0].length;
     vis[row][col]=1;
     for(int i=0;i<n;i++) {
    int nrow=row+delrow[i];
    int ncol=col+delcol[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
 dfs(nrow,ncol,board,vis,delrow,delcol);
    }
     }
    }
    public void solve(char[][] board) {
     //since we have to connect the region we fill perform dfs and bfs to mark the region that are on edge 
     int n=board.length;
     int m=board[0].length;
     int[] delrow={-1,1,0,0};
     int[] delcol={0,0,-1,1};
     int[][] vis=new int[n][m];
     //pereforming the region that are on edge
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
        if(i==0 || j==0 ||i==n-1 || j==m-1){
        if(vis[i][j]==0 && board[i][j]=='O'){
        dfs(i,j,board,vis,delrow,delcol);
        }
        }
        }
     }
     //changing the rest of zero with x
     for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(board[i][j]=='O' && vis[i][j]==0){
                board[i][j]='X';
            }
        }
     }
    }
}