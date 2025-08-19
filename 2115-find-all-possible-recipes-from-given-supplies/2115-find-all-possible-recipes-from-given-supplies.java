class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
    //since one recipe can only be made if we have ingrideients for that means the particular recipie is dependent maens recipi->i will be a directed edge
    int n=recipes.length;
    List<String> res=new ArrayList<>();
    HashSet<String> present=new HashSet<>();
    for(String st:supplies) {
    present.add(st);
    } 
HashMap<String,List<Integer>> adj=new HashMap<>(); 
int[] indegre=new int[n];
for(int i=0;i<n;i++){
for(String ingri:ingredients.get(i)){
if(!present.contains(ingri)){
//this ith node is depent on this ingri
indegre[i]++;
adj.putIfAbsent(ingri,new ArrayList<>());
adj.get(ingri).add(i);//edge grom ingri --> i
}
}
}
Queue<Integer> q=new LinkedList<>();
for(int i=0;i<n;i++){
if(indegre[i]==0){
    //this is not indepent and it an be made 
q.add(i);
}
}
while(!q.isEmpty()){
int i=q.poll();
res.add(recipes[i]);
if(adj.containsKey(recipes[i])){
for(int it:adj.get(recipes[i])){
indegre[it]--;
if(indegre[it]==0){
q.add(it);
}
}
}
}
return res;
    }
}