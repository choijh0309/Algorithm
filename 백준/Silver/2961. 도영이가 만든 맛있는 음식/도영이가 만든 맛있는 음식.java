

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] S;
	static int[] B;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}

		DFS(0, 1, 0, 0);
		System.out.println(result);
	}

	static void DFS(int n, int s, int b, int cnt) {
		if (n == N) {
			if (cnt != 0 && Math.abs(s - b) < result) {
				result = Math.abs(s - b);		
			}
			return;
		}
		DFS(n + 1, s * S[n], b + B[n], cnt + 1);
		DFS(n + 1, s, b, cnt);
	}

}