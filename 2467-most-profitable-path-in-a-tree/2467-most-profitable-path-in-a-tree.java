class Solution {
    private boolean findBobPath(List<Integer>[] tree, int curr, int target, int parent, int time, int[] bobTime, Map<Integer, Integer> bobPath) {
        if (curr == target) {
            bobTime[curr] = time;
            bobPath.put(curr, time);
            return true;
        }
        for (int neighbor : tree[curr]) {
            if (neighbor == parent) continue;
            if (findBobPath(tree, neighbor, target, curr, time + 1, bobTime, bobPath)) {
                bobTime[curr] = time;
                bobPath.put(curr, time);
                return true;
            }
        }
        return false;
    }
    private int dfs(List<Integer>[] tree, int node, int parent, int time, int currProfit, int[] bobTime, int[] amount) {
        if (time < bobTime[node]) {
            currProfit += amount[node];  // Alice alone collects the amount
        } else if (time == bobTime[node]) {
            currProfit += amount[node] / 2;  // Alice and Bob share the amount
        }

        int maxProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;

        for (int neighbor : tree[node]) {
            if (neighbor == parent) continue;
            isLeaf = false;
            maxProfit = Math.max(maxProfit, dfs(tree, neighbor, node, time + 1, currProfit, bobTime, amount));
        }

        return isLeaf ? currProfit : maxProfit;
    }
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
      int n = amount.length;
        List<Integer>[] tree = new ArrayList[n];
        
        // Build adjacency list
        for (int i = 0; i < n; i++) tree[i] = new ArrayList<>();
        for (int[] edge : edges) {
            tree[edge[0]].add(edge[1]);
            tree[edge[1]].add(edge[0]);
        }

        // Find the path from Bob to root (node 0)
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        Map<Integer, Integer> bobPath = new HashMap<>();
        findBobPath(tree, bob, 0, -1, 0, bobTime, bobPath);

        // DFS to find the max profit for Alice
        return dfs(tree, 0, -1, 0, 0, bobTime, amount);   
    }
}