public class pair {
    int node;
    int cost;

    public pair(int node, int cost) {
        this.node =node;
        this.cost = cost;
    }
}

class Graph {
    int n;
    List<List<pair>> adj;
    PriorityQueue<pair> pq;

    public Graph(int n, int[][] edges) {
        this.n = n;
        adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            int wt = a[2];
            adj.get(u).add(new pair(v, wt));
        }
    }

    public void addEdge(int[] edge) {
        //add edge 
        int u = edge[0];
        int v = edge[1];
        int cost = edge[2];
        adj.get(u).add(new pair(v, cost));
    }

    public int shortestPath(int node1, int node2) {
        pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[node1] = 0;
        pq.add(new pair(node1, 0));
        while (!pq.isEmpty()) {
            pair it = pq.poll();//this will give shortest distance to reach a reach to u
            int node = it.node;
            for (pair pt : adj.get(node)) {
                //If the cost to reach its neighbours is less than previous cost update it 
                int adjnode = pt.node;
                int cost = pt.cost;
                if (result[node] + cost < result[adjnode]) {
                    result[adjnode] = result[node] + cost;
                    pq.add(new pair(adjnode, result[adjnode]));
                }
            }
        }
        return result[node2] == Integer.MAX_VALUE ? -1 : result[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */