import java.util.*;

class Solution {
    static int MAX = 10000000;
    static boolean[] isPrime = new boolean[MAX];
    static Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        Arrays.fill(isPrime, true);
        sieveOfEratosthenes();

        char[] digits = numbers.toCharArray();
        
        boolean[] visited = new boolean[digits.length];

        generateNumbers("", digits, visited);

        int count = 0; 

        for (int num : numberSet) {
            if (isPrime[num] && num > 1) {
                count++;
            }
        }

        return count;
    }

    private void sieveOfEratosthenes() {
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    // 가능한 모든 숫자 조합을 생성하는 함수
    private void generateNumbers(String current, char[] digits, boolean[] visited) {
        if (!current.equals("")) {
            int num = Integer.parseInt(current);
            numberSet.add(num); 
        }

        // 모든 자리의 숫자를 시도
        for (int i = 0; i < digits.length; i++) {
            if (!visited[i]) {
                visited[i] = true; 
                generateNumbers(current + digits[i], digits, visited); 
                visited[i] = false; 
            }
        }
    }
}
