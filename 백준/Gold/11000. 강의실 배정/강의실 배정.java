import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            events.add(new Event(start, 1)); // 시작 이벤트
            events.add(new Event(end, -1)); // 종료 이벤트
        }

        // 시간 순으로 이벤트 정렬
        Collections.sort(events);

        int maxRooms = 0;
        int currentRooms = 0;

        for (Event event : events) {
            currentRooms += event.type;
            maxRooms = Math.max(maxRooms, currentRooms);
        }

        System.out.println(maxRooms);
    }

    static class Event implements Comparable<Event> {
        int time;
        int type; // 1: 시작, -1: 종료

        Event(int time, int type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Event o) {
            if (this.time == o.time) {
                return this.type - o.type; // 종료 이벤트를 시작 이벤트보다 먼저 처리
            }
            return this.time - o.time;
        }
    }
}