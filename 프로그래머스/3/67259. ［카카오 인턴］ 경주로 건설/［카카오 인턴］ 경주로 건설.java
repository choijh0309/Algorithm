import java.util.*;

class Solution {
    // 상, 우, 하, 좌 방향을 나타내는 배열
    private final int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    public int solution(int[][] board) {
        int n = board.length;
        // 각 위치에서의 최소 비용을 저장하는 3차원 배열 (x, y, direction)
        int[][][] costs = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        
        // 우선순위 큐를 사용하여 최소 비용 경로를 찾음
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[3] - b[3]);
        pq.offer(new int[]{0, 0, -1, 0}); // {x, y, direction, cost}
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], dir = current[2], cost = current[3];
            
            // 도착점에 도달했다면 현재 비용 반환
            if (x == n - 1 && y == n - 1) {
                return cost;
            }
            
            // 모든 방향으로 이동 시도
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];
                
                // 범위를 벗어나거나 벽인 경우 무시
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || board[nx][ny] == 1) {
                    continue;
                }
                
                // 비용 계산 (직선 도로: 100, 코너: 600)
                int newCost = cost + 100;
                if (dir != -1 && dir != i) {
                    newCost += 500;
                }
                
                // 더 적은 비용으로 도달할 수 있다면 갱신
                if (newCost < costs[nx][ny][i]) {
                    costs[nx][ny][i] = newCost;
                    pq.offer(new int[]{nx, ny, i, newCost});
                }
            }
        }
        
        // 도착점에 도달할 수 없는 경우 (문제 조건상 이 경우는 없음)
        return -1;
    }
}