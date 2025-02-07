class Solution {
  public int findSum(int i, int j, int[][] mat, int[][] dp) {
    int n = mat.length;
    int m = mat[0].length;
    if (j < 0 || j >= m)
      return (int) 1e9;
    if (i == 0) {
      return mat[i][j];
    }
    if (dp[i][j] != -1)
      return dp[i][j];
    int up = mat[i][j] + findSum(i - 1, j, mat, dp);
    int left = mat[i][j] + findSum(i - 1, j - 1, mat, dp);
    int right = mat[i][j] + findSum(i - 1, j + 1, mat, dp);
    return dp[i][j] = Math.min(up, Math.min(left, right));
  }

  public int minFallingPathSum(int[][] mat) {
    // Since it has unfixed starting point and unfixed ending point
    int n = mat.length;
    int m = mat[0].length;
    int[][] dp = new int[n][m];
    // for (int[] a : dp)
    //   Arrays.fill(a, -1);
    // int mini = (int) 1e9;
    // for (int j = 0; j < m; j++) {
    //   mini = Math.min(mini, findSum(n - 1, j, mat, dp));
    // }
    // return mini;
    //base case
/*for(int j=0;j<m;j++){
dp[0][j]=mat[0][j];
}
for(int i=1;i<n;i++){
for(int j=0;j<m;j++){
int up=mat[i][j]+dp[i-1][j];
int left=(int)1e9;
if(j-1>=0) 
left=mat[i][j]+dp[i-1][j-1];
int right=(int)1e9;
if(j+1<m) 
right=mat[i][j]+dp[i-1][j+1];
dp[i][j]=Math.min(up,Math.min(left,right));
}
}
int mini=(int)1e9;
for(int j=0;j<m;j++){
mini=Math.min(dp[n-1][j],mini);
}
return mini;*/
//space optimization
int[] prev=new int[m];
int[] curr=new int[m];
//base case
for(int j=0;j<m;j++){
//dp[0][j]=mat[0][j];
prev[j]=mat[0][j];
}
for(int i=1;i<n;i++){
for(int j=0;j<m;j++){
int up=mat[i][j]+prev[j];
int left=(int)1e9;
if(j-1>=0) 
left=mat[i][j]+prev[j-1];
int right=(int)1e9;
if(j+1<m) 
right=mat[i][j]+prev[j+1];
curr[j]=Math.min(up,Math.min(left,right));
}
prev=curr.clone();
}
int mini=(int)1e9;
for(int j=0;j<m;j++){
mini=Math.min(prev[j],mini);
}
return mini;
  }
}