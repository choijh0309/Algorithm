import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] arr;
        
        int testcase = sc.nextInt();
        
        for (int i = 0; i < testcase; i++) {
            int a = sc.nextInt();
            arr = new int[a];
            
            double sum = 0;
            for (int j = 0; j < a; j++) {
                int val = sc.nextInt();
                arr[j] = val;
                sum += val;
            }
            double mean = (sum / a);
            double count = 0;
            
            for (int j = 0; j < a; j++) {
                if (arr[j] > mean) {
                    count++;
                }
            }
            System.out.printf("%.3f%%\n", (count / a) * 100);
        }
    }
}