import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        // 인접 리스트로 그래프 표현
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프 구성
        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        
        int minDifference = n;  // 최대 차이로 초기화
        
        // 각 전선을 끊어보며 차이 계산
        for (int[] wire : wires) {
            int v1 = wire[0], v2 = wire[1];
            
            // v1에서 시작하는 네트워크의 크기 계산
            boolean[] visited = new boolean[n + 1];
            int count = dfs(v1, v2, graph, visited);
            
            // 차이 계산 및 최소값 갱신
            int difference = Math.abs(n - 2 * count);
            minDifference = Math.min(minDifference, difference);
        }
        
        return minDifference;
    }
    
    // DFS로 연결된 송전탑 개수 계산
    private int dfs(int node, int except, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        
        for (int neighbor : graph.get(node)) {
            if (neighbor != except && !visited[neighbor]) {
                count += dfs(neighbor, except, graph, visited);
            }
        }
        
        return count;
    }
}