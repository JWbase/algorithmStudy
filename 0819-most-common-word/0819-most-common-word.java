class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 금지어 목록이 String이므로 비교 메소드를 제공하는 Set으로 변경
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        
        // 각 단어별 개수가 저장 될 키-값 맵
        Map<String, Integer> counts = new HashMap<>();
        
        // 전처리 작업 후 단어 목록을 배열로 저장
        String[] word = paragraph.replaceAll("\\W+", " ").toLowerCase().split(" ");
        
        for (String w : word) {
            // 금지 단어가 아닌 경우 갯수 처리
            if (!ban.contains(w)) {
                counts.put(w, counts.getOrDefault(w, 0) + 1);
            }
        }
        
        return Collections.max(counts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}