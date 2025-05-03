class Solution {
public class tuple{
int row;
int col;
int steps;
tuple(int row,int col,int steps){
this.row=row;
this.col=col;
this.steps=steps;
}
}
    public int nearestExit(char[][] grid, int[] entrance) {
        int n=grid.length;
int m=grid[0].length;
Queue<tuple> q=new LinkedList<>();
q.add(new tuple(entrance[0],entrance[1],0));
//If we don't want to change the input 
int[][] vis=new int[n][m];
vis[entrance[0]][entrance[1]]=1;
int[] delrow={-1,1,0,0};
int[] delcol={0,0,-1,1};
while(!q.isEmpty()){
tuple it=q.poll();
int row=it.row;
int col=it.col;
int steps=it.steps;
//Checking the condition where it reaches the boundary or not
if((row==0 || col==0 || row==n-1 || col==m-1) && !(row==entrance[0] && col==entrance[1])){
return steps;}
for(int i=0;i<4;i++){
int nrow=row+delrow[i];
int ncol=col+delcol[i];
if(nrow>=0 && ncol>=0 && nrow<n && ncol<m && grid[nrow][ncol]=='.' && vis[nrow][ncol]==0){
q.add(new tuple(nrow,ncol,steps+1));
vis[nrow][ncol]=1;}}}
return -1;//if not possible
    }
}