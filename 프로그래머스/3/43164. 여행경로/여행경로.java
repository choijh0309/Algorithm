import java.util.*;

class Solution {
    Map<String, PriorityQueue<String>> graph;
    List<String> route;

    public String[] solution(String[][] tickets) {
        graph = new HashMap<>();
        route = new ArrayList<>();

        // 그래프 구성
        for (String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).offer(ticket[1]);
        }

        dfs("ICN");

        Collections.reverse(route);
        return route.toArray(new String[0]);
    }

    private void dfs(String airport) {
        PriorityQueue<String> destinations = graph.get(airport);
        while (destinations != null && !destinations.isEmpty()) {
            String nextAirport = destinations.poll();
            dfs(nextAirport);
        }
        route.add(airport);
    }
}