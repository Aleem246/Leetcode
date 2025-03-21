class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingre, String[] supplies) {

        HashMap<String, List<String>> adj = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();

        int len = recipes.length;
        for (int i = 0; i < len; i++) {
            indegree.put(recipes[i], ingre.get(i).size());

            for (String s : ingre.get(i)) {
                if (!adj.containsKey(s))
                    adj.put(s, new ArrayList<>());
                adj.get(s).add(recipes[i]);
            }
        }
        Queue<String> que = new LinkedList<>();
        for (String supply : supplies) {
            que.add(supply);
        }

        List<String> res = new ArrayList<>();
        while (!que.isEmpty()) {
            String front = que.remove();

            if (!adj.containsKey(front))
                continue;

            for (String s : adj.get(front)) {
                indegree.put(s, indegree.get(s) - 1);

                if (indegree.get(s) == 0) {
                    res.add(s);
                    que.add(s);
                }

            }

        }
        return res;
    }
}