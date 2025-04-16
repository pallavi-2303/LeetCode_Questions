

class Solution {
class Node {
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
}
public class Trie{
 private Node root;
 Trie() {
 root=new Node();
 }
 public void insert(int num) {
Node node=root;
for(int i=31;i>=0;i--){
//finding the index
int bit=(num>>i)&1;
if(!node.contains(bit)) {
node.put(bit,new Node());
}
node=node.get(bit);
}
 }
 public int findMax(int num) {
 int max=0;
 Node node=root;
 for(int i=31;i>=0;i--){
 int bit=(num>>i)&1;
 //if the opposite bit exist
 if(node.contains(1-bit)) {
 max=max|(1<<i);
 node=node.get(1-bit);
 }
 else {
node=node.get(bit);
 }
 }
 return max;}
}
  public class QueryComparator implements Comparator<List<Integer>> {
@Override
public int compare(List<Integer> a,List<Integer> b) {
return a.get(0).compareTo(b.get(0));
}
}
    public int[] maximizeXor(int[] nums, int[][] queries) {  
Arrays.sort(nums);
int n=nums.length;
List<List<Integer>> query=new ArrayList<>();
int m=queries.length;
Trie trie=new Trie();
//putting all queries in array and making it offline query 
for(int i=0;i<m;i++){
List<Integer> temp=new ArrayList<>();
temp.add(queries[i][1]);
temp.add(queries[i][0]);
temp.add(i);
query.add(temp);
}
//sort the query on basis of first index 
Collections.sort(query,new QueryComparator());
int[] ans=new int[m];
int idx=0;
for(int i=0;i<m;i++){
int num=query.get(i).get(0);
int it=query.get(i).get(1);
while(idx<n && nums[idx]<=num) {
 trie.insert(nums[idx]);
 idx++;
}
int offlineIdx=query.get(i).get(2);
if(idx!=0) {
ans[offlineIdx]=trie.findMax(it);
}
else {
ans[offlineIdx]=-1;
}
}
return ans; 
    }
}