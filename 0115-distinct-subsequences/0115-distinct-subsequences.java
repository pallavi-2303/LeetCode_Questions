class Solution {
public int disSubs(int i,int j,String s,String t,int[][] dp){
//if(j<0) return 1;
//if(i<0) return 0;
if(j==0) return 1;
if(i==0) return 0;
 if(dp[i][j]!=-1) 
   return dp[i][j];
//if character matches
 if(s.charAt(i-1)==t.charAt(j-1))
 return dp[i][j]=disSubs(i-1,j-1,s,t,dp)+disSubs(i-1,j,s,t,dp);
else return dp[i][j]=disSubs(i-1,j,s,t,dp);}
    public int numDistinct(String s, String t) {
int n1=s.length();
int n2=t.length();
int[][] dp=new int[n1+1][n2+1];
 //for(int[] a:dp) Arrays.fill(a,-1);
//Shifting the indexes
//return disSubs(n1-1,n2-1,s,t,dp);
//return disSubs(n1,n2,s,t,dp);
 //base case
int[] prev=new int[n2+1];
int[] curr=new int[n2+1];
for(int j=0;j<=n2;j++)
// dp[0][j]=0;
 prev[j]=0;
for(int i=0;i<=n1;i++)
//dp[i][0]=1;
 prev[0]=1;
for(int i=1;i<=n1;i++) {
 curr[0]=1;
for(int j=1;j<=n2;j++) {
if(s.charAt(i-1)==t.charAt(j-1))
 //match with another character of given j
 curr[j]=prev[j-1]+prev[j];
//dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
//else dp[i][j]=dp[i-1][j];}}
else curr[j]=prev[j];}
 prev=curr.clone();}
 //return dp[n1][n2];
   return prev[n2];
    }
}