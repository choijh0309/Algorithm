import java.util.*;
import java.io.*;

public class Main {
    static int[][] event, dp;
    static int N, W;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        
        event = new int[1001][2];
        dp = new int[1001][1001];
        
        for (int i = 1; i <= W; i++) {
            st = new StringTokenizer(br.readLine());
            
            event[i][0] = Integer.parseInt(st.nextToken());
            event[i][1] = Integer.parseInt(st.nextToken());
        }
        
        System.out.println(dfs(1, 0, 0));
        
        int one = 0;
        int two = 0;
        for (int i = 1; i <= W; i++) {
            int dist = getDistance(1, one, i);
            
            if (dp[one][two] - dist == dp[i][two]) {
                one = i;
                System.out.println(1);
            } else {
                two = i;
                System.out.println(2);
            }
        }
    }
    
    public static int dfs(int e, int one, int two) {
        if (e > W) return 0;
        
        if (dp[one][two] != 0) return dp[one][two];
        
        int fir = dfs(e + 1, e, two) + getDistance(1, one, e);
        int sec = dfs(e + 1, one, e) + getDistance(2, two, e);
        
        return dp[one][two] = Math.min(fir, sec);
    }
    
    public static int getDistance(int type, int start, int end) {
        int[] st = event[start];
        int[] ed = event[end];
        
        if (start == 0) {
            if (type == 1) st = new int[] {1, 1};
            else st = new int[] {N, N};
        }
        
        return Math.abs(st[0] - ed[0]) + Math.abs(st[1] - ed[1]);
    }
}