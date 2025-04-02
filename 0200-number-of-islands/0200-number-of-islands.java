class Solution {
    public void dfs(int row,int col,int[][] vis,char[][] grid,int[] delrow,int[] delcol) {
//mark the current cel
vis[row][col]=1;
int n=grid.length;
int m=grid[0].length;
//traverse all the neighbours
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1') {
dfs(nrow,ncol,vis,grid,delrow,delcol);
}
}
}
public class pair{
int row;
int col;
public pair(int row,int col) {
this.row=row;
this.col=col;
}
}
public void bfs(char[][] grid,int r,int c,int[] delrow,int[] delcol,int[][] vis) {
int n=grid.length;
int m=grid[0].length;
Queue<pair> q=new LinkedList<>();
q.add(new pair(r,c));
vis[r][c]=1;
while(!q.isEmpty()) {
pair pq=q.poll();
int row=pq.row;
int col=pq.col;
//traversing all the 4 direction for given row
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]=='1'&& vis[row][ncol]==0){
vis[nrow][ncol]=1;
q.add(new pair(nrow,ncol));
}
}
}
}
    public int numIslands(char[][] grid) {
        int n=grid.length;
int m=grid[0].length;
int[][] vis=new int[n][m];
int[] delrow={-1,1,0,0};
int[] delcol={0,0,-1,1};
int count=0;
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(vis[i][j]==0 && grid[i][j]=='1'){
count++;
dfs(i,j,vis,grid,delrow,delcol);
}
}
}
return count;
    }
}