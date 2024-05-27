class Solution {
    public int solution(String[] order) {
        int totalCost = 0;
        for (String item : order) {
            // "아무거나" 또는 "아메리카노"만 적혀있는 경우 차가운 아메리카노로 통일
            if (item.equals("anything") || item.equals("americano")) {
                totalCost += 4500;
            }
            // 차가운 아메리카노
            else if (item.contains("iceamericano") || item.contains("americanoice")) {
                totalCost += 4500;
            }
            // 따뜻한 아메리카노
            else if (item.contains("hotamericano") || item.contains("americanohot")) {
                totalCost += 4500;
            }
            // 차가운 카페 라테 또는 "카페 라테"만 적혀있는 경우 차가운 카페 라테로 통일
            else if (item.contains("icecafelatte") || item.contains("cafelatteice") || item.equals("cafelatte")) {
                totalCost += 5000;
            }
            // 따뜻한 카페 라테
            else if (item.contains("hotcafelatte") || item.contains("cafelattehot")) {
                totalCost += 5000;
            }
        }
        return totalCost;
    }
}