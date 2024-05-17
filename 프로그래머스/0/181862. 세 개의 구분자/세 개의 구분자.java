import java.util.*;

class Solution {
    public String[] solution(String myStr) {
        String[] splitArray = myStr.split("[abc]");
        List<String> result = new ArrayList<>();
        
        for (String str : splitArray) {
            if (!str.isEmpty()) {
                result.add(str);
            }
        }
        
        if (result.isEmpty()) {
            return new String[] {"EMPTY"};
        } else {
            return result.toArray(new String[0]);
        }
    }
}