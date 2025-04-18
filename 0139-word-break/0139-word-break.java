class Solution {
    public int findWord(int idx,String s,int[] dp, HashSet<String> st) {
if(idx==s.length()) {
//the string is exhausted and it is found
return 1;
}
if(st.contains(s)) return 1;
if(dp[idx]!=-1) return dp[idx];
for(int len=1;len+idx<=s.length();len++){
if(st.contains(s.substring(idx,idx+len)) && (findWord(idx+len,s,dp,st))==1) {
return dp[idx]=1;
}
}
return dp[idx]=0;//if the loop break and answer not found 
}
    public boolean wordBreak(String s, List<String> wordDict) {
    
HashSet<String> st=new HashSet<>();
for(String str:wordDict){
st.add(str);
}
int[] dp=new int[s.length()];
Arrays.fill(dp,-1);
return findWord(0,s,dp,st)==1 ? true : false;   
    }
}