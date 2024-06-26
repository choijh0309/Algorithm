import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] arr;
    static int count = 0;
    static int node, line;
    static Queue<Integer> q = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());
        arr = new int[node + 1][node + 1];
        visited = new boolean[node + 1];
        
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(count - 1);
    }
    
    public static void dfs(int V) {
        visited[V] = true;
        count++;
        
        for (int i = 0; i <= node; i++) {
            if (arr[V][i] == 1 && !visited[i])
                dfs(i);
        }
    }
}