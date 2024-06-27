

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static char[][] graph;
    static boolean[][] visited;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static ArrayList<Integer> complexSizes = new ArrayList<>();

    static class Node {
        int y, x;
        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static Queue<Node> queue = new ArrayDeque<>();

    static int bfs(int y, int x) {
        int houseCount = 0;
        // 해당 노드 방문 처리
        visited[y][x] = true;
        queue.offer(new Node(y, x));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            houseCount++;
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx] || graph[ny][nx] != '1') continue;
                visited[ny][nx] = true;
                queue.offer(new Node(ny, nx));
            }
        }
        return houseCount;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N을 공백을 기준으로 구분하여 입력 받기
        n = Integer.parseInt(st.nextToken());

        graph = new char[n][];
        visited = new boolean[n][n];

        // 2차원 리스트의 맵 정보 입력 받기
        for (int i = 0; i < n; i++) {
            graph[i] = br.readLine().toCharArray();
        }

        // 모든 노드(위치)에 대하여 단지 수 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 위치에서 BFS 수행
                if (graph[i][j] == '1' && !visited[i][j]) {
                    int size = bfs(i, j);
                    complexSizes.add(size);
                }
            }
        }

        Collections.sort(complexSizes);

        System.out.println(complexSizes.size());
        for (int size : complexSizes) {
            System.out.println(size);
        }
    }
}

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000

3
7
8
9
*/