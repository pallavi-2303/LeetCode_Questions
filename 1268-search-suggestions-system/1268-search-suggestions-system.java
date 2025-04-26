class Solution {
    public class Node {
Node[] links=new Node[26];
boolean eow=false;
public boolean containsKey(char ch){
return links[ch-'a']!=null;}
public void put(char ch,Node node){
links[ch-'a']=node;}
public Node get(char ch){
return links[ch-'a'];}
public void seteow(){
eow=true;}
public boolean eow(){
return eow;}}
public class Trie{
Node root;
Trie(){
root=new Node();}
public void insert(String word){
Node node=root;
for(char ch:word.toCharArray()){
if(!node.containsKey(ch)){
node.put(ch,new Node());}
node=node.get(ch);}
node.seteow();}
public List<String> searchWord(String prefix) {
Node node=root;
List<String> res=new ArrayList<>();
//first we will check wheather this string exist or not
for(char ch:prefix.toCharArray()) {
if(!node.containsKey(ch)) {
return res;
}
node=node.get(ch);
}
//this dfs call give threee sorted lexicographically sorted words
dfs(node,prefix,res);
return res;
}
public void dfs(Node node,String path,List<String> res){
if(res.size()>=3) return;
if(node.eow()){
res.add(path);
}
//try out dfs for all character
for(char ch='a';ch<='z';ch++){
if(node.containsKey(ch)) {
dfs(node.get(ch),path+ch,res);
}
}
}
}
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
     //this makes sure that we get lexicographically sorted string
Arrays.sort(products);
Trie trie=new Trie();
for(String pro:products){
trie.insert(pro);
}
List<List<String>> res=new ArrayList<>();
StringBuilder str=new StringBuilder();
for(char ch:searchWord.toCharArray()){
str.append(ch);
res.add(trie.searchWord(str.toString()));
}
return res;   
    }
}