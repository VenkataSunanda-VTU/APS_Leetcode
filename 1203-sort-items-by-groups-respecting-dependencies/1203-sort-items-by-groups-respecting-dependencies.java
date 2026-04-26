class Solution {
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = m++;
            }
        }
        List<List<Integer>> itemGraph = new ArrayList<>();
        List<List<Integer>> groupGraph = new ArrayList<>();
        int[] itemIndegree = new int[n];
        int[] groupIndegree = new int[m];
        for (int i = 0; i < n; i++) {
            itemGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            groupGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int prev : beforeItems.get(i)) {
                itemGraph.get(prev).add(i);
                itemIndegree[i]++;
                if (group[i] != group[prev]) {
                    groupGraph.get(group[prev]).add(group[i]);
                    groupIndegree[group[i]]++;
                }
            }
        }
        List<Integer> itemOrder = topoSort(itemGraph, itemIndegree, n);
        if (itemOrder.size() == 0) return new int[0];
        List<Integer> groupOrder = topoSort(groupGraph, groupIndegree, m);
        if (groupOrder.size() == 0) return new int[0];
        Map<Integer, List<Integer>> groupToItems = new HashMap<>();
        for (int item : itemOrder) {
            groupToItems.computeIfAbsent(group[item], x -> new ArrayList<>()).add(item);
        }
        List<Integer> result = new ArrayList<>();
        for (int g : groupOrder) {
            List<Integer> items = groupToItems.get(g);
            if (items != null) {
                result.addAll(items);
            }
        }
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }
    private List<Integer> topoSort(List<List<Integer>> graph, int[] indegree, int size) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);

            for (int next : graph.get(curr)) {
                if (--indegree[next] == 0) {
                    q.add(next);
                }
            }
        }
        return res.size() == size ? res : new ArrayList<>();
    }
}