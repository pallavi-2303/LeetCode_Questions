class Solution {
    public int[] getCoordinates(int num,int n) {
int topRow=(num-1)/n;
int bottomRow=(n-1)-topRow;
int col=(num-1)%n;
//if it is right to left path
if((bottomRow%2==0 && n%2==0) || (bottomRow%2==1 && n%2==1)) {
col=(n-1)-col;
}
int[] ans={bottomRow,col};
return ans;
}
    public int snakesAndLadders(int[][] board) {
    int n=board.length;
int[][] vis=new int[n][n];
Queue<Integer> q=new LinkedList<>();
//add the first element to queue
q.add(1);
int steps=0;
vis[n-1][0]=1;
while(!q.isEmpty()) {
int size=q.size();
while(size>0) {
//take out the first elenent from q
int x=q.poll();
if(x==n*n) return steps;
//try all possible number for current element 
for(int k=1;k<=6;k++){
int val=x+k;
if(val>n*n) break;
int[] ans=getCoordinates(val,n);
int row=ans[0];
int col=ans[1];
//if this current element us already visited
if(vis[row][col]==1) continue;
vis[row][col]=1;
if(board[row][col]==-1) {
q.add(val);
}
else {
//this is for ladder
q.add(board[row][col]);
}
}
size--;
}
steps++;
}
return -1;//not possible;    
    }
}