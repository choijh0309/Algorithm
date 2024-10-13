import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 모든 학생이 체육복을 1개씩 가지고 있다고 가정
        int[] students = new int[n];
        Arrays.fill(students, 1);

        // 도난당한 학생의 체육복 개수 감소
        for (int l : lost) {
            students[l - 1]--;
        }

        // 여벌을 가져온 학생의 체육복 개수 증가
        for (int r : reserve) {
            students[r - 1]++;
        }

        // 학생들을 순회하며 체육복 빌려주기
        for (int i = 0; i < n; i++) {
            // 체육복이 없는 경우
            if (students[i] == 0) {
                // 앞 번호 학생에게 빌리기
                if (i > 0 && students[i - 1] == 2) {
                    students[i]++;
                    students[i - 1]--;
                }
                // 뒷 번호 학생에게 빌리기
                else if (i < n - 1 && students[i + 1] == 2) {
                    students[i]++;
                    students[i + 1]--;
                }
            }
        }

        // 체육복을 가진 학생 수 카운트
        int answer = 0;
        for (int s : students) {
            if (s >= 1) {
                answer++;
            }
        }

        return answer;
    }
}
