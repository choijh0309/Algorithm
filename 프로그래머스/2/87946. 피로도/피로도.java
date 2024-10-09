class Solution {
    int maxCount = 0; 
    boolean[] visited; 

    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        visited = new boolean[n]; 

        dfs(k, dungeons, 0);

        return maxCount; 
    }

    private void dfs(int fatigue, int[][] dungeons, int count) {
        if (count > maxCount) {
            maxCount = count;
        }

        // 모든 던전에 대해 시도
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && fatigue >= dungeons[i][0]) {
                visited[i] = true; 
                dfs(fatigue - dungeons[i][1], dungeons, count + 1);
                visited[i] = false; 
            }
        }
    }
}
