import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> userMap = new HashMap<>();
        List<String> actions = new ArrayList<>();
        List<String> userIds = new ArrayList<>();
        
        for (String entry : record) {
            String[] parts = entry.split(" ");
            String command = parts[0];
            String userId = parts[1];
            
            if (command.equals("Enter")) {
                String nickname = parts[2];
                userMap.put(userId, nickname);
                actions.add("Enter");
                userIds.add(userId);
            } else if (command.equals("Leave")) {
                actions.add("Leave");
                userIds.add(userId);
            } else if (command.equals("Change")) {
                String nickname = parts[2];
                userMap.put(userId, nickname);
            }
        }
        
        String[] result = new String[actions.size()];
        for (int i = 0; i < actions.size(); i++) {
            String action = actions.get(i);
            String userId = userIds.get(i);
            String nickname = userMap.get(userId);
            
            if (action.equals("Enter")) {
                result[i] = nickname + "님이 들어왔습니다.";
            } else if (action.equals("Leave")) {
                result[i] = nickname + "님이 나갔습니다.";
            }
        }
        
        return result;
    }
}