class Solution {
        public boolean isPossible(String s,String t){
int count=0;
for(int i=0;i<s.length();i++){
if(s.charAt(i)!=t.charAt(i)) {
count++;
}
if(count>1) return false;
}
return count==1;
}
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
int n=groups.length;
int[] dp=new int[n];
int[] parent=new int[n];
Arrays.fill(dp,1);
//since we have yo find longest subsequence based on certain condition 
int longestIncSub=0;
int longestIncIdx=0;
parent[0]=0;
for(int i=1;i<n;i++){
parent[i]=i;
for(int j=0;j<i;j++){
if(groups[j]!=groups[i] && words[i].length()==words[j].length() && isPossible(words[i],words[j])){
if(dp[j]+1>dp[i]) {
dp[i]=dp[j]+1;
parent[i]=j;
if(dp[i]>longestIncSub) {
longestIncSub=dp[i];
longestIncIdx=i;
}
}
}
}}
List<String> res=new ArrayList<>();
while(longestIncIdx!=parent[longestIncIdx]){
res.add(words[longestIncIdx]);
longestIncIdx=parent[longestIncIdx];
}
res.add(words[longestIncIdx]);
Collections.reverse(res);
return res; 
    }
}