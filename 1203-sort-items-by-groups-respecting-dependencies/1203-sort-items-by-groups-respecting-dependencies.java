class Solution {
    public List<Integer> topoSort(List<List<Integer>> adj,int[] indegre){
    Queue<Integer> q=new LinkedList<>();
   int count=0;
   int n=adj.size();
   List<Integer> ans=new ArrayList<>();
   for(int i=0;i<n;i++){
if(indegre[i]==0){
q.add(i);
}
   }
while(!q.isEmpty()){
int node=q.poll();
count++;
ans.add(node);
for(int it:adj.get(node)){
indegre[it]--;
if(indegre[it]==0){
q.add(it);
}
}
} 
return count==n ? ans :new ArrayList<>(); 
    }

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        List<List<Integer>> adjItem = new ArrayList<>();
        List<List<Integer>> adjGroup = new ArrayList<>();
        //first assiging grouos to atoms which doesn't have any group
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        for (int i = 0; i < n; i++) {
            adjItem.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adjGroup.add(new ArrayList<>());
        }
        int[] indegreItem = new int[n];
        int[] indegreGroup = new int[m];
        //making of graphs
        for (int i = 0; i < n; i++) {
            if (beforeItems.get(i).size() > 0) {
                for (int prevItem : beforeItems.get(i)) {
                    adjItem.get(prevItem).add(i);//prevItem---> i
                    indegreItem[i]++;
                    int currGroup = group[i];
                    int prevGroup = group[prevItem];
                    //the group of prev item should cpme before curr item group
                if(currGroup!=prevGroup){
                    adjGroup.get(prevGroup).add(currGroup);
                    indegreGroup[currGroup]++;
                }
            }
        }
        }
        //perform the topo sort to find the correct order of item and group
        List<Integer> itemOrder = topoSort(adjItem, indegreItem);
        List<Integer> groupOrder = topoSort(adjGroup, indegreGroup);
    //find all group to item order
List<List<Integer>> itemToGroup=new ArrayList<>();
for(int i=0;i<m;i++){
 itemToGroup.add(new ArrayList<>());  
}
//iterate on item and put it in corresponding group
for(int item:itemOrder){
int groupNo=group[item];
itemToGroup.get(groupNo).add(item);
}
List<Integer> res=new ArrayList<>();
for(int groupIdx:groupOrder){
res.addAll(itemToGroup.get(groupIdx));
}
return res.stream().mapToInt(Integer::intValue).toArray();


    }
}