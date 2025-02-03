class Solution {
    public int findSub(int idx1,int idx2,String s,String t,int[][] dp) {
 if(idx1==0 || idx2==0)
 return 0;
 if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
 //if character matches
 if(s.charAt(idx1-1)==t.charAt(idx2-1))
 return 1+findSub(idx1-1,idx2-1,s,t,dp);
 else return Math.max(findSub(idx1-1,idx2,s,t,dp),findSub(idx1,idx2-1,s,t,dp));}
    public int minDistance(String s, String t) {
     int n=s.length();
     int m=t.length();
int[][] dp=new int[n+1][m+1];
//we will keep the longest palindromic portion enact 
// for(int[] a:dp)
// Arrays.fill(a,-1);
// return (m+n)-2*findSub(n,m,s,t,dp); 
  int[] curr=new int[m+1];
int[] prev=new int[m+1];
for(int i=0;i<=n;i++){
    dp[i][0]=0;
    prev[0]=0;
}
for(int j=0;j<=m;j++){
    dp[0][j]=0;
    prev[j]=0;
}
for(int i=1;i<=n;i++){
for(int j=1;j<=m;j++){
if(s.charAt(i-1)==t.charAt(j-1))
//dp[i][j]=1+dp[i-1][j-1];
curr[j]=1+prev[j-1];
else
//dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
curr[j]=Math.max(curr[j-1],prev[j]);
}
prev=curr.clone();
}
//return dp[n][n];
return (n+m)-2*prev[m];
      
      
    }
}