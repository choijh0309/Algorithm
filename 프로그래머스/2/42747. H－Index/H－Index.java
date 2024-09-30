import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[] citations) {
        // 배열을 내림차순으로 정렬
        Integer[] sortedCitations = Arrays.stream(citations)
                                          .boxed()
                                          .toArray(Integer[]::new);
        Arrays.sort(sortedCitations, Collections.reverseOrder());

        int hIndex = 0;

        for (int i = 0; i < sortedCitations.length; i++) {
            if (sortedCitations[i] >= i + 1) {
                hIndex = i + 1;
            } else {
                break; 
            }
        }

        return hIndex;
    }
}
