class Solution {
public:
    string longestPalindrome(string s) {
        int n=s.size();



vector<vector<int>>dp(n,vector<int>(n,0));











string ans;



int max=0;





 for(int dif=0; dif<n; dif++) {

 for(int i=0,j=i+dif;j<n;i++,j++) {


if(i==j) {
dp[i][j]=1;} 



else if(dif==1) {



dp[i][j]=(s[i]==s[j])?2:0;}



 else {



if(s[i]==s[j] && dp[i+1][j-1]) {



dp[i][j]=dp[i+1][j-1]+2;}



}



if(dp[i][j]) {



if(j-i+1>max) {



max=j-i+1;



ans=s.substr(i,max);

}}}}



return ans;


    }
};