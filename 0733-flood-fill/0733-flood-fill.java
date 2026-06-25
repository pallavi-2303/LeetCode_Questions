class Solution {
    int n;
    int m;
    int iniCol;
    int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
    public void dfs(int r,int c,int[][] image,int[][] vis,int color){
    image[r][c]=color;
    vis[r][c]=1;
    for(int[] d:dir){
    int nr=r+d[0];
    int nc=c+d[1];
    if(nr>=0 && nc>=0 && nr<n && nc<m && vis[nr][nc]==0 && image[nr][nc]==iniCol){
    dfs(nr,nc,image,vis,color);
    }
    }
    }
     public void bfs(int r,int c,int[][] image,int[][] vis,int color){
Queue<int[]> q=new LinkedList<>();
q.offer(new int[]{r,c});
vis[r][c]=1;
image[r][c]=color;
while(!q.isEmpty()){
int[] curr=q.poll();
int row=curr[0];
int col=curr[1];
for(int[] d:dir){
int nr=row+d[0];
int nc=col+d[1];
if(nr>=0 && nc>=0 &&  nr<n && nc<m && vis[nr][nc]==0 && image[nr][nc]==iniCol){
q.offer(new int[]{nr,nc});
vis[nr][nc]=1;
image[nr][nc]=color;
}
}
}

     }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
     n=image.length;
     m=image[0].length;
     iniCol=image[sr][sc];
     int[][] vis=new int[n][m];
     bfs(sr,sc,image,vis,color);
     return image;


    }
}