class Node{
Node[] links=new Node[26];
boolean flag=false;
public boolean contains(char ch){
return links[ch-'a']!=null;
}
public void put(char ch,Node node){
links[ch-'a']=node;
}
public void seteow(){
flag=true;
}
public boolean eow(){
return flag;
}
public Node get(char ch){
return links[ch-'a'];
}
}
class Trie{
private Node root;
Trie(){
root=new Node();
}
public void insert(String word){
int n=word.length();
Node node=root;
for(int i=0;i<n;i++){
char ch=word.charAt(i);
if(!node.contains(ch)){
node.put(ch,new Node());
}
node=node.get(ch);
}
node.seteow();
}
public Node getroot(){
return root;
}
}

class Solution {
    public void dfs(int i,int j,char[][] board,Node node,String curr,HashSet<String> st,int[] dr,int[] dc) {
//base case 
int n=board.length;
int m=board[0].length;
if(i<0 || j<0 || i>=n || j>=m ||
board[i][j]=='#'){
return;
}
char ch=board[i][j];
//if it is not present in current node
if(!node.contains(ch)) return;
curr=curr+ch;
node=node.get(ch);
if(node.eow()){
st.add(curr);
}
//start the traversal mark it visited 
board[i][j]='#';
//try all combination
for(int idx=0;idx<4;idx++){
int nrow=i+dr[idx];
int ncol=j+dc[idx];
dfs(nrow,ncol,board,node,curr,st,dr,dc);
}
//after completing dfs for current backtrack
board[i][j]=ch;
}
    public List<String> findWords(char[][] board, String[] words) {
      Trie trie=new Trie();
HashSet<String> st=new HashSet();
for(String str:words) {
trie.insert(str);
}
//we will call the dfs for every i and j
int n=board.length;
int m=board[0].length;
int[] dr={-1,1,0,0};
int[] dc={0,0,-1,1};
for(int i=0;i<n;i++){
for(int j=0;j<m;j++){
dfs(i,j,board,trie.getroot(),"",st,dr,dc);
}
}
return new ArrayList<>(st);  
    }
}