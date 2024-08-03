import java.util.*;

class Solution {
    List<List<Integer>> tree;
    int[] sales;
    int[][] dp;

    public int solution(int[] sales, int[][] links) {
        this.sales = sales;
        int n = sales.length;
        tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] link : links) {
            tree.get(link[0] - 1).add(link[1] - 1);
        }

        dp = new int[n][2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return Math.min(dfs(0, 0), dfs(0, 1));
    }

    private int dfs(int node, int isAttend) {
        if (dp[node][isAttend] != -1) {
            return dp[node][isAttend];
        }

        int result = isAttend == 1 ? sales[node] : 0;
        int minDiff = Integer.MAX_VALUE;
        boolean hasAttendingChild = false;

        for (int child : tree.get(node)) {
            int notAttend = dfs(child, 0);
            int attend = dfs(child, 1);

            if (isAttend == 0 && attend < notAttend) {
                hasAttendingChild = true;
                result += attend;
            } else {
                result += Math.min(attend, notAttend);
            }

            minDiff = Math.min(minDiff, attend - notAttend);
        }

        if (isAttend == 0 && !hasAttendingChild && !tree.get(node).isEmpty()) {
            result += minDiff;
        }

        return dp[node][isAttend] = result;
    }
}