import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] timeInMinutes = new int[book_time.length][2];
        
        for (int i = 0; i < book_time.length; i++) {
            timeInMinutes[i][0] = convertToMinutes(book_time[i][0]);
            timeInMinutes[i][1] = convertToMinutes(book_time[i][1]) + 10;
        }
        
        Arrays.sort(timeInMinutes, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        
        int maxRooms = 0;
        
        for (int[] time : timeInMinutes) {
            while (!rooms.isEmpty() && rooms.peek() <= time[0]) {
                rooms.poll();
            }
            
            rooms.add(time[1]);
            
            maxRooms = Math.max(maxRooms, rooms.size());
        }
        
        return maxRooms;
    }
    
    private int convertToMinutes(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return hours * 60 + minutes;
    }
}