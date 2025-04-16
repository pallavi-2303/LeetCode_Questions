class Solution {
//first we will initilasise the trie data structure
class Node{
    Node[] links;
    boolean end;
    public Node(){
        links=new Node[2];
        end=false;
    }
    public boolean contains(int idx){
   return links[idx]!=null;
    }
    public Node get(int idx){
        return links[idx];
    }
    public void put(int idx,Node node){
    links[idx]=node;
    }
    public void setEnd(){
        end=true;
    }

}
class Trie{
private Node root;
public Trie(){
    root=new Node();
}
public void insert(int num){
Node node=root;
//we will start to insert from the 31st bit to increase the maximum as left to right
for(int i=31;i>=0;i--){
//finding the bit index if it is set it will go to 1 else 0
int bit=(num>>i) & 1;
if(!node.contains(bit)){
node.put(bit,new Node());
}
//get the reference node
node=node.get(bit);
}
}
public int maxValue(int num){
//we have to fing the maximum value we get from array with this number
int max=0;
Node node=root;
for(int i=31;i>=0;i--){
int bit=(num>>i) & 1;
//if the opposite bit is present we can do xor with it to make it omne
if(node.contains(1-bit)){
//make maxi 1
max=max | (1<<i);
node=node.get(1-bit);
}
else {
    //if no number exist with opposite digit
node=node.get(bit);
}
}
return max;
}
}
    public int findMaximumXOR(int[] nums) {
     Trie trie=new Trie();
     for(int it:nums)  trie.insert(it);
     int max=-1;
     for(int it:nums) {
        max=Math.max(max,trie.maxValue(it));
     }
     return max;
    }
}