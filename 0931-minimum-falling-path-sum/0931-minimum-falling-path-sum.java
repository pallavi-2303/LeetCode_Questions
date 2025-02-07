class Solution {
 public int memoPath(int i,int j,int[][] matrix,int[][] dp) {
int m=matrix[0].length;
 //out of bound condition
 if(j<0 || j>=m)  {
    return (int)(1e9); }
 //base case
 if(i==0) {
  return matrix[0][j];}
 if(dp[i][j]!=-1) 
     return dp[i][j];
int up=matrix[i][j]+memoPath(i-1,j,matrix,dp);
int left=matrix[i][j]+memoPath(i-1,j-1,matrix,dp);
int right=matrix[i][j]+memoPath(i-1,j+1,matrix,dp);
return dp[i][j]=Math.min(up,Math.min(left,right));}
    public int minFallingPathSum(int[][] matrix) {
int n=matrix.length;
int m=matrix[0].length;
int[][] dp=new int[n][m];
/*for(int[] a:dp) {
   Arrays.fill(a,-1);}
//we have to perform the memoization for every column as it has variable ending and starting point
 int mini=(int)(1e9);
for(int j=0;j<m;j++) {
mini=Math.min(mini,memoPath(n-1,j,matrix,dp));}
     return mini;*/
 //Tabulation
  /*for(int j=0;j<m;j++) {
 dp[0][j]=matrix[0][j];}
for(int i=1;i<n;i++) {
for(int j=0;j<m;j++) {
int up=(int)(1e9);
int left=(int)(1e9);
int right=(int)(1e9);
up=matrix[i][j]+dp[i-1][j];
if(j>0) left=matrix[i][j]+dp[i-1][j-1];
if(j<m-1) right=matrix[i][j]+dp[i-1][j+1];
dp[i][j]=Math.min(up,Math.min(left,right));}}
//it has variable ending point therefore we take min of all path
int mini=(int)(1e9);
 for(int j=0;j<m;j++) {
 mini=Math.min(mini,dp[n-1][j]);}
            return mini;*/
//space optimization
int[] prev=new int[m];
//base case
for(int j=0;j<m;j++) {
prev[j]=matrix[0][j];}
for(int i=1;i<n;i++) {
int[] curr=new int[m];
for(int j=0;j<m;j++) {
int up=(int)(1e9);
int left=(int)(1e9);
int right=(int)(1e9);
up=matrix[i][j]+prev[j];
if(j>0) left=matrix[i][j]+prev[j-1];
if(j<m-1) right=matrix[i][j]+prev[j+1];
curr[j]=Math.min(up,Math.min(left,right));}
       prev=curr;}
  int mini2=(int)(1e9);
  for(int j=0;j<m;j++) {
  mini2=Math.min(mini2,prev[j]);}
      return mini2;


 
    }
}