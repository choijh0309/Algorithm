import java.util.*;

public class Main {
    static int n, w;
    static ArrayList<Integer>[] list;
    static int[] building;
    static int[] indegree;
    static int[] buildCost;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            int k = sc.nextInt();
            
            building = new int[n + 1];
            list = new ArrayList[n + 1];
            for (int j = 1; j <= n; j++) {
                building[j] = sc.nextInt();
                list[j] = new ArrayList<>();
            }
            
            indegree = new int[n + 1];
            for (int j = 0; j < k; j++) {
                int s = sc.nextInt();
                int e = sc.nextInt();
                list[s].add(e);
                indegree[e]++;
            }
            w = sc.nextInt();
            
            buildCost = new int[n + 1];
            topologySort();
            System.out.println(buildCost[w]);
        }
    }
    
    public static void topologySort() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                buildCost[i] = building[i];
                q.offer(i);
            }
        }
        
        while (!q.isEmpty()) {
            int current = q.poll();
            
            for (int i = 0; i < list[current].size(); i++) {
                int next = list[current].get(i);
                buildCost[next] = Math.max(buildCost[current] + building[next], buildCost[next]);
                indegree[next]--;
                if (indegree[next] == 0) q.offer(next);
            }
        }
    }
}