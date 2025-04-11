class Solution {
    public boolean find(int i,int j,int k,String s1,String s2,String s3,int[][][] dp){
int n=s1.length();
int m=s2.length();
int l=s3.length();
if(i>=n && j>=m && k>=l){
return true;}
if(k>=l) 
//If it is formed only with one string
return false;
if(dp[i][j][k]!=-1) return dp[i][j][k]==0 ?false : true ;
boolean result=false;
if(i<n && s1.charAt(i)==s3.charAt(k))
result=find(i+1,j,k+1,s1,s2,s3,dp);
if(result) return true;
if(j<m && s2.charAt(j)==s3.charAt(k))
result=find(i,j+1,k+1,s1,s2,s3,dp);
dp[i][j][k]=result ? 1 :0;
return result;} 
    public boolean isInterleave(String s1, String s2, String s3) {
      int[][][] dp=new int[101][101][201];
if(s1.length()+s2.length()!=s3.length())
return false;
for(int i=0;i<101;i++){
for(int j=0;j<101;j++){
for(int k=0;k<201;k++){
dp[i][j][k]=-1;}}}
return find(0,0,0,s1,s2,s3,dp);  
    }
}