import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }

        Set<String> cache = new LinkedHashSet<>(cacheSize);
        int totalTime = 0;

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)) {
                totalTime += 1;
                cache.remove(city);
                cache.add(city);
            } else {
                totalTime += 5;
                if (cache.size() == cacheSize) {
                    String firstCity = cache.iterator().next();
                    cache.remove(firstCity);
                }
                cache.add(city);
            }
        }

        return totalTime;
    }
}