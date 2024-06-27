import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, houseCount;
	static char[][] graph;
	static boolean[][] visited;
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, -1, 1};
	static ArrayList<Integer> complexSizes = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		graph = new char[N][];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			graph[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (graph[i][j] == '1' && !visited[i][j]) {
					houseCount = 0;
					dfs(i, j);
					complexSizes.add(houseCount);
				}
			}
		}

		Collections.sort(complexSizes);

		System.out.println(complexSizes.size());
		for (int size : complexSizes) {
			System.out.println(size);
		}
	}

	static void dfs(int y, int x) {
		visited[y][x] = true;
		houseCount++;

		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];

			if (ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx] || graph[ny][nx] != '1') continue;
			dfs(ny, nx);
		}
	}
}

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
7
8
9
*/