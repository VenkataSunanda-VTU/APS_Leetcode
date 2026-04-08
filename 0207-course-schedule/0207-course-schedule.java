class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
        }
        int[] state = new int[numCourses]; // 0=unvisited,1=visiting,2=done
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, state)) return false;
        }
        
        return true;
    }
    private boolean dfs(int course, List<List<Integer>> graph, int[] state) {
        if (state[course] == 1) return false; // cycle found
        if (state[course] == 2) return true;
        state[course] = 1;
        for (int next : graph.get(course)) {
            if (!dfs(next, graph, state)) return false;
        } 
        state[course] = 2;
        return true;
    }
}