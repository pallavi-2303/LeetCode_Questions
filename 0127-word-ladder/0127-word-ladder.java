class Solution {
    public class pair{
String word;
int steps;
pair(String word,int steps){
this.word=word;
this.steps=steps;
}
}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     HashSet<String> st=new HashSet<>(wordList);
Queue<pair> q=new LinkedList<>();
q.add(new pair(beginWord,1));
st.remove(beginWord);
//Number of word in wordList
//Size of wordList*26*(size of longest word);
while(!q.isEmpty()){
pair it=q.poll();
String word=it.word;
int steps=it.steps;
if(word.equals(endWord)){
return steps;
}
//Change avery character of word from a to z
for(int i=0;i<word.length();i++){
char[] arr=word.toCharArray();
//Change every character from a to z
for(char ch='a';ch<='z';ch++){
arr[i]=ch;
String newWord=new String(arr);
if(st.contains(newWord)){
q.add(new pair(newWord,steps+1));
st.remove(newWord);
}
}
}
}
return 0;//if answer is not found   
    }
}