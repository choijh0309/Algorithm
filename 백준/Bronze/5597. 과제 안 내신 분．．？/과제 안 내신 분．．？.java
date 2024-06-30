import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] stu = new int[31];
        
        for (int i = 1; i < 29; i++) {
            int suc = sc.nextInt();
            stu[suc] = 1; 
        }
        for (int i = 1; i < stu.length; i++) {
            if (stu[i] != 1) System.out.println(i);
        }
    }
}