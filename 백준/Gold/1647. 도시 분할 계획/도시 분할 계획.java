
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static long sum;
	static int[] parent;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		edges = new Edge[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(v1, v2, c);
		}

		// 풀이
		sum = 0;

		Arrays.sort(edges, (e1, e2) -> e1.c - e2.c);

		makeSet();

		int cnt = 0;
		int maxEdgeCost = 0;
		for (int i = 0; i < M; i++) {
			Edge edge = edges[i];
			if (union(edge.v1, edge.v2)) {
				cnt++;
				sum += edge.c;
				maxEdgeCost = edge.c;
				if (cnt == N - 1)
					break;
			}
		}
		sum -= maxEdgeCost;

		System.out.println(sum);
	}

	static void makeSet() {
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	static int findSet(int x) {
		if (parent[x] == x)
			return x;
		else
			return parent[x] = findSet(parent[x]);
	}

	static boolean union(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);

		if (py == px)
			return false;

		if (px < py)
			parent[py] = px;
		else
			parent[px] = py;

		return true;
	}

	static class Edge {

		int v1, v2, c;

		Edge(int v1, int v2, int c) {
			this.v1 = v1;
			this.v2 = v2;
			this.c = c;
		}
	}
}
