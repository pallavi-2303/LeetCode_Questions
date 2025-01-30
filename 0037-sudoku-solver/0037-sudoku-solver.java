class Solution {
    public boolean solve(char[][] board){
    int n=board.length;
 for(int i=0;i<n;i++) {
 for(int j=0;j<board[0].length;j++){
 if(board[i][j]=='.') {
  //fill with character 1 to 9
  for(char ch='1';ch<='9';ch++){
 if(isValid(ch,i,j,board)) {
  board[i][j]=ch;
  //next call
  if(solve(board)) return true;
  //backtracking unmark with previous filled character
  else board[i][j]='.';
 }
  }
  return false;//if no valid character found
 }
 }
 }
 return true;//if the loop ends 
}
public boolean isValid(char ch,int 
row,int col,char[][] board) {
//checking the entire row 
for(int i=0;i<9;i++){
if(board[row][i]==ch)
return false;
if(board[i][col]==ch) 
return false;
//checking the grid
if(board[3*(row/3)+i/3][3*(col/3)+i%3]==ch)
return false;
}
return true;//valid   
}
    public void solveSudoku(char[][] board) {
       solve(board); 
    }
}