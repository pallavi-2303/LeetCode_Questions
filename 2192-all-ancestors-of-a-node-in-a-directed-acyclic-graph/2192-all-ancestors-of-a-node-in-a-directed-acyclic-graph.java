class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        //we can only calulate a node ancestor if it previous ancestor are calculated so we can use a topo sort order of nodes
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegre = new int[n];
        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            adj.get(u).add(v);
            indegre[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegre[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
          topo.add(node);
            for (int it : adj.get(node)) {
                indegre[it]--;
                if (indegre[it] == 0) {
                    q.add(it);
                }
            }
        }
        //since topo sort contains elements in sorted array so if  ancestor of node is required it will be filled previously
List<Set<Integer>> res=new ArrayList<>();
for(int i=0;i<n;i++) 
res.add(new HashSet<>());
for(int node:topo){
for(int v:adj.get(node)){
res.get(v).add(node);//adding the current ancestor 
//adding all ancestor of node also as node ancestor will also ve ancestor of v
res.get(v).addAll(res.get(node));//all ancesttor of node
}
}
 // Step 3: convert to sorted lists
        List<List<Integer>> ans = new ArrayList<>();
         for (int i = 0; i < n; i++) {
            List<Integer> temp=new ArrayList<>(res.get(i));
            Collections.sort(temp);
            ans.add(temp);
        }

    return ans;

    }
}