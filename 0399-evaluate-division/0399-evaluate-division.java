class Solution {
public class pair{
String key;
double value;
pair(String key,double value){
this.key=key;
this.value=value;
}
}
public void dfs(String src,String des,HashMap<String,List<pair>> adj,double[] ans,double pro,HashSet<String> vis){
//if it is allready visisted in ths path
if(vis.contains(src)) return;
//mark  it visited
vis.add(src);
//if src is qrual to des
if(src.equals(des)){
ans[0]=pro;
return;
}
//dfs call
for(pair it:adj.get(src)){
String nei=it.key;
double val=it.value;
dfs(nei,des,adj,ans,pro*val,vis);
}
}
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
// a/b and b/c then we get a/c by a/b*b/c
//first we need map to store string and  its adjacent string and value
HashMap<String,List<pair>> adj=new HashMap<>();
int n=equations.size();
for(int i=0;i<n;i++){
String u=equations.get(i).get(0);
String v=equations.get(i).get(1);
double val=values[i];
adj.putIfAbsent(u,new ArrayList<>());
adj.putIfAbsent(v,new ArrayList<>());
//add both u and v and its  value
adj.get(u).add(new pair(v,val));
adj.get(v).add(new pair(u,1.0/val));
}
//Traversing the queries and finding the anser if src and destination if present
int m=queries.size();
double[] result=new double[m];
for(int i=0;i<m;i++){
double[] ans={-1.0};
double pro=1;
String src=queries.get(i).get(0);
String des=queries.get(i).get(1);
if(adj.containsKey(src)){
HashSet<String> vis=new HashSet<>();
dfs(src,des,adj,ans,pro,vis);
}
result[i]=ans[0];
}
return result;

    }
}