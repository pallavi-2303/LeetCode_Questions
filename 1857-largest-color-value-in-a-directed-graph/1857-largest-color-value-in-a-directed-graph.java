class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        //since we have to find the largest color value along any path we will use topological sort
        int n = colors.length();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] indegre = new int[n];
        for (int[] a : edges) {
            int u = a[0];
            int v = a[1];
            adj.get(u).add(v);
            indegre[v]++;//the indegre of the node increases;
        }
        //we will also use a matrix to store node and all the maximum  colors to particular node  and we use 0 index integer to represent colors;
        int[][] t = new int[n][26];
        //putting nodes whose indegre is 0 and storing itts colors
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegre[i] == 0) {
                //add to queue whose indegre is 0 and from which a path start
                q.add(i);
                t[i][colors.charAt(i) - 'a'] = 1;
            }
        }
        int maxi = 0;
        int count = 0;
        //performing the topologicalsort
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            //going to their neighbour
            maxi = Math.max(maxi, t[node][colors.charAt(node) - 'a']);
            //going to its neighbours
            for (int it : adj.get(node)) {
                //reaching to a node the max number of colors to any node will be same as reaching to u but colors of v will also be added to that node colors
                // at v from u->v reaching
                for (int c = 0; c < 26; c++) {
                    //node u pe is color ki value kya h
                    int val = t[node][c] + (colors.charAt(it)-'a' == c ? 1 : 0);
                    t[it][c] = Math.max(t[it][c], val);
                }
                indegre[it]--;
                if (indegre[it] == 0) {
                    q.add(it);
                }
            }
        }
        return count < n ? -1 : maxi;

    }
}