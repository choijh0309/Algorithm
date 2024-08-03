class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        int leftRight = length - 1; // 초기값은 오른쪽으로 쭉 이동하는 경우
        
        for (int i = 0; i < length; i++) {
            // 1. 상하 조작 횟수 계산
            char c = name.charAt(i);
            answer += Math.min(c - 'A', 'Z' - c + 1);
            
            // 2. 좌우 이동 횟수 계산
            int next = i + 1;
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }
            
            // 현재 위치에서 뒤로 돌아가는 경우와 계속 앞으로 가는 경우 중 최소값 선택
            leftRight = Math.min(leftRight, i + length - next + Math.min(i, length - next));
        }
        
        return answer + leftRight;
    }
}