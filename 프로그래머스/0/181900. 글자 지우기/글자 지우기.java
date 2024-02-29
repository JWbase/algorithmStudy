import java.util.*;

class Solution {
    public String solution(String my_string, int[] indices) {
                ArrayList<Character> strList = new ArrayList<>();
        for(char c : my_string.toCharArray()){
            strList.add(c);
        }
        ArrayList<Integer> indicesList = new ArrayList<>();
        for(int i : indices){
            indicesList.add(i);
        }
        Collections.sort(indicesList, Collections.reverseOrder());
        for(int i : indicesList){
            strList.remove(i);
        }
        StringBuilder sb = new StringBuilder(strList.size());
        for(Character ch : strList){
            sb.append(ch);
        }
        return sb.toString();
    }
}