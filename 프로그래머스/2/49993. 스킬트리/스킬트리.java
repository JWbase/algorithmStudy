import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            int skillIndex = 0;
            boolean isValid = true;

            for (int i = 0; i < skillTree.length(); i++) {
                char currentSkill = skillTree.charAt(i);

                if (skill.indexOf(currentSkill) != -1) {
                    if (skill.charAt(skillIndex) == currentSkill) {
                        skillIndex++;
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            if (isValid) {
                answer++;
            }
        }

        return answer;
    }
    
}