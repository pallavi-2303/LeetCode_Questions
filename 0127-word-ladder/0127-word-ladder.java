class Solution {
public class pair {
 String first;
 int second;
   public pair(String first,int second) {
  this.first=first;
   this.second=second;}}
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
  Queue<pair> q=new LinkedList<>();
HashSet<String> st=new HashSet<>();
int n=wordList.size();
 for(int i=0;i<n;i++) {
    st.add(wordList.get(i));}
 st.remove(beginWord);
 q.add(new pair(beginWord,1));
   //petforming bfs to Find number of steps to reach end
  while(!q.isEmpty()) {
   pair it=q.poll();
  String word=it.first;
   int steps=it.second;
 //check if target word is equal to end word 
   if(word.equals(endWord)==true){ 
           return steps;}
 //perform to steps and change the word
  for(int i=0;i<word.length();i++){
//for every letter change from a to z
 for(char ch='a';ch<='z';ch++) {
 char[] wordArray=word.toCharArray();
 wordArray[i]=ch;
String changedWord=new String(wordArray);
 if(st.contains(changedWord)) {
   st.remove(changedWord);
    q.add(new pair(changedWord,steps+1));}
         }
          } }
            return 0;
           
    }
}