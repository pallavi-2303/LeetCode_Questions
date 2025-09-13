class Solution {
    public int shortestPath(int[][] grid, int k) {
        //we have to find yhe shortest path so we can apply dfs since while visting oath it depends on whether we have removed any obstracle or not so we will store it as whether to temove obstracle or not 
int n=grid.length;
int m=grid[0].length;
//TC->(n*n*4) 
//Sc->(n*m*k)
int[][][] vis=new int[n][m][k+1];
Queue<int[]> q=new LinkedList<>();
//put the initial step
q.add(new int[]{0,0,k});
vis[0][0][k]=1;
//perform the bfs 
int steps=0;
int[] dr={-1,1,0,0};
int[] dc={0,0,-1,1};
while(!q.isEmpty()){
int size=q.size();
while(size>0){
int[] it=q.poll();
int r=it[0];
int c=it[1];
if(r==n-1 && c==m-1) return steps;
int obs=it[2];
//moving to its neighbours 
for(int i=0;i<4;i++){
int nrow=r+dr[i];
int ncol=c+dc[i];
if(nrow<0 || ncol<0 || nrow>=n || ncol>=m) continue;
if(vis[nrow][ncol][obs]==0 && grid[nrow][ncol]==0){
//there is no obstracle we can go to its neighbours 
q.add(new int[]{nrow,ncol,obs});
vis[nrow][ncol][obs]=1;
}
//it is 1 means it has obstracle
else if(grid[nrow][ncol]==1 && obs>0 && vis[nrow][ncol][obs-1]==0) {
vis[nrow][ncol][obs-1]=1;//remoaved 1 obstracle at current cell
q.add(new int[]{nrow,ncol,obs-1});
}
}
size--;
}
steps++;//used 1 step to move to its neighbours 
}
return -1;//not possible 


    }
}