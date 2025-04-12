class Solution {
    public boolean isPallindrome(int i,int j,String s,int[][] dp){
if(i>=j) return true;
if(dp[i][j]!=-1) return dp[i][j]==1 ? true : false;
boolean result=false;
if(s.charAt(i)==s.charAt(j)) {
result=isPallindrome(i+1,j-1,s,dp);
dp[i][j]=result ? 1 :0;
return result;
}
else {
dp[i][j]=0;
return false;}
}
    public String longestPalindrome(String s) {
        int n=s.length();
int[][] dp=new int[n][n];
for(int[] a:dp) 
Arrays.fill(a,-1);
int maxi=0;
int st=-1;
for(int i=0;i<n;i++){
for(int j=i;j<n;j++){
if(isPallindrome(i,j,s,dp)) {
if(j+1-i>maxi){
maxi=j+1-i;
st=i;
}
}
}
}
return s.substring(st,st+maxi);
    }
}