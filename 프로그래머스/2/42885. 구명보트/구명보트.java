import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);  // 몸무게를 오름차순으로 정렬
        int boats = 0;
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                // 가장 가벼운 사람과 가장 무거운 사람을 함께 태움
                left++;
                right--;
            } else {
                // 가장 무거운 사람만 태움
                right--;
            }
            boats++;
        }
        
        return boats;
    }
}