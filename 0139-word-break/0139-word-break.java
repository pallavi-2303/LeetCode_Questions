class Solution {
        int[] dp=new int[301];
    public int find(int idx,String s,HashSet<String> st) {
    int n=s.length();
    if(idx>=n) return 1;
    if(dp[idx]!=-1) return dp[idx];
    if(st.contains(s.substring(idx,n))) {
    return 1;
    }
    //at perticular index we can try to split it in diffrentvsubstring and find wheather it us present in that or not
    for(int j=idx;j<n;j++){
    String str=s.substring(idx,j+1);
    //check whether it is possible to break or not
    if(st.contains(str) && (find(j+1,s,st))==1){
    return dp[idx]=1;
    }
    }

    return dp[idx]=0;
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        HashSet<String> st = new HashSet<>(wordDict);
        //adding all wordlist to st
        Arrays.fill(dp, -1);
        //return find(0, s, st);
        return find(0,s,st)==1 ? true : false;
    }
}