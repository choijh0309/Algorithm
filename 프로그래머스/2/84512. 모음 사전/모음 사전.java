class Solution {
    int cnt = 0; // 단어의 순서를 카운트하는 변수
    int result = 0; // 결과를 저장하는 변수
    String target; // 찾고자 하는 단어
    boolean found = false; // 단어를 찾았는지 여부를 나타내는 변수

    public int solution(String word) {
        target = word; // 찾고자 하는 단어를 저장
        dfs(""); // 깊이 우선 탐색 시작
        return result; // 결과 반환
    }

    // 모든 가능한 단어를 생성하는 깊이 우선 탐색 함수
    private void dfs(String current) {
        if (found) {
            return; // 단어를 찾았으면 더 이상 탐색하지 않음
        }

        if (current.length() > 5) {
            return; // 단어의 길이가 5를 초과하면 종료
        }

        // 현재 단어가 빈 문자열이 아닌 경우에만 카운트 증가
        if (!current.isEmpty()) {
            cnt++; // 단어의 순서를 증가

            if (current.equals(target)) {
                result = cnt; // 결과 저장
                found = true; // 단어를 찾았음을 표시
                return;
            }
        }

        // 각 모음에 대해 재귀적으로 탐색
        for (char c : new char[]{'A', 'E', 'I', 'O', 'U'}) {
            dfs(current + c); // 현재 단어에 모음을 추가하여 다음 단계로 진행
        }
    }
}
