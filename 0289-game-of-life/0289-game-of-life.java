class Solution {
    public boolean isValid(int row,int col,int n,int m){
    return row>=0 && col>=0 && row<n && col<m;
    }
    public void gameOfLife(int[][] board) {
     //if it is dead cell we will chnage that  to -1 aif i is live and if it is dead  we will change that to 2 if it become life
int n=board.length;
int m=board[0].length;
int[] delrow={-1,-1,0,1,1,1,0,-1};
int[] delcol={0,1,1,1,0,-1,-1,-1};
for(int row=0;row<n;row++){
for(int col=0;col<m;col++){
//traversing the all eight direction and count live negibours
int live=0;
for(int i=0;i<8;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(isValid(nrow,ncol,n,m) && Math.abs(board[nrow][ncol])==1){
live++;
}
}
if(board[row][col]==1 && (live<2 || live>3)){
board[row][col]=-1;
}
else if(board[row][col]==0 && live==3){
board[row][col]=2;
}
}
}
//making live  and dead correctly
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(board[i][j]>=1){
board[i][j]=1;
}
else {
board[i][j]=0;
}
}
}



    }
}