class Solution {
    public int[] solution(String[] park, String[] routes) {
        int H = park.length;
        int W = park[0].length();
        
        int[] start = new int[2];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (park[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                    break;
                }
            }
        }
        
        int[] current = start.clone();
        
        for (String route : routes) {
            String[] cmd = route.split(" ");
            char direction = cmd[0].charAt(0);
            int distance = Integer.parseInt(cmd[1]);
            
            int nextRow = current[0];
            int nextCol = current[1];
            boolean possible = true;
            
            for (int i = 1; i <= distance; i++) {
                if (direction == 'N') nextRow = current[0] - i;
                else if (direction == 'S') nextRow = current[0] + i;
                else if (direction == 'W') nextCol = current[1] - i;
                else if (direction == 'E') nextCol = current[1] + i;
                
                if (nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W || 
                    park[nextRow].charAt(nextCol) == 'X') {
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                if (direction == 'N') current[0] -= distance;
                else if (direction == 'S') current[0] += distance;
                else if (direction == 'W') current[1] -= distance;
                else if (direction == 'E') current[1] += distance;
            }
        }
        
        return current;
    }
}