class Solution {
    public static class DisjointSet{
List<Integer> parent=new ArrayList<>();
List<Integer> size=new ArrayList<>();
List<Integer> rank=new ArrayList<>();
public DisjointSet(int n){
for(int i=0;i<=n;i++){
parent.add(i);
size.add(1);
rank.add(0);
}
}
public int findUlPar(int node){
if(node==parent.get(node))
return node;
int ulp=findUlPar(parent.get(node));
parent.set(node,ulp);
return parent.get(node);
}
public void unionByRank(int u,int v) {
int ulp_u=findUlPar(u);
int ulp_v=findUlPar(v);
if(ulp_u==ulp_v) return;
if(rank.get(ulp_u)<rank.get(ulp_v)){
 parent.set(ulp_u,ulp_v);
}
else if(rank.get(ulp_u)>rank.get(ulp_v)) {
  parent.set(ulp_v,ulp_u);
}
else {
parent.set(ulp_v,ulp_u);
rank.set(ulp_u,rank.get(ulp_u)+1);
}
}
public void unionBySize(int u,int v){
int ulp_u=findUlPar(u);
int ulp_v=findUlPar(v);
if(ulp_u==ulp_v) return;
if(size.get(ulp_u)<size.get(ulp_v)){
 parent.set(ulp_u,ulp_v);
 size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
}
else {
parent.set(ulp_v,ulp_u);
size.set(ulp_u,size.get(ulp_u)+size.get(ulp_v));
}
}
}
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n=accounts.size();
 DisjointSet ds=new DisjointSet(n);
 //creating mapmailNode of hashmap to store email and node as name
 HashMap<String,Integer> mapMailNode=new HashMap<>();
 //pitting all mail in hashmap and coonevting the nodes which are alredy present 
 for(int i=0;i<n;i++){
for(int j=1;j<accounts.get(i).size();j++){
String mail=accounts.get(i).get(j);
if(!mapMailNode.containsKey(mail)){
mapMailNode.put(mail,i);
}
else {
//if this mail is already present
ds.unionBySize(i,mapMailNode.get(mail));
}}}
//step->2 putting all nodes in array of arraylist by finding ultimate parent of values
ArrayList<String>[] mailMerge=new ArrayList [n];
for(int i=0;i<n;i++){
 mailMerge[i]=new ArrayList<>();
}
//Traversing in HashMap and putting in mailMerge
for(Map.Entry<String,Integer> it:mapMailNode.entrySet()){
String mail=it.getKey();
int node=ds.findUlPar(it.getValue());
mailMerge[node].add(mail);
}
//putting all mails in Arraylist
List<List<String>> ans=new ArrayList<>();
for(int i=0;i<n;i++){
List<String> temp=new ArrayList<>();
if(mailMerge[i].size()==0) continue;
Collections.sort(mailMerge[i]);
temp.add(accounts.get(i).get(0));
for(String it:mailMerge[i]) {
temp.add(it);
}
ans.add(temp);
}
return ans; 
    }
}