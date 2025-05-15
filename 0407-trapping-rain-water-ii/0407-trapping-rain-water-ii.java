class Solution {
    public int trapRainWater(int[][] height) {
      int n=height.length;
int m=height[0].length;
int[][] vis=new int[n][m];
PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
//puuting all the boundary 
for(int i=0;i<n;i++){
pq.add(new int[]{height[i][0],i,0});
vis[i][0]=1;
pq.add(new int[]{height[i][m-1],i,m-1});
vis[i][m-1]=1;
}
for(int j=0;j<m;j++){
pq.add(new int[]{height[0][j],0,j});
vis[0][j]=1;
pq.add(new int[]{height[n-1][j],n-1,j});
vis[n-1][j]=1;
}
int water=0;
int[] dr={-1,1,0,0};
int[] dc={0,0,-1,1};
while(!pq.isEmpty()){
int[] a=pq.poll();
int height2=a[0];
int row=a[1];
int col=a[2];
for(int i=0;i<4;i++){
int nrow=row+dr[i];
int ncol=col+dc[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && vis[nrow][ncol]==0){
water+=Math.max(height2-height[nrow][ncol],0);
pq.add(new int[]{Math.max(height2,height[nrow][ncol]),nrow,ncol});
vis[nrow][ncol]=1;
}
}
}
return water;  
    }
}