import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        List<List<Integer>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        
        int[] distances = new int[n + 1];
        Arrays.fill(distances, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(destination);
        distances[destination] = 0;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[current] + 1;
                    queue.offer(neighbor);
                }
            }
        }
        
        int[] result = new int[sources.length];
        for (int i = 0; i < sources.length; i++) {
            result[i] = distances[sources[i]];
        }
        
        return result;
    }
}