import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // 테스트 케이스의 개수
        
        // 동적 프로그래밍을 위한 배열 초기화
        int[] dp = new int[11];
        dp[1] = 1; // 1을 만드는 방법: 1
        dp[2] = 2; // 2를 만드는 방법: 1+1, 2
        dp[3] = 4; // 3을 만드는 방법: 1+1+1, 1+2, 2+1, 3
        
        // 4부터 10까지의 경우의 수 계산
        for (int i = 4; i <= 10; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        
        // 각 테스트 케이스에 대해 결과 출력
        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            System.out.println(dp[n]);
        }
    }
}