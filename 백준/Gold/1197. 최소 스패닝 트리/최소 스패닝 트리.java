import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static int V, E, result;
	static ArrayList<Vertex>[] adjList;
	static boolean[] visit;
	static PriorityQueue<Vertex> pqueue = new PriorityQueue<>((v1, v2) -> v1.c - v2.c);
	
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
			int c = Integer.parseInt(st.nextToken());
			
			adjList[v1].add(new Vertex(v2, c));
            adjList[v2].add(new Vertex(v1, c));
		}
		
		visit[1] = true;
		for (Vertex vertex : adjList[1]) {
            pqueue.offer(vertex);
        }
		int cnt = 1;
		
		while (!pqueue.isEmpty()) {
			Vertex vertex = pqueue.poll();
			if (visit[vertex.v]) continue;
			visit[vertex.v] = true;
			result += vertex.c;
			cnt++;
			if (cnt == V) break;
			
			for (Vertex nextVertex : adjList[vertex.v]) {
                if (!visit[nextVertex.v]) {
                    pqueue.offer(nextVertex);
                }
            }
		}
		System.out.println(result);
		
	}
	
	static class Vertex {
		int v, c;
		Vertex(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
	
}
