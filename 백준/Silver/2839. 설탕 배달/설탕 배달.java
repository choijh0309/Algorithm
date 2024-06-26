
import java.io.BufferedReader;
import java.io.InputStreamReader;

// 완탐, 그리디, DP
public class Main {

	static int N, min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		if (N == 4 || N == 7) {
			System.out.println(-1);
		} else if (N % 5 == 0) {
			System.out.println(N / 5);
		} else if (N % 5 == 1 || N % 5 == 3) {
			System.out.println(N / 5 + 1);
		} else if (N % 5 == 2 || N % 5 == 4) {
			System.out.println(N / 5 + 2);
		}
	}

}
