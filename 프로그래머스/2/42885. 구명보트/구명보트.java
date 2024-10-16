import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        // 사람들의 몸무게를 오름차순으로 정렬
        Arrays.sort(people);

        int answer = 0; // 필요한 구명보트의 최소 개수
        int left = 0; // 가장 가벼운 사람의 인덱스
        int right = people.length - 1; // 가장 무거운 사람의 인덱스

        while (left <= right) {
            // 가장 가벼운 사람과 가장 무거운 사람의 합이 제한 이하인지 확인
            if (people[left] + people[right] <= limit) {
                left++; // 둘이 함께 탈 수 있으므로 가벼운 사람의 인덱스를 증가
            }
            // 가장 무거운 사람은 보트에 탑승하므로 인덱스를 감소
            right--;
            // 보트의 개수 증가
            answer++;
        }

        return answer;
    }
}
