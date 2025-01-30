class Solution {
    public boolean isValid(int row,int col,char[][] board,int n) {
int duprow=row;
int dupcol=col;
//Checking the upper diagonal
while(row>=0 && col>=0) {
if(board[row][col]=='Q') return false;
row--;
col--;
}
//Checking the left side
row=duprow;
col=dupcol;
while(row>=0 && col>=0) {
if(board[row][col]=='Q') return false;
col--;
}
//right diagonal
row=duprow;
col=dupcol;
while(row<n && col>=0) {
if(board[row][col]=='Q') return false;
row++;
col--;
}
return true;
}
public List<String> construct(char[][] board) {
List<String> ans=new ArrayList<>();
int n=board.length;
for(int i=0;i<n;i++){
String s=new String(board[i]);
ans.add(s);
}
return ans;
}
public void solve(char[][]board,int col,List<List<String>> res,int n) {
if(col==n) {
res.add(construct(board));
return;
}
//Trying out all the possible ways by checking in all rows 
for(int row=0;row<n;row++){
if(isValid(row,col,board,n)) {
//place the queen in given board if it is valid 
board[row][col]='Q';
//Call for  the next col
solve(board,col+1,res,n);
//backtrack if the function reached end no possible configuration found remove the last placed
board[row][col]='.';
}
}
}
    public List<List<String>> solveNQueens(int n) {
      List<List<String>> res=new ArrayList<>();
char[][] board=new char[n][n];
//initially marking the board as empty
for(int i=0;i<n;i++){
for(int j=0;j<n;j++){
 board[i][j]='.';
}
}
solve(board,0,res,n);
return res;  
    }
}