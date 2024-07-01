import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 플로이드워셜
public class Main {

	static final int INF = 1000 * 1000;
	static int n, m, x;
	static int[][] matrix;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		matrix = new int[n +1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(matrix[i], INF);
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());
			
			matrix[start][end] = t;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
						matrix[i][j] =  matrix[i][k] + matrix[k][j];
					}
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= n; i++) {
			if (i != x) {
				ans = Math.max(ans, matrix[i][x] + matrix[x][i]);
			}
		}
		System.out.println(ans);
	}

}