class Solution {
    public int findMinSum(int i,int j,int[][] mat,int[][] dp) {
 if(i<0 || j<0)
 return (int)(1e9);
 if(i==0 && j==0)
 return mat[0][0];
 if(dp[i][j]!=-1) return dp[i][j];
 int up=mat[i][j]+findMinSum(i-1,j,mat,dp);
 int left=mat[i][j]+findMinSum(i,j-1,mat,dp);
 return dp[i][j]=Math.min(up,left);
}
    public int minPathSum(int[][] mat) {
      int n=mat.length;
      int m=mat[0].length;
      int[][] dp=new int[n][m];
// for(int[] a:dp)
// Arrays.fill(a,-1);
// return findMinSum(n-1,m-1,mat,dp);  
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
if(i==0 && j==0) 
dp[i][j]=mat[0][0];
else {
int up=(int)(1e9);
int left=(int)(1e9);
if(i>0) up=mat[i][j]+dp[i-1][j];
if(j>0) left=mat[i][j]+dp[i][j-1];
dp[i][j]=Math.min(up,left);
}
}
}
return dp[n-1][m-1];
    }
}