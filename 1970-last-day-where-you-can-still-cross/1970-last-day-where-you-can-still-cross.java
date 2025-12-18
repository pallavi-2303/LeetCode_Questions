class Solution {
int r;
int c;
int[][] dir={{-1,0},{0,-1},{1,0},{0,1}};
public boolean dfs(int i,int j,int[][] grid){
//mark visisted
grid[i][j]=1;
if(i==r-1 ){
//last cell
return true;
}
for(int[] d:dir){
int nrow=i+d[0];
int ncol=j+d[1];
if(nrow>=0 && ncol>=0 && nrow<r && ncol<c && grid[nrow][ncol]==0){
if(dfs(nrow,ncol,grid)){
return true;
}
}
}
return false;
}
public boolean canCross(int[][] cells,int day){
//day is index based
int[][] grid=new int[r][c];
//mark all the cells from 0 to day as land
for(int i=0;i<=day;i++){
int row=cells[i][0]-1;
int col=cells[i][1]-1;
grid[row][col]=1;
}
//do dfs from every top cell if it is 0 and try to reach at the end
for(int j=0;j<c;j++){
if(grid[0][j]==0 && dfs(0,j,grid)){
return true;
}
}
return false;
}
    public int latestDayToCross(int row, int col, int[][] cells) {
    //less day on which we can go is 0 amd max day will n*n as given in cell when it reaches last index all will be water
    //we will use index 
int n=cells.length;
int res=0;
r=row;
c=col;
int low=0;
int high=n-1;
while(low<=high){
int mid=low+(high-low)/2;
//ith index means i+1 day
if(canCross(cells,mid)){
res=mid+1;
low=mid+1;
}
else {
high=mid-1;
}
}  
return res; 
    }
}