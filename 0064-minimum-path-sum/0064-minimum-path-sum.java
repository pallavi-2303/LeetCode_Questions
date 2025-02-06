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
for(int[] a:dp)
Arrays.fill(a,-1);
return findMinSum(n-1,m-1,mat,dp);  
    }
}