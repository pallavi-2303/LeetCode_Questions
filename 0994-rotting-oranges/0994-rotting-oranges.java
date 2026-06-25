class Solution {
    public int orangesRotting(int[][] grid) {
     //since we have to find out the minimum time so we need to do bfs
     int n=grid.length;
     int m=grid[0].length;
     int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
     int freshCount=0;
     int[][] vis=new int[n][m];
     Queue<int[]> q=new LinkedList<>();
     for(int i=0;i<n;i++) {
    for(int j=0;j<m;j++){
    if(grid[i][j]==0){
    continue;
    }
    else if(grid[i][j]==1){
    freshCount++;
    }
    else {
    q.offer(new int[]{i,j,0});
    vis[i][j]=1;
    }
    }
     }
     int count=0;
     int time=0;
     while(!q.isEmpty()){
    int[] curr=q.poll();
    int r=curr[0];
    int c=curr[1];
    int t=curr[2];
    time=Math.max(time,t);
    for(int[] d:dir){
    int nr=r+d[0];
    int nc=c+d[1];
    if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==0 && grid[nr][nc]==1){
    q.offer(new int[]{nr,nc,t+1});
    vis[nr][nc]=1;
    count++;
    }
    }
     }
     return count>=freshCount ? time :-1;
    }
}