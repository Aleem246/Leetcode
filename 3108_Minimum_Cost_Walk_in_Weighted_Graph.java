class DSU {
    int rank[];
    int parent[];

    DSU(int n) {
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int node) {
        if (parent[node] == node)
            return node;

        return parent[node] = find(parent[node]);
    }

    public void union(int node1, int node2) {
        int root1 = find(node1);
        int root2 = find(node2);

        if (root1 == root2) {
            return;
        }
        if (rank[root1] < rank[root2]) {
            parent[root1] = root2;

        } else if (rank[root2] < rank[root1]) {
            parent[root2] = root1;
        } else {
            parent[root2] = root1;
            rank[root1]++;
        }
    }
}

class Solution {

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU dsu = new DSU(n);
        // V
        for (int edge[] : edges) {
            dsu.union(edge[0], edge[1]);
        }

        int compCost[] = new int[n];
        // N
        Arrays.fill(compCost, Integer.MAX_VALUE);
        // V

        for (int edge[] : edges) {
            int rootParent = dsu.find(edge[0]);
            compCost[rootParent] = compCost[rootParent] & edge[2];
        }
        int len = query.length;
        int ans[] = new int[len];
        // M
        int index = 0;
        for (int[] q : query) {
            int rt1 = dsu.find(q[0]);
            int rt2 = dsu.find(q[1]);
            if (rt1 == rt2)
                ans[index++] = compCost[rt1];
            else
                ans[index++] = -1;
        }
        return ans;
    }
}