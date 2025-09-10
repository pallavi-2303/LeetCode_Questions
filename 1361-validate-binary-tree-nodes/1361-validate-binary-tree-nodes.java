class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        //in a binary tree each child has only one parent and there is only one root and and only one component;
        HashMap<Integer, List<Integer>> parentToChild = new HashMap<>();
        HashMap<Integer, Integer> childToParent = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int node = i;
            int lc = leftChild[i];
            int rc = rightChild[i];
            if (lc != -1) {
                //if there is already a parent for this node
                if (childToParent.containsKey(lc)) {
                    return false;
                }
                parentToChild.computeIfAbsent(node, k -> new ArrayList<>()).add(lc);
                childToParent.put(lc, i);
            }
            if (rc != -1) {
                //if there is already a parent for this node
                if (childToParent.containsKey(rc)) {
                    return false;
                }
                parentToChild.computeIfAbsent(node, k -> new ArrayList<>()).add(rc);
                childToParent.put(rc, i);
            }
        }
        //now check for root if there is a node that is not a child of any can be a root;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (!childToParent.containsKey(i)) {
                if (root != -1) {
                    return false;
                } else {
                    root = i;
                }
            }
        }
        if (root == -1) {
            return false;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        int[] vis = new int[n];
        vis[root] = 1;
        int comp = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            comp++;
            for (int child : parentToChild.getOrDefault(node, Collections.emptyList())) {
                if (vis[child] == 0) {
                    vis[child] = 1;
                    q.add(child);
                }
            }

        }
        return comp == n;

    }
}