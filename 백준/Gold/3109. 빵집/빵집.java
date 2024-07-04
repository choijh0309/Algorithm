
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static char[][] grid;
    static boolean[][] visited;
    static int count = 0;

    static int[] dx = {-1, 0, 1}; // 위-오른쪽, 오른쪽, 아래-오른쪽
    static int[] dy = {1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        grid = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int x, int y) {
        visited[x][y] = true;

        if (y == C - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny < C && !visited[nx][ny] && grid[nx][ny] == '.') {
                if (dfs(nx, ny)) {
                    return true;
                }
            }
        }

        return false;
    }
}
