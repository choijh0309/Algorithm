
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int[][] map;
	static int[] cur;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					cur = new int[] { i, j };
					map[i][j] = 0;
				}
			}
		}

		int size = 2;
		int eat = 0;
		int move = 0;

		while (true) {
			PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1, o2) -> o1[2] != o2[2] ? Integer.compare(o1[2], o2[2])
					: (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1])));

			boolean[][] visit = new boolean[N][N];

			pqueue.add(new int[] { cur[0], cur[1], 0 });
			visit[cur[0]][cur[1]] = true;

			boolean check = false;

			while (!pqueue.isEmpty()) {
				cur = pqueue.poll();

				if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < size) {
					map[cur[0]][cur[1]] = 0;
					eat++;
					move += cur[2];
					check = true;
					break;
				}

				for (int k = 0; k < 4; k++) {
					int ny = cur[0] + dy[k];
					int nx = cur[1] + dx[k];

					if (ny < 0 || nx < 0 || nx >= N || ny >= N || visit[ny][nx] || map[ny][nx] > size)
						continue;

					pqueue.offer(new int[] { ny, nx, cur[2] + 1 });
					visit[ny][nx] = true;

				}
			}
			if (!check) break;
			
			if (size == eat) {
				size++;
				eat = 0;
			}
		}
		System.out.println(move);
	}
}
