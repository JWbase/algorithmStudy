import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        int maxValue = 0;
        for (int i = 0; i < n; i++) {
            String bookName = br.readLine();
            if (!map.containsKey(bookName)) {
                map.put(bookName, 1);
            } else map.put(bookName, map.get(bookName) + 1);
            maxValue = Math.max(maxValue, map.get(bookName));
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() == maxValue) {
                list.add(stringIntegerEntry.getKey());
            }
        }
        Collections.sort(list);
        System.out.print(list.get(0));

    }


    public static void main(String[] args) throws IOException {
        solution();
    }

}