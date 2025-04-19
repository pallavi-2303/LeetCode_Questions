class Solution {
public int findInsertions(int i,int j,String s,String t,int[][] dp){
if(i==0 || j==0) return 0;
if(dp[i][j]!=-1) return dp[i][j];
//if the string matches
if(s.charAt(i-1)==t.charAt(j-1)){
return dp[i][j]=1+findInsertions(i-1,j-1,s,t,dp);
}
else {
return dp[i][j]=Math.max(findInsertions(i-1,j,s,t,dp),findInsertions(i,j-1,s,t,dp));
}
}
    public int minInsertions(String s) {
     //since we have to find minimum number of insertions we need to find out the longest pallindromic pallindrme so than we need to do minmum insertion
int n=s.length();
int[][] dp=new int[n+1][n+1];
//for(int[] a:dp) Arrays.fill(a,-1);
StringBuilder str=new StringBuilder(s);
//return n-findInsertions(n,n,s,str.reverse().toString(),dp);
String t=str.reverse().toString();
//if any of the index go out of bound
for(int i=1;i<=n;i++){
for(int j=1;j<=n;j++){
if(s.charAt(i-1)==t.charAt(j-1)){
dp[i][j]=1+dp[i-1][j-1];
}
else {
dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
}
}
}
return n-dp[n][n];
   
    }
}