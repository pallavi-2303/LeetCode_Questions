class Solution {
  public boolean isSafe(char[][] board,int row,int col,char ch){
for(int i=0;i<9;i++){
//checking the row
if(i!=col && board[row][i]==ch) return false;
//checking the column
if(i!=row && board[i][col]==ch) return false;
int r=3*(row/3)+i/3;
int c=3*(col/3)+i%3;
if((row!=r || col!=c) && board[r][c]==ch) return false;
}
return true;
  }
    public boolean isValidSudoku(char[][] board) {
     int n=board.length;
     int m=board[0].length;
   
 for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(board[i][j]!='.'){
char ch=board[i][j];
if(isSafe(board,i,j,ch)==false) return false;
}
 }}
return true;


    }
}