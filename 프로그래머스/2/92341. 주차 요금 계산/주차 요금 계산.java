import java.util.*;
import java.text.*;

class Solution {
    public int toMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }

    public int calculateFee(int totalTime, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= baseTime) {
            return baseFee;
        }

        return baseFee + (int)Math.ceil((totalTime - baseTime) / (double)unitTime) * unitFee;
    }

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> totalTimeMap = new HashMap<>();
        Map<String, Integer> inTimeMap = new HashMap<>();

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String carNumber = parts[1];
            String action = parts[2];

            int minutes = toMinutes(time);

            if (action.equals("IN")) {
                inTimeMap.put(carNumber, minutes);
            } else if (action.equals("OUT")) {
                int inTime = inTimeMap.get(carNumber);
                int parkedTime = minutes - inTime;
                totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
                inTimeMap.remove(carNumber);
            }
        }

        int endOfDay = toMinutes("23:59");
        for (String carNumber : inTimeMap.keySet()) {
            int inTime = inTimeMap.get(carNumber);
            int parkedTime = endOfDay - inTime;
            totalTimeMap.put(carNumber, totalTimeMap.getOrDefault(carNumber, 0) + parkedTime);
        }

        List<String> carNumbers = new ArrayList<>(totalTimeMap.keySet());
        Collections.sort(carNumbers);

        int[] result = new int[carNumbers.size()];
        for (int i = 0; i < carNumbers.size(); i++) {
            String carNumber = carNumbers.get(i);
            int totalTime = totalTimeMap.get(carNumber);
            result[i] = calculateFee(totalTime, fees);
        }

        return result;
    }
}