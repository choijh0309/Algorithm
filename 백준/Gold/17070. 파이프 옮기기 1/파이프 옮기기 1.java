
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// dp
public class Main {

	static int N;
	static int[][] map;
	static long[][][] dp;
	static long cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N + 1][N + 1]; // 0 dummy
		dp = new long[N + 1][N + 1][3];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 풀이 dp()
		dp[1][2][1] = 1;
		
		for (int y = 1; y <= N; y++) {
			for (int x = 3; x <= N; x++) {
				if (map[y][x] == 0) {
					dp[y][x][1] = dp[y][x - 1][1] + dp[y][x - 1][0];
					dp[y][x][2] = dp[y - 1][x][2] + dp[y - 1][x][0];
					if (map[y - 1][x] == 0 && map[y][x - 1] == 0) {
						dp[y][x][0] = dp[y - 1][x - 1][0] + dp[y - 1][x - 1][1] + dp[y - 1][x - 1][2];
					}
				}
			}
		}
		
		long cnt = dp[N][N][0] + dp[N][N][1] + dp[N][N][2];
		System.out.println(cnt);
	}

	
}
