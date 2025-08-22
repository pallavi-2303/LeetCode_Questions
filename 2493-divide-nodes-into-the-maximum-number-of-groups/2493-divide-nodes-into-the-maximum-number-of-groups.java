class Solution {
    public int findMax(int node, int[] level, List<List<Integer>> adj, int[] vis) {
        vis[node] = 1;
        int maxi = level[node];
        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                maxi = Math.max(maxi, findMax(it, level, adj, vis));
            }

        }
        return maxi;
    }

    public int bfs(int root, List<List<Integer>> adj) {
        int n = adj.size();
        int[] vis = new int[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(root);
        vis[root] = 1;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int node = q.poll();
                for (int it : adj.get(node)) {
                    if (vis[it] == 0) {
                        vis[it] = 1;
                        q.add(it);
                    }
                }
                size--;
            }
            level++;
        }
        return level;
    }

    public boolean isBipatite(int node, int currColor, int[] color, List<List<Integer>> adj) {
        color[node] = currColor;
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (isBipatite(it, 1 - currColor, color, adj) == false) {
                    return false;
                }
            } else if (color[it] == color[node]) {
                return false;
            }
        }
        return true;
    }

    public int magnificentSets(int n, int[][] edges) {
        //it is only possible to devide into groups if they are bipatite groupd
        //its never possible to devide the nodes that arenot biapatrte
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] a : edges) {
            int u = a[0] - 1;
            int v = a[1] - 1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        //we can put all the neighbours of a node in one groupd so that the consditon which given is valid
        int[] color = new int[n];
        Arrays.fill(color, -1);
        //check for bipatite condition
        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (isBipatite(i, 0, color, adj) == false) {
                    return -1;//not possible to deivide into groups
                }
            }
        }
        //coloring the graph with level order traversal
        //try level order with every node and store level after traversal with every node
        int[] level = new int[n];
        for (int i = 0; i < n; i++) {
            level[i] = bfs(i, adj);
        }
        //since there graph can be disconnected so  to find max coor of evry compoent 
        int maxColor=0;
        int[] vis = new int[n];
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                maxColor += findMax(i, level, adj, vis);
            }
        }
        return maxColor;

    }

}