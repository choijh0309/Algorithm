
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    
    static int V, E, result;
    static ArrayList<Edge>[] adjList;
    static boolean[] visit;
    static PriorityQueue<Edge> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        adjList = new ArrayList[V + 1];
        visit = new boolean[V + 1];
        
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            
            adjList[v1].add(new Edge(v2, weight));
            adjList[v2].add(new Edge(v1, weight));
        }
        
        visit[1] = true;
        for (Edge edge : adjList[1]) {
            pqueue.offer(edge);
        }
        
        int cnt = 1;
        
        while (!pqueue.isEmpty()) {
            Edge edge = pqueue.poll();
            if (visit[edge.v]) continue;
            visit[edge.v] = true;
            result += edge.c;
            cnt++;
            if (cnt == V) break;
            
            for (Edge nextEdge : adjList[edge.v]) {
                if (!visit[nextEdge.v]) {
                    pqueue.offer(nextEdge);
                }
            }
        }
        System.out.println(result);
    }
    
    static class Edge {
        int v, c;
        Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }
    }
}
