class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
    List<String> ans=new ArrayList<>();
    int n=words.length;
    ans.add(words[0]);
    for(int i=1;i<n;i++){
    if(groups[i]!=groups[i-1]){
    ans.add(words[i]);
    }
    }   
    return ans; 
    }
}