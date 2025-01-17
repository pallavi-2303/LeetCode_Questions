class Solution {
    public class pair{
        int row;
        int col;
        public pair(int row,int col){
            this.row=row;
            this.col=col;
        }

    }
    public void dfs(int row,int col,char[][] board,int[][] vis,int[] delrow,int[] delcol){
         int n=board.length;
     int m=board[0].length;
     vis[row][col]=1;
     for(int i=0;i<4;i++) {
    int nrow=row+delrow[i];
    int ncol=col+delcol[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
 dfs(nrow,ncol,board,vis,delrow,delcol);
    }
     }
    }
    public void bfs(int i,int j,char[][] board,int[][] vis,int[] delrow,int[] delcol){
     int n=board.length;
     int m=board[0].length;
Queue<pair> q=new LinkedList<>();
q.add(new pair(i,j));
vis[i][j]=1;
while(!q.isEmpty()){
    pair it=q.poll();
    int row=it.row;
    int col=it.col;
for(int idx=0;idx<4;idx++){
int nrow=row+delrow[idx];
int ncol=col+delcol[idx];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
vis[nrow][ncol]=1;
q.add(new pair(nrow,ncol));
}
}}
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
        if(i==0 || j==0 || i==n-1 || j==m-1){
        if(vis[i][j]==0 && board[i][j]=='O'){
       // dfs(i,j,board,vis,delrow,delcol);
        bfs(i,j,board,vis,delrow,delcol);
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