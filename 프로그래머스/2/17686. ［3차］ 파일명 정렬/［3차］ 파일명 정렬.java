import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .sorted((file1, file2) -> {
                    String[] file1Parts = splitFileName(file1);
                    String[] file2Parts = splitFileName(file2);

                    int headCompare = file1Parts[0].compareToIgnoreCase(file2Parts[0]);
                    if (headCompare != 0) {
                        return headCompare;
                    }

                    int numberCompare = Integer.compare(Integer.parseInt(file1Parts[1]), Integer.parseInt(file2Parts[1]));
                    if (numberCompare != 0) {
                        return numberCompare;
                    }

                    return 0;
                })
                .toArray(String[]::new);
    }

    private static String[] splitFileName(String file) {
        String head = "";
        String number = "";
        int i = 0;

        while (i < file.length() && !Character.isDigit(file.charAt(i))) {
            head += file.charAt(i);
            i++;
        }

        while (i < file.length() && Character.isDigit(file.charAt(i))) {
            number += file.charAt(i);
            i++;
        }

        return new String[]{head, number};
    }
}