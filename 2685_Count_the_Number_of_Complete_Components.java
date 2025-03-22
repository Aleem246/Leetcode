class Solution {
    int nodes, nedges;

    public void dfs(boolean[] visited, int curr, HashMap<Integer, List<Integer>> hm) {
        nodes++;

        visited[curr] = true;

        for (int i : hm.get(curr)) {
            nedges++;
            if (!visited[i]) {
                dfs(visited, i, hm);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        boolean[] visited = new boolean[n];
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hm.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            hm.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }

        int component = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                nodes = 0;
                nedges = 0;

                dfs(visited, i, hm);
                if (nodes * (nodes - 1) == nedges) {
                    component++;
                }

            }
        }

        return component;

    }
}