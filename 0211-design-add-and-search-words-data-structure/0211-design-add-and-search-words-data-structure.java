class Node{
Node[] links=new Node[26];
boolean flag=false;
public boolean contains(char ch){
return links[ch-'a']!=null;
}
public void put(char ch,Node node){
links[ch-'a']=node;
}
public boolean eow(){
return flag;
}
public void seteow(){
flag=true;
}
public Node get(char ch){
return links[ch-'a'];
}
}

class WordDictionary {
 private Node root;
    public WordDictionary() {
      root=new Node();  
    }
    
    public void addWord(String word) {
     Node node=root;
     int n=word.length();
     for(int i=0;i<n;i++){
    char ch=word.charAt(i);
    if(!node.contains(ch)){
    node.put(ch,new Node());
    }
    node=node.get(ch);
     } 
     node.seteow();  
    }
    public boolean dfs(int idx,Node node,String word){
    //base case
    if(idx==word.length()) 
    return node.eow();
    char ch=word.charAt(idx);
    if(ch=='.'){
    for(char c='a';c<='z';c++){
   Node next=node.get(c);
   if(next!=null && dfs(idx+1,next,word)) 
   return true;
    }
    return false;
    }
    else {
   if(!node.contains(ch)) return false;
   return dfs(idx+1,node.get(ch),word);
    }

    }
    public boolean search(String word) {
    return dfs(0,root,word);    
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */