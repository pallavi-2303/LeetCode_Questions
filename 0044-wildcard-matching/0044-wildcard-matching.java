class Solution {
public boolean isAllStar(String s,int i) {
 for(int idx=1;idx<=i;idx++){
  if(s.charAt(idx-1)!='*'){
     return false;} }
    return true;} 
public boolean TabuMatch(String s,String t) {
int n1=s.length();
int n2=t.length();
boolean[][] dp=new boolean[n1+1][n2+1];
//base case
dp[0][0]=true;
for(int j=1;j<=n2;j++)
 dp[0][j]=false;
for(int i=1;i<=n1;i++) {
 dp[i][0]=isAllStar(s,i);}
 
 
    

 
 for(int i=1;i<=n1;i++) {
  for(int j=1;j<=n2;j++) {
 if(s.charAt(i-1)==t.charAt(j-1) || s.charAt(i-1)=='?')
 dp[i][j]=dp[i-1][j-1];
 else {
  if(s.charAt(i-1)=='*')
  dp[i][j]=dp[i-1][j]|| dp[i][j-1];
else dp[i][j]=false;}} }
  return dp[n1][n2];}
public int Match2(int i,int j,String s,String t,int[][] dp){
 if(i==0 && j==0)
    return 1;
if(i==0 && j>0)
  return 0;
  if(j==0 && i>0) {
for(int idx=1;idx<=i;idx++){
  if(s.charAt(idx-1)!='*')
    return 0;}
   return 1;}
 if(dp[i][j]!=-1) 
         return dp[i][j];
 if(s.charAt(i-1)==t.charAt(j-1) || s.charAt(i-1)=='?')
 return dp[i][j]=Match2(i-1,j-1,s,t,dp);
if(s.charAt(i-1)=='*')
 return dp[i][j]=Match2(i-1,j,s,t,dp)==1 || Match2(i,j-1,s,t,dp)==1 ? 1 : 0;
   return dp[i][j]=0;}
public int Match(int i,int j,String s,String t,int[][] dp){
 //base case
 //if both string is exhausted
   if(i<0 && j<0)
      return 1;
 //if i is exhusted and j remain 
 if(i<0 && j>=0)
  return 0;
// if j<0 and i!=0;
 if(i>=0 && j<0){
for(int idx=0;idx<=i;idx++) {
 if(s.charAt(idx)!='*')
     return 0;}
 return 1;}
if(dp[i][j]!=-1) return dp[i][j];
//if charcter mateched or ? is present at i it can match with 1 charcter
 if(s.charAt(i)==t.charAt(j) || s.charAt(i)=='?')
 return dp[i][j]=Match(i-1,j-1,s,t,dp);
//if character at i is * one time we treat it as empty and another time as remover charcter
if(s.charAt(i)=='*')
 return dp[i][j]=(Match(i-1,j,s,t,dp)==1) || (Match(i,j-1,s,t,dp)==1) ? 1 :0;
 //no one matched return false
 return 0;}
    public boolean isMatch(String s, String p) {
int n1=p.length();
int n2=s.length();
int[][] dp=new int[n1+1][n2+1];
// for(int[] a:dp)
  //Arrays.fill(a,-1);
 //return Match(n1-1,n2-1,p,s,dp)==1 ? true : false;
  //return Match2(n1,n2,p,s,dp)==1 ? true : false;   
  return TabuMatch(p,s);
    }
}