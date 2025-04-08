class Solution {
    public List<String> construct(char[][] board){
List<String> temp=new ArrayList<>();
int n=board.length;
for(int i=0;i<n;i++){
String str=new String(board[i]);
temp.add(str);}
return temp;}
public boolean isValid(int row,int col,char[][] board){
int n=board.length;
int m=board[0].length;
//Left row
int delrow=row;
int delcol=col;
while(col>=0){
if(board[row][col]=='Q'){
return false;}
col--;}
//Upper diagonal 
row=delrow;
col=delcol;
while(row>=0 && col>=0){
if(board[row][col]=='Q'){
return false;}
col--;
row--;}
//Lower diagonal
row=delrow;
col=delcol;
while(row<n && col>=0){
if(board [row][col]=='Q'){
return false;}
row++;
col--;}
return true;}
    public void solve(int col,char[][] board,List<List<String>> res){
//Base case
int n=board.length;
if(col==n){
res.add(construct(board));
return;}
for(int row=0;row<n;row++){
if(isValid(row,col,board)){
board[row][col]='Q';
solve(col+1,board,res);
//Backtrack if next function returns false 
board[row][col]='.';}}}
    public int totalNQueens(int n) {
    char[][] board=new char[n][n];
List<List<String>> res=new ArrayList<>();
for(char[] a:board){
Arrays.fill(a,'.');}
solve(0,board,res);
return res.size();   
    }
}