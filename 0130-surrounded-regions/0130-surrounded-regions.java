class Solution {
    public void dfs(int row,int col,int[][] vis,char[][] board,int[]delrow,int[] delcol) {
vis[row][col]=1;
int n=board.length;
int m=board[0].length;
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O') {
dfs(nrow,ncol,vis, board,delrow,delcol);
}
}
}
public class pair{
int row;
int col;
pair(int row,int col){
    this.row=row;
    this.col=col;
}
}
public void bfs(int r,int c,int[][] vis,char[][] board,int[] delrow,int[] delcol) {
Queue<pair> q=new LinkedList<>();
int n=vis.length;
int m=vis[0].length;
q.add(new pair(r,c));
vis[r][c]=1;
while(!q.isEmpty()) {
pair it=q.poll();
int row=it.row;
int col=it.col;
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
vis[nrow][ncol]=1;
q.add(new pair(nrow,ncol));
}
}
}
}
    public void solve(char[][] board) {
       int n=board.length;
int m=board[0].length;
int[][] vis=new int[n][m];
int[] delrow={-1,1,0,0};
int[] delcol={0,0,-1,1};
//the Oth that are on boundary mark them visited
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if((i==0 || j==0 || i==n-1 || j==m-1) && vis[i][j]==0 && board[i][j]=='O') {
//dfs(i,j,vis,board,delrow,delcol);
bfs(i,j,vis,board,delrow,delcol);
}
}
}
//mark every O that is not visited to X
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(vis[i][j]==0 && board[i][j]=='O'){
board[i][j]='X';
}
}
} 
    }
}