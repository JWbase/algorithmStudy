import java.util.*;

class Solution {
     public int[] solution(String[] id_list, String[] report, int k) {
        // 예외 처리
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        Map<String, List<String>> reportLog = new HashMap<>();
        for (String r : reportSet) {
            String[] person = r.split(" ");
            List<String> list = reportLog.getOrDefault(person[1], new ArrayList<>());
            list.add(person[0]);
            reportLog.put(person[1], list);
        }

        Map<String, Integer> mailCounts = new HashMap<>();
        for (Map.Entry<String, List<String>> log : reportLog.entrySet()) {
            if (log.getValue().size() >= k) {
                for (String people : log.getValue()) {
                    mailCounts.put(people, mailCounts.getOrDefault(people, 0) + 1);
                }
            }
        }

        return Arrays.stream(id_list)
                .map(x -> mailCounts.getOrDefault(x, 0))
                .mapToInt(Integer::valueOf)
                .toArray();
    }
}