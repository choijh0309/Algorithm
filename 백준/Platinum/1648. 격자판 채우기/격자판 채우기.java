import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] dp;
    static int MOD = 9901;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[N * M][1 << M];
        for (int i = 0; i < N * M; i++) {
            Arrays.fill(dp[i], -1);
        }
        
        System.out.println(recursion(0, 0));
    }
    
    public static int recursion(int checkBlockNum, int status) {
        if (checkBlockNum == N * M && status == 0) return 1;
        if (checkBlockNum >= N * M) return 0;
        if (dp[checkBlockNum][status] != -1) return dp[checkBlockNum][status];
        dp[checkBlockNum][status] = 0;
        if ((status & 1 << 0) != 0) {
            dp[checkBlockNum][status] += recursion(checkBlockNum + 1, status >> 1);
        } else {
            dp[checkBlockNum][status] += recursion(checkBlockNum + 1, (status | 1 << M) >> 1);
            if (checkBlockNum % M != M - 1 && (status & 1 << 1) == 0) {
                dp[checkBlockNum][status] += recursion(checkBlockNum + 2, status >> 2);
            }
        }
        dp[checkBlockNum][status] %= MOD;
        return dp[checkBlockNum][status];
    }
}