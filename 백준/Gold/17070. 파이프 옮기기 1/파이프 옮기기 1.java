
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		DFS(1, 2, 0);
		
		System.out.println(ans);

	}

	static void DFS(int y, int x, int direction) {
		if (y == N && x == N) {
			ans++;
			return;
		}
		
		switch (direction) {
		case 0:
			if (x + 1 <= N && map[y][x + 1] == 0) {
				DFS(y, x + 1, 0);
			}
			break;
		case 1:
			if (y + 1 <= N && map[y + 1][x] == 0) {
				DFS(y + 1, x, 1);
			}
			break;
		case 2:
			if (x + 1 <= N && map[y][x + 1] == 0) {
				DFS(y, x + 1, 0);
			}
			
			if (y + 1 <= N && map[y + 1][x] == 0) {
				DFS(y + 1, x, 1);
			}
			break;
		}
		
		if (x + 1 <= N && y + 1 <= N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0) {
			DFS(y + 1, x + 1, 2);
		}
	}
}
