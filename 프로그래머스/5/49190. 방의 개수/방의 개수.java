import java.util.*;

class Solution {
    // 8방향에 대한 x, y 좌표 변화
    private static final int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static final int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    public int solution(int[] arrows) {
        int roomCount = 0;
        Node currentNode = new Node(0, 0);
        Map<Node, Set<Node>> visited = new HashMap<>();

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {  // 각 이동을 두 번에 나누어 처리
                int nx = currentNode.x + dx[arrow];
                int ny = currentNode.y + dy[arrow];
                Node nextNode = new Node(nx, ny);

                if (!visited.containsKey(currentNode)) {
                    visited.put(currentNode, new HashSet<>());
                }
                if (!visited.containsKey(nextNode)) {
                    visited.put(nextNode, new HashSet<>());
                }

                // 새로운 간선을 만났을 때 방 개수 증가
                if (!visited.get(currentNode).contains(nextNode)) {
                    if (visited.containsKey(nextNode) && visited.get(nextNode).size() > 0) {
                        roomCount++;
                    }
                    visited.get(currentNode).add(nextNode);
                    visited.get(nextNode).add(currentNode);
                }

                currentNode = nextNode;
            }
        }

        return roomCount;
    }

    private static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}