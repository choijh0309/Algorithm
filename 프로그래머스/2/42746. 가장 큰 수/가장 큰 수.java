import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // Convert int array to String array
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        
        // Sort using custom comparator
        Arrays.sort(strNumbers, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1); // Reverse order
            }
        });
        
        // If, after sorting, the largest number is '0', the entire number is zero
        if (strNumbers[0].equals("0")) {
            return "0";
        }
        
        // Build the largest number
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNumbers) {
            largestNumber.append(num);
        }
        
        return largestNumber.toString();
    }
}