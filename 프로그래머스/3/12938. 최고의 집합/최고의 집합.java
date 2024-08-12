import java.util.Arrays;

class Solution {
    public int[] solution(int n, int s) {
        // 최고의 집합이 존재하지 않는 경우
        if (n > s) {
            return new int[]{-1};
        }
        
        int[] answer = new int[n];
        int quotient = s / n;
        int remainder = s % n;
        
        // 기본값으로 몫을 채움
        Arrays.fill(answer, quotient);
        
        // 나머지를 1씩 분배
        for (int i = n - 1; i >= n - remainder; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}