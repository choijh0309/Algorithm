

import java.io.BufferedReader;
import java.io.InputStreamReader;

// hanoi(n) = 2 x hanoi(n - 1) + 1
// hanoi(n - 1) = 2 x hanoi(n - 2) + 1
public class Main {

	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		sb.append(((int)Math.pow(2, N)) - 1).append("\n"); // 하노이 수행수
		hanoi(N, 1, 2, 3);
		System.out.println(sb);
	}

	// from(1번째 파라미터) 자리에서 to (3번째 파라미터) 로 n 개 이동하려고 할 때,
	// (1) from 자의 n - 1 개를 temp 로 옮기고
	// (2) from 자리에 남은 1개(n) 를 to 로 옮기고 (출력으로 표현)
	// (3) temp 로 옮겼던 n - 1 개를 to 로 옮긴다.
	// 옮기는 작업은 첫 번째 파라미터 자리에서 세 번째 파라미터 자리
	static void hanoi(int n, int from, int temp, int to) {
		// 기저 조건
		if (n == 0) return;
		
		// (1)
		hanoi(n - 1, from, to, temp);
		// (2)
		sb.append(from).append(" ").append(to).append("\n");
		// (3)
		hanoi(n - 1, temp, from, to);
	}
}
