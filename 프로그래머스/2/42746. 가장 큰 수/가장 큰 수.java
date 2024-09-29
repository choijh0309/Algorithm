import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 두 문자열을 이어붙인 결과를 비교하여 내림차순 정렬
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        if (nums[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();
        for (String num : nums) {
            answer.append(num);
        }

        return answer.toString();
    }
}
