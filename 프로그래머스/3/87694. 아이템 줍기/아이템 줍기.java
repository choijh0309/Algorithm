import java.util.*;

class Solution {
    static int[][] map = new int[101][101];
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 직사각형 테두리를 그리드에 표시
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    if (i == x1 || i == x2 || j == y1 || j == y2) {
                        if (map[i][j] == 0) map[i][j] = 1;
                    } else {
                        map[i][j] = 2;
                    }
                }
            }
        }

        // BFS로 최단 경로 찾기
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[101][101];
        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], dist = current[2];

            if (x == itemX * 2 && y == itemY * 2) {
                return dist / 2;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx <= 100 && ny >= 0 && ny <= 100 && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny, dist + 1});
                    visited[nx][ny] = true;
                }
            }
        }

        return -1;  // 경로가 없는 경우
    }
}