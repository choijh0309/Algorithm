import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R, count = 1;
    static int[] result;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        result = new int[N + 1];
        visited = new boolean[N + 1];
        
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(R);
        for (int i = 1; i <= N; i++) 
            bw.write(result[i] + "\n");
            bw.flush();
            bw.close();
            br.close();
        }
        
        static void dfs(int cur) {
            visited[cur] = true;
            result[cur] = count++;
            Collections.sort(graph.get(cur), Collections.reverseOrder());
            
            for (Integer value : graph.get(cur)) {
                if (!visited[value]) {
                    dfs(value);
                }
            }
            return;
        }
    }