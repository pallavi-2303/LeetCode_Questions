class Solution {
    public void setZeroes(int[][] matrix) {
     //brute force
     int n=matrix.length;
     int m=matrix[0].length;
    /* int[] row=new int[n] ;
     int[] col=new int[m] ;
     for(int i=0;i<n;i++){
    for(int j=0;j<m;j++){
    if(matrix[i][j]==0){
    row[i]=1;
    col[j]=1;
    }
    }
     }
//changing the matrix;
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(row[i]==1 || col[j]==1){
matrix[i][j]=0;
}
}
}*/
//optimized code we will use the first row and first col
int col0=1;
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(matrix[i][j]==0){
//mark the row
matrix[i][0]=0;
if(j!=0){
matrix[0][j]=0;
}
else {
col0=0;
}
}
}
}
//changing the value from 1 
for(int i=1;i<n;i++){
for(int j=1;j<m;j++){
if(matrix[i][0]==0 || matrix[0][j]==0){
matrix[i][j]=0;
}
}
}
//checking 0th column value
if(matrix[0][0]==0){
for(int j=0;j<m;j++)
matrix[0][j]=0;
}
//for the first row we will check  the  vvalue  of oth col
if(col0==0){
for(int i=0;i<n;i++)
matrix[i][0]=0;
}


    }
}