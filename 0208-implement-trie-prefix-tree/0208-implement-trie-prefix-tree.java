public class Node {
 Node[] links=new Node[26];
 boolean flag=false;
 public boolean contains(char ch){
 return links[ch-'a']!=null;
 }
 public void put(char ch,Node node){
links[ch-'a']=node;
 }
 public boolean eow() {
 return flag;
 }
 public void setEOW() {
 flag=true;
 }
 public Node get(char ch){
 return links[ch-'a'];
 }
}

class Trie {
private static Node root;
    public Trie() {
      root=new Node() ; 
    }
    
    public void insert(String word) {
        //insert word function
Node node=root;
for(int i=0;i<word.length();i++){
 if(!node.contains(word.charAt(i))){
 node.put(word.charAt(i),new Node());
 }   
 node=node.get(word.charAt(i));
}
node.setEOW();
    }
    
    public boolean search(String word) {
      //search a word
Node node=root;
int n=word.length();
for(int i=0;i<n;i++){
if(!node.contains(word.charAt(i))) {
 return false;
}
node=node.get(word.charAt(i));
}
return node.eow();  
    }
    
    public boolean startsWith(String prefix) {
        //prefix search
Node node=root;
for(int i=0;i<prefix.length();i++){
if(!node.contains(prefix.charAt(i))){
 return false;
}
node=node.get(prefix.charAt(i));
}
return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */