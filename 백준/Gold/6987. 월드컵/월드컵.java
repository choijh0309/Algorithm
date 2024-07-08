import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 결과 유효성 검증
// 완탐 기본 알고리즘 + 가지치기
// 완탐 모든 경기를 순차적으로 진행해 가면서 발생할 수 있는 결과 (A 승리, B 승리, 비김)
// 경기 진행(2팀) 을 위한 별도의 자료구조 game[][]
public class Main {

	static int[] win, draw, lose; // 나라별
	static int[][] game; // game[3] == 4 // 3 번 나라와 4번 나라가 경기
	static boolean result; // 최종결과
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// index 가 나라
		win = new int[6];
		draw = new int[6];
		lose = new int[6];
		
		// 경기를 순차적으로 진행하기 위한 game 배열
		game = new int[15][2]; // 5 + 4 + 3 + 2 + 1
		int idx = 0;
		for (int i = 0; i < 5; i++) {
			for (int j = i + 1; j < 6; j++) {	
				game[idx][0] = i;
				game[idx][1] = j;
				idx++;
			}
		}
		
		// 4가지 결과에 대한 검증
		for (int i = 0; i < 4; i++) {
			result = false;
			
			int winSum = 0;
			int drawSum = 0;
			int loseSum = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 18 개 3개씩 한 나라의 승, 무, 패
			for (int j = 0; j < 6; j++) {
				winSum += win[j] = Integer.parseInt(st.nextToken());
				drawSum += draw[j] = Integer.parseInt(st.nextToken());
				loseSum += lose[j] = Integer.parseInt(st.nextToken());
			}
			
			// 가지치기 1
			if ((winSum + drawSum + loseSum) != 30) {
				sb.append("0 ");
				continue;
			}
			
			// 가지치기 2
			if (winSum != loseSum) {
				sb.append("0 ");
				continue;
			}
			
			// 완탐
			dfs(0);
			
			if (result) sb.append("1 ");
			else sb.append("0 ");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int idx) {
		if (idx == 15) { // 모든 게임이 정상적으로 진행 데이터 검증
			result = true;
			return;
		}
		
		int teamA = game[idx][0];
		int teamB = game[idx][1];
		
		// A 승리, B 패배
		if (win[teamA] > 0 && lose[teamB] > 0) {
			win[teamA]--;
			lose[teamB]--;
			
			dfs(idx + 1);
			
			win[teamA]++;
			lose[teamB]++;
		}
		
		// B 승리, A 패배
		if (win[teamB] > 0 && lose[teamA] > 0) {
			win[teamB]--;
			lose[teamA]--;
			
			dfs(idx + 1);
			
			win[teamB]++;
			lose[teamA]++;
		}
		
		// 무승부
		if (draw[teamA] > 0 && draw[teamB] > 0) {
			draw[teamA]--;
			draw[teamB]--;
			
			dfs(idx + 1);
			
			draw[teamA]++;
			draw[teamB]++;
		}
	}
}
/*
대진표 (아래) 를
0 1 2 3 4 5
0 \ * * * * *   
1   \ * * * *
2     \ * * *
3       \ * *
4         \ *
5           \

아래의 2차원 배열로 2개의 대진을 표현하는 자료 구조 구성
----------------------------> 순서대로 시합을 계속 이어가면서 단계별 검증 (끝까지 오면 성공)
0 0 0 0 0 1 1 1 1 2 2 2 3 3 4
1 2 3 4 5 2 3 4 5 3 4 5 4 5 5
*/