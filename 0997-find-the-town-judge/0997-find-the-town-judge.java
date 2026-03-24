class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] count = new int[n + 1];
        
        for (int[] t : trust) {
            int a = t[0], b = t[1];
            count[a]--;  // a trusts someone
            count[b]++;  // b is trusted
        }
        for (int i = 1; i <= n; i++) {
            if (count[i] == n - 1) {
                return i;
            }
        } 
        return -1;
    }
}