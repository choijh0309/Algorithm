
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int max = Integer.MIN_VALUE;
	static int[][] map;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0);
		
		System.out.println(max);

	}
	
	static void dfs(int wall) {
		if (wall == 3) {
			countSafeArea();
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(wall + 1);
					map[i][j] = 0;
				}
			}
		}
	}
	
	static void countSafeArea() {
		int[][] room = new int[N][M];
		for (int i = 0; i < N; i++) {
			room[i] = Arrays.copyOfRange(map[i], 0, M);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (room[i][j] == 2) {
					bfs(room, i, j);
				}
			}
		}
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (room[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		max = Math.max(max, cnt);
	}
	
	static void bfs(int[][] room, int y, int x) {
		int[] dy = {-1, 0, 1, 0};
		int[] dx = {0, 1, 0, -1};
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		queue.add(new int[] {y, x});
		
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int ny = cur[0] + dy[d];
				int nx = cur[1] + dx[d];
				
				if (checkIndex(ny, nx) && room[ny][nx] == 0) {
					room[ny][nx] = 3;
					queue.add(new int[] {ny, nx});
				}
			}
		}
	}
	
	static boolean checkIndex(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}

}
