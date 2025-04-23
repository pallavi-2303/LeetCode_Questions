class Solution {
    public int equalPairs(int[][] grid) {
       //brute force
int n=grid.length;
//let us check for each row and each column which are similar 
int count=0;
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
boolean flag=true;
for(int k=0;k<n;k++){
if(grid[i][k]!=grid[k][j]) {
flag=false;
break;
}
}
if(flag) count++;
}
}
return count; 
    }
}