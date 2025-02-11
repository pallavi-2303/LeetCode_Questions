class Solution {
    class Node {
Node[] links=new Node[2];
public boolean containsKey(int idx) {
 return links[idx]!=null;
}
public void put(int idx,Node node){
links[idx]=node;
}
public Node get(int idx) {
return links[idx];
}
}
    public class Trie{
 Node root;
 Trie() {
 root=new Node();
 }
 public void insert(int num) {
 Node node=root;
 for(int i=31;i>=0;i--) {
//ith bit of number
int bit=(num>>i)&1;
if(!node.containsKey(bit)) {
 node.put(bit,new Node());
}
node=node.get(bit);}}
public int findmax(int num) {
Node node=root;
int maxi=0;
for(int i=31;i>=0;i--) {
int bit=(num>>i)&1;
if(node.containsKey(1-bit)) {
//set maxi to 1
maxi=(maxi|(1<<i));
node=node.get(1-bit);}
else {
 node=node.get(bit);} }
 return maxi;} 
  }
    public int findMaximumXOR(int[] nums) {

Trie trie=new Trie();
for(int it:nums) {
 trie.insert(it);}
int maxi=0;
 for(int it:nums) {
 maxi=Math.max(maxi,trie.findmax(it));}
    return maxi;

        
    }
}