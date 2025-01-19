import java.util.*;

class Solution {
    ArrayList<String> answer;
    HashMap<String, PriorityQueue<String>> graph;
    
    public String[] solution(String[][] tickets) {
        answer = new ArrayList<>();
        graph = new HashMap<>();
        
        for(String[] ticket : tickets) {
            graph.putIfAbsent(ticket[0], new PriorityQueue<>());
            graph.get(ticket[0]).add(ticket[1]);
        }
        
        dfs("ICN");
        
        Collections.reverse(answer);
        return answer.toArray(new String[0]);
    }
    
    public void dfs(String current) {
        while(graph.containsKey(current) && !graph.get(current).isEmpty()) {
            dfs(graph.get(current).poll());
        }
        answer.add(current);
    }
}