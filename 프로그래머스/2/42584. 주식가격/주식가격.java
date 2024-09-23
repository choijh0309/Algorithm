import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int idx = stack.pop(); 
                answer[idx] = i - idx;
            }
            stack.push(i); 
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = n - idx - 1; // 총 기간에서 현재 인덱스를 빼서 남은 기간 계산
        }

        return answer;
    }
}
