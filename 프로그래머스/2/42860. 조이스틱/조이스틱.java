class Solution {
    public int solution(String name) {
        int length = name.length();
        int answer = 0; // 총 조작 횟수를 저장할 변수

        // 각 문자별로 위아래 조작 횟수를 계산하여 합산
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            // 위로 조작하는 경우와 아래로 조작하는 경우 중 최소값 선택
            int upDown = Math.min(c - 'A', 'Z' - c + 1);
            answer += upDown;
        }

        int minMove = length - 1; // 좌우 이동 최소 횟수 초기값 (맨 오른쪽까지 이동하는 경우)

        // 각 위치에서 좌우 이동 방법을 계산하여 최소 이동 횟수 갱신
        for (int i = 0; i < length; i++) {
            int next = i + 1;

            // 연속된 'A'의 개수를 찾음
            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // 현재 위치까지 왔다가 되돌아가는 경우의 이동 횟수 계산
            int move = (i * 2) + (length - next);
            // 처음부터 뒤로 이동하는 경우의 이동 횟수 계산
            int reverseMove = (length - next) * 2 + i;

            // 최소 이동 횟수 갱신
            minMove = Math.min(minMove, Math.min(move, reverseMove));
        }

        answer += minMove; // 총 조작 횟수에 좌우 이동 최소 횟수 추가

        return answer;
    }
}
