class Solution {
 public int lcs(int i,int j,String s,String t,int[][] dp){
if(i==0 || j==0)
  return 0;
 if(dp[i][j]!=-1)
    return dp[i][j];
if(s.charAt(i-1)==t.charAt(j-1))
 return dp[i][j]=1+lcs(i-1,j-1,s,t,dp);
else
 return dp[i][j]=Math.max(lcs(i-1,j,s,t,dp),lcs(i,j-1,s,t,dp));}
    public int longestPalindromeSubseq(String s) {
StringBuilder st=new StringBuilder(s);
st.reverse();
String t=st+"";
int n=s.length();
//int[][] dp=new int[n+1][n+1];
int[] prev=new int[n+1];
int[] curr=new int[n+1];
/*for(int[] a:dp)
  Arrays.fill(a,-1);
  return lcs(n,n,s,t,dp);*/
for(int i=0;i<=n;i++) //dp[i][0]=0;
 prev[0]=0;
for(int j=0;j<=n;j++)
   //dp[0][j]=0;
  prev[j]=0;
for(int i=1;i<=n;i++) {
for(int j=1;j<=n;j++) {
if(s.charAt(i-1)==t.charAt(j-1))
 //dp[i][j]=1+dp[i-1][j-1];
  curr[j]=1+prev[j-1];
else
//dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);}}
 curr[j]=Math.max(prev[j],curr[j-1]);}
  prev=curr.clone();}
       // return dp[n][n];
     return prev[n];
        
    }
}