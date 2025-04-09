class Solution {
    public boolean find(int i,int j,char[][] board,int idx,String word){
//condition check 
int n=board.length;
int m=board[0].length;
int[] delrow={-1,1,0,0};
int[] delcol={0,0,-1,1};
if(idx==word.length()) 
return true;
if(i>=n || j>=m || i<0 || j<0)
return false;
if(word.charAt(idx)!=board[i][j])
return false;
char temp=board[i][j];
board[i][j]='$';
for(int index=0;index<4;index++){
int nrow=delrow[index]+i;
int ncol=delcol[index]+j;
if(find(nrow,ncol,board,idx+1,word))
return true;}
board[i][j]=temp;
return false;}
    public boolean exist(char[][] board, String word) {
      int n=board.length;
      int m=board[0].length;
//initial call;
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(board[i][j]==word.charAt(0) && find(i,j,board,0,word)){
return true;}}}
return false ;
    }}