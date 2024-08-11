import java.util.Arrays;

public class Solution {

    public static int solution(int[] A, int[] B) {
        // 배열을 정렬합니다.
        Arrays.sort(A);
        Arrays.sort(B);
        
        // 포인터를 초기화합니다.
        int aPtr = 0;
        int bPtr = 0;
        int score = 0;
        
        // A팀의 모든 숫자에 대해 B팀의 숫자를 비교합니다.
        while (aPtr < A.length && bPtr < B.length) {
            // B팀의 숫자가 A팀의 숫자보다 크면 B팀이 승리합니다.
            if (B[bPtr] > A[aPtr]) {
                score++;
                aPtr++;
            }
            bPtr++;
        }
        
        return score;
    }

    public static void main(String[] args) {
        // 테스트를 위한 예제
        int[] A = {1, 3, 5, 7};
        int[] B = {2, 4, 6, 8};
        
        // 함수 호출
        int result = solution(A, B);
        
        // 결과 출력
        System.out.println("Maximum score for team B: " + result);
    }
}
