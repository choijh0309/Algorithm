import java.util.Arrays;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] arrivalTimes = Arrays.stream(timetable)
                                   .mapToInt(time -> convertToMinutes(time))
                                   .sorted()
                                   .toArray();

        int shuttleTime = convertToMinutes("09:00");
        int idx = 0;
        int lastTime = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;

            while (idx < arrivalTimes.length && arrivalTimes[idx] <= shuttleTime && count < m) {
                lastTime = arrivalTimes[idx];
                count++;
                idx++;
            }

            if (i == n - 1) {
                if (count < m) {
                    return convertToTimeString(shuttleTime);
                } else {
                    return convertToTimeString(lastTime - 1);
                }
            }
            
            shuttleTime += t;
        }

        return "";
    }

    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    private String convertToTimeString(int minutes) {
        int hours = minutes / 60;
        int mins = minutes % 60;
        return String.format("%02d:%02d", hours, mins);
    }
}
