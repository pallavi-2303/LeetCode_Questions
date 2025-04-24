class Solution {
    public class tuple{
int row;
int col;
int time;
public tuple(int row,int col,int time){
this.row=row;
this.col=col;
this.time=time;
}
}
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
int m=grid[0].length;
int[][] vis=new int[n][m];
Queue<tuple> q=new LinkedList<>();
int countfresh=0;
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(grid[i][j]==2){
q.add(new tuple(i,j,0));
vis[i][j]=1;
}
else if(grid[i][j]==1) {
countfresh++;
}
}
}
int[] delrow={-1,1,0,0};
int[] delcol={0,0,-1,1};
int maxtime=0;
int count=0;
while(!q.isEmpty()){
tuple it=q.poll();
int row=it.row;
int col=it.col;
int t=it.time;
maxtime=Math.max(maxtime,t);
//visiting all the nodes that are fresh
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if( nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
count++;
vis[nrow][ncol]=1;
q.add(new tuple(nrow,ncol,t+1));
}
}
}
return count>=countfresh ? maxtime : -1;
    }
}