import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingTrucks = new LinkedList<>();
        for (int truck : truck_weights) {
            waitingTrucks.offer(truck);
        }

        Queue<Integer> bridge = new LinkedList<>();
        int totalWeightOnBridge = 0;
        int time = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        while (!bridge.isEmpty()) {
            time++;

            int leavingTruck = bridge.poll();
            totalWeightOnBridge -= leavingTruck;

            if (!waitingTrucks.isEmpty()) {
                if (totalWeightOnBridge + waitingTrucks.peek() <= weight) {
                    int nextTruck = waitingTrucks.poll();
                    bridge.offer(nextTruck);
                    totalWeightOnBridge += nextTruck;
                } else {
                    bridge.offer(0);
                }
            }
        }

        return time;
    }
}
