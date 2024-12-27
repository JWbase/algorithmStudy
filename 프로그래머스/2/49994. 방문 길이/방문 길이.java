import java.util.*;

class Solution {
    
    private static boolean validate(int nx, int ny) {
        return nx >= 0 && nx < 11 && ny >= 0 && ny < 11;
    }
    
    Map<Character, int[]> directions = new HashMap<>();
    private void init() {
        directions.put('U', new int[]{0, 1});
        directions.put('D', new int[]{0, -1});
        directions.put('L', new int[]{-1, 0});
        directions.put('R', new int[]{1, 0});
    }
    
    public int solution(String dirs) {
        init();
        int x = 5, y = 5;
        Set<String> records = new HashSet<>();
        for(int i = 0; i < dirs.length(); i++) {
            int[] offset = directions.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];
            if (!validate(nx, ny)) {
                continue;
            }
            records.add(x + " " + y + " " + nx + " " + ny);
            records.add(nx + " " + ny + " " + x + " " + y);
            x = nx;
            y = ny;
        }
        
        return records.size() / 2;
    }
}