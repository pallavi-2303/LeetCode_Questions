class Solution {
public void findCount(int i,int j,int[][] grid,int totalCount,int[] count,int currCount,int[] dr,int[] dc){
int n=grid.length;
int m=grid[0].length;
if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==-1) return;
if(grid[i][j]==2) {
//we fount the valid path
if(currCount==totalCount) {
count[0]++;//we found a valid path 
}
return; // if all path are not visited
}
//mark it visited
grid[i][j]=-1;
//call for recussion
for(int in=0;in<4;in++){
int nrow=dr[in]+i;
int ncol=dc[in]+j;
findCount(nrow,ncol,grid, totalCount,count,currCount+1,dr,dc);
}
//backtrack 
grid[i][j]=0;
}
    public int uniquePathsIII(int[][] grid) {
          int n=grid.length;
int m=grid[0].length;
int totalCount=0;
int startx=0;
int starty=0;
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(grid[i][j]==0){
//it is a valid path
totalCount++;
}
else if(grid[i][j]==1){
//we have to start from it 
startx=i;
starty=j;
}
}
}
totalCount+=1;
//tc-> n*m + 2 ^ n*m  sc-> O(n*m)
int[] dr={-1,1,0,0};
int[] dc={0,0,-1,1};
int[] count={0};
findCount(startx,starty,grid,totalCount,count,0,dr,dc);
return count[0];
    }
}