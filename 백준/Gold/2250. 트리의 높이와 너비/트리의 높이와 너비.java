import java.util.*;
import java.io.*;

public class Main {
    static class node {
        int left, right, parent;
        node(int left, int right) {
            this.left = left;
            this.right = right;
            this.parent = -1;
        }
    }
    
    static node[] tree;
    static int[] minWidth, maxWidth;
    static int maxDepth = -1, index = 1;
    static int answerD = -1, answerW = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        minWidth = new int[N + 1];
        maxWidth = new int[N + 1];
        tree = new node[N + 1];
        
        for (int i = 0; i <= N; i++) {
            minWidth[i] = Integer.MAX_VALUE;
            maxWidth[i] = Integer.MIN_VALUE;
            tree[i] = new node(-1, -1);
        }
        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tree[a].left = b;
            tree[a].right = c;
            if (tree[a].left != -1)
                tree[b].parent = a;
            
            if (tree[a].right != -1)
                tree[c].parent = a;
        }
        
        for (int i = 1; i <= N; i++) {
            if (tree[i].parent == -1) {
                dfs(i, 1);
                break;
            }
        }
        
        for (int i = 1; i <= maxDepth; i++) {
            if (answerW < maxWidth[i] - minWidth[i] + 1) {
                answerW = maxWidth[i] - minWidth[i] + 1;
                answerD = i;
            }
        }
        
        bw.write(answerD + " " + answerW);
        bw.flush();	
        bw.close();
        br.close();
    }
    
    static void dfs(int cur, int d) {
        node n = tree[cur];
        maxDepth = Math.max(maxDepth, d);
        if (n.left != -1) 
            dfs(n.left, d + 1);
        
        minWidth[d] = Math.min(minWidth[d], index);
        maxWidth[d] = Math.max(maxWidth[d], index++);
        
        if (n.right != -1)
            dfs(n.right, d + 1);
    }
}