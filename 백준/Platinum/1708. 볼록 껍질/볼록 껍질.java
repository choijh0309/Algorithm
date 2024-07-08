
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {
    
    static int N;
    static long sx, sy; // 시작 좌표
    static long[][] point;
    static Stack<long[]> stack = new Stack<>();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        point = new long[N][2];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        point[0][0] = Long.parseLong(st.nextToken());
        point[0][1] = Long.parseLong(st.nextToken());
        // 맨 앞 입력을 시작점으로 하고 갱신
        sx = point[0][0];
        sy = point[0][1];
        
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long lx = Long.parseLong(st.nextToken());
            long ly = Long.parseLong(st.nextToken());
            
            if( sy > ly ) {
                sx = lx;
                sy = ly;
            }else if( sy == ly && sx > lx ) {
                sx = lx;
                sy = ly;
            }
            
            point[i][0] = lx;
            point[i][1] = ly;
        }
        
        // 풀이
        // 정렬 : 시작점 기준 ccw 로 정렬
        Arrays.sort(point, (p1, p2) -> {
            long ret = ccw(sx, sy, p1[0], p1[1], p2[0], p2[1]);
            if( ret > 0 ) { // 반시계
                return -1;
            }else if( ret < 0 ) { // 시계
                return 1;
            }else {
                long diff = distance(sx, sy, p1[0], p1[1]) - distance(sx, sy, p2[0], p2[1]);
                return diff > 0 ? 1 : -1; // 거리가 더 먼 점이 뒤로
            }
        });
        
        // stack 이용 볼록껍질
        stack.add(new long[] {sx, sy});
        
        for (int i = 1; i < N; i++) {
            long[] next = point[i];
            while( stack.size() > 1 ) {
                long[] first = stack.get(stack.size() - 2 );
                long[] second = stack.get(stack.size() - 1 );
                long ret = ccw(first[0], first[1], second[0], second[1], next[0], next[1]);
                if( ret <= 0 ) stack.pop(); // = : 더 가까이 있던 점 제거
                else break; 
            }
            
            stack.add(point[i]);
        }
        System.out.println(stack.size());
    }
    // 세점의 순서대로 연결시 ccw
//  static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
//      long ret = (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
//      
//      if( ret > 0 ) return 1;
//      else if( ret < 0 ) return -1;
//      else return 0;
//  }
    
    static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        return (x1*y2 + x2*y3 + x3*y1) - (x2*y1 + x3*y2 + x1*y3);
    }
    
    // 두 점 사이의 거리(루트 제외)
    static long distance(long x1, long y1, long x2, long y2) {
        return (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
    }
}