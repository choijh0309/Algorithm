import java.util.*;
import java.io.*;

class Tomato {
    int x, y, day;
    
    Tomato(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
}

public class Main {
    static int M, N;
    static int[][] box;
    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new Tomato(i, j, 0));
                }
            }
        }
        
        System.out.println(bfs());
    }
    
    static int bfs() {
        int maxDay = 0;
        
        while (!queue.isEmpty()) {
            Tomato current = queue.poll();
            maxDay = Math.max(maxDay, current.day);
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    queue.offer(new Tomato(nx, ny, current.day + 1));
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) return -1;
            }
        }
        
        return maxDay;
    }
}