class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
    List<Integer> ans=new ArrayList<>();
    for(int i=0;i<words.length;i++) {
    if(words[i].chars().anyMatch(ch->ch==x)){
    ans.add(i);
    }
    }   
    return ans;
    }
}