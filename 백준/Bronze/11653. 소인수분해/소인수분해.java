import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 2; i * i <= N; i++) {
            while (N % i == 0) {
                sb.append(i).append('\n');
                N /= i;
            }
        }
        
        if (N != 1) {
            sb.append(N);
        }
        System.out.println(sb);
    }
}