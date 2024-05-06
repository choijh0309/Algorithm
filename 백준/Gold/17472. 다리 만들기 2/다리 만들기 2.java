import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] parent;
    static int[][] map;
    static int N, M, sNum;
    static boolean[][] visited;
    static ArrayList<ArrayList<int[]>> sumlist;
    static ArrayList<int[]> mlist;
    static PriorityQueue<bEdge> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sNum = 1;
        sumlist = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] != 0 && visited[i][j] != true) {
                    BFS(i, j);
                    sNum++;
                    sumlist.add(mlist);
                }
            }
        }
        queue = new PriorityQueue<>();
        for (int i = 0; i < sumlist.size(); i++) {
            ArrayList<int[]> now = sumlist.get(i);
            for (int j = 0; j < now.size(); j++) {
                int r = now.get(j)[0];
                int c = now.get(j)[1];
                int now_S = map[r][c];
                for (int d = 0; d < 4; d++) {
                    int tempR = dr[d];
                    int tempC = dc[d];
                    int blenght = 0;
                    while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
                        if (map[r + tempR][c + tempC] == now_S)
                            break;
                        else if (map[r + tempR][c + tempC] != 0) {
                            if (blenght > 1)
                                queue.add(new bEdge(now_S, map[r + tempR][c + tempC], blenght));
                            break;
                        } else
                            blenght++;
                        if (tempR < 0)tempR--;
                        else if (tempR > 0)tempR++;
                        else if (tempC < 0)tempC--;
                        else if (tempC > 0)tempC++;
                    }
                }
            }
        }
        parent = new int[sNum];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        int useEdge = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            bEdge now = queue.poll();
            if (find(now.s) != find(now.e)) {
                union(now.s, now.e);
                result = result + now.v;
                useEdge++;
            }
        }
        if (useEdge == sNum - 2) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            parent[b] = a;
        }
    }
    public static int find(int a) {
        if (a == parent[a])
            return a;
        else
            return parent[a] = find(parent[a]);
    }
    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        mlist = new ArrayList<>();
        int[] start = {i, j};
        queue.add(start);
        mlist.add(start);
        visited[i][j] = true;
        map[i][j] = sNum;
        while (!queue.isEmpty()) {
            int now[] = queue.poll();
            int r = now[0];
            int c = now[1];
            for (int d = 0; d < 4; d++) {
                int tempR = dr[d];
                int tempC = dc[d];
                while (r + tempR >= 0 && r + tempR < N && c + tempC >= 0 && c + tempC < M) {
                    if (visited[r + tempR][c + tempC] == false && map[r + tempR][c +tempC] != 0) {
                        addNode(r + tempR, c + tempC, queue);
                    } else break;
                    if (tempR < 0)tempR--;
                    else if (tempR > 0)tempR++;
                    else if (tempC < 0)tempC--;
                    else if (tempC > 0)tempC++;
                }
            }
        }
    }
    private static void addNode(int i, int j, Queue<int[]> queue) {
        map[i][j] = sNum;
        visited[i][j] = true;
        int[] temp = {i, j};
        mlist.add(temp);
        queue.add(temp);
    }
}
class bEdge implements Comparable<bEdge> {
    int s, e, v;
    bEdge(int s, int e, int v) {
        this.s = s;
        this.e = e;
        this.v = v;
    }
    @Override
    public int compareTo(bEdge o) {
        return this.v - o.v;
    }
}