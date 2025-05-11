class Solution {
int n;
int m;
int[][] dp=new int[201][201];
public int solve(int i,int j,int[][] dungeon){
if(i>=n || j>=m) return (int)1e9;
if(i==n-1 && j==m-1){
if(dungeon[i][j]>0) return 1;//min value the adjcaent cell should have to reach the queen
else return Math.abs(dungeon[i][j])+1;
}
if(dp[i][j]!=-1) return dp[i][j];
int right=solve(i,j+1,dungeon);
int down=solve(i+1,j,dungeon);
int result=Math.min(right,down)-dungeon[i][j];//min value that the adjacent ceell shoud have to rreach the queen
return dp[i][j]=result>0 ? result :1;
}
    public int calculateMinimumHP(int[][] dungeon) {
    n=dungeon.length;
    m=dungeon[0].length;
    for(int[] a:dp) Arrays.fill(a,-1);
    return solve(0,0,dungeon);
    }
}