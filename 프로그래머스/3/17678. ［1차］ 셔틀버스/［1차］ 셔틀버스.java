import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        int[] crewTimes = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] parts = timetable[i].split(":");
            crewTimes[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
        }
        
        Arrays.sort(crewTimes);
        
        int busTime = 9 * 60;
        int crewIndex = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int count = 0;
            while (crewIndex < crewTimes.length && crewTimes[crewIndex] <= busTime && count < m) {
                crewIndex++;
                count++;
            }
            busTime += t;
        }
        
        int lastBusTime = busTime;
        int remainingSeats = m;
        int lastCrewTime = 0;
        
        while (crewIndex < crewTimes.length && crewTimes[crewIndex] <= lastBusTime && remainingSeats > 0) {
            lastCrewTime = crewTimes[crewIndex];
            crewIndex++;
            remainingSeats--;
        }
        
        int conTime;
        if (remainingSeats > 0) {
            conTime = lastBusTime;
        } else {
            conTime = lastCrewTime - 1;
        }
        
        return String.format("%02d:%02d", conTime / 60, conTime % 60);
    }
}