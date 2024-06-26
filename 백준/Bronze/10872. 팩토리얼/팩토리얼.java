import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int sum = 1;
        
        while (N != 0) {
            sum = sum * N;
            N--;
        }
        
        System.out.println(sum);
    }
}