import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n; // 두 전력망이 가지고 있는 송전탑 개수의 차이의 최솟값을 저장할 변수

        // 송전탑 연결 정보를 저장할 인접 리스트 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) { // 송전탑 번호가 1부터 시작하므로 n+1 크기로 생성
            graph.add(new ArrayList<>());
        }

        // 인접 리스트에 연결 정보 추가
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        // 각 전선을 끊어보며 완전탐색
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];

            // 전선 제거 (양방향 간선을 제거)
            graph.get(v1).remove(Integer.valueOf(v2));
            graph.get(v2).remove(Integer.valueOf(v1));

            // BFS를 이용하여 한 쪽 네트워크의 송전탑 개수 계산
            int count = bfs(v1, n, graph);

            // 두 전력망의 송전탑 개수의 차이 계산
            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);

            // 제거한 전선 복구
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        return answer;
    }

    // BFS를 이용하여 연결된 송전탑의 개수 계산
    private int bfs(int start, int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n + 1]; // 방문 여부 체크 배열
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        int count = 1; // 시작 노드 포함

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++; // 연결된 송전탑 개수 증가
                }
            }
        }

        return count;
    }
}
