class Solution {
    public int find(int i,int j,String s,String t,int[][] dp){
if(i==0 || j==0) return 0;
if(dp[i][j]!=-1) return dp[i][j];
//if character match and notmatch
if(s.charAt(i-1)==t.charAt(j-1)){
return dp[i][j]=1+find(i-1,j-1,s,t,dp);}
else 
return dp[i][j]=Math.max(find(i-1,j,s,t,dp),find(i,j-1,s,t,dp));}
    public int longestCommonSubsequence(String text1, String text2) {
   int n1=text1.length();
int n2=text2.length();
 //int[][] dp=new int[n1+1][n2+1];
 int[] curr=new int[n2+1];
 int[] prev=new int[n2+1];
// for(int[] a:dp) Arrays.fill(a,-1);
// return find(n1,n2, text1,text2,dp);
for(int i=1;i<=n1;i++){
for(int j=1;j<=n2;j++){
if(text1.charAt(i-1)==text2.charAt(j-1)){
// dp[i][j]=1+dp[i-1][j-1];}
curr[j]=1+prev[j-1];}
else {
// dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);}}}
curr[j]=Math.max(prev[j],curr[j-1]);}}
prev=curr.clone();}
return prev[n2];
    }
}