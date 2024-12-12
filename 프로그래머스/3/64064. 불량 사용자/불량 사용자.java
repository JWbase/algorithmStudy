import java.util.*;

class Solution {
    private Set<Set<String>> result;
    
    public int solution(String[] user_id, String[] banned_id) {
        result = new HashSet<>();
        List<List<String>> matches = new ArrayList<>();
        
        for (String banned : banned_id) {
            List<String> matchingUsers = new ArrayList<>();
            for (String user : user_id) {
                if (isMatch(user, banned)) {
                    matchingUsers.add(user);
                }
            }
            matches.add(matchingUsers);
        }
        
        findCombinations(matches, new HashSet<>(), 0);
        
        return result.size();
    }
    
    private boolean isMatch(String userId, String bannedId) {
        if (userId.length() != bannedId.length()) {
            return false;
        }
        
        for (int i = 0; i < userId.length(); i++) {
            if (bannedId.charAt(i) != '*' && bannedId.charAt(i) != userId.charAt(i)) {
                return false;
            }
        }
        return true;
    }
    
    private void findCombinations(List<List<String>> matches, Set<String> current, int depth) {
        if (depth == matches.size()) {
            result.add(new HashSet<>(current));
            return;
        }
        
        for (String userId : matches.get(depth)) {
            if (!current.contains(userId)) {
                current.add(userId);
                findCombinations(matches, current, depth + 1);
                current.remove(userId);
            }
        }
    }
}