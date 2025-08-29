class Solution {
int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
int n;
int m;
public void dfs(int i,int j,char[][] grid,int[][] vis){
vis[i][j]=1;
for(int id=0;id<4;id++){
int nrow=i+dir[id][0];
int ncol=j+dir[id][1];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
dfs(nrow,ncol,grid,vis);
}
}
}
public void bfs(int i,int j,char[][] grid,int[][] vis){
Queue<int[]> q=new LinkedList<>();
q.add(new int[]{i,j});
vis[i][j]=1;
while(!q.isEmpty()){
int[] a=q.poll();
int row=a[0];
int col=a[1];
for(int[] d:dir){
int nrow=row+d[0];
int ncol=col+d[1];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
vis[nrow][ncol]=1;
q.add(new int[]{nrow,ncol});
}
}
}
}
    public int numIslands(char[][] grid) {
      n=grid.length;
m=grid[0].length;
int count=0;
int[][] vis=new int[n][m];
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(grid[i][j]=='1' && vis[i][j]==0){
count++;
dfs(i,j, grid,vis);
}
}
}
return count;  
    }
}