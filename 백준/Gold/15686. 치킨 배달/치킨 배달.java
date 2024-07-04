
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] map;
	static ArrayList<Location> home = new ArrayList<>();
	static ArrayList<Location> chicken = new ArrayList<>();
	static boolean[] visit;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1) home.add(new Location(i, j));
				else if (map[i][j] == 2) chicken.add(new Location(i, j));
			}
		}
		
		visit = new boolean[chicken.size()];
		
		dfs(0, 0);
		
		System.out.println(min);

	}
	
	static void dfs(int a, int b) {
		if (b == M) {
			int cnt = 0;
			
			for (int i = 0; i < home.size(); i++) {
				int temp = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (visit[j]) {
						int distance = Math.abs(home.get(i).x - chicken.get(j).x) + Math.abs(home.get(i).y - chicken.get(j).y);
						temp = Math.min(temp, distance);
					}
				}
				cnt += temp;
			}
			min = Math.min(min, cnt);
		}
		
		for (int i = a; i < chicken.size(); i++) {
			visit[i] = true;
			dfs(i + 1, b + 1);
			visit[i] = false;
		}
	}
	
	static class Location {
		int x;
		int y;
		Location (int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}