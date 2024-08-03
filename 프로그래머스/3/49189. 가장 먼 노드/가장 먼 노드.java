import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // 그래프 구성
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // BFS를 위한 준비
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        
        queue.offer(1);
        visited[1] = true;
        
        int maxDistance = 0;
        int count = 0;
        
        // BFS 수행
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    distance[neighbor] = distance[current] + 1;
                    
                    if (distance[neighbor] > maxDistance) {
                        maxDistance = distance[neighbor];
                        count = 1;
                    } else if (distance[neighbor] == maxDistance) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}