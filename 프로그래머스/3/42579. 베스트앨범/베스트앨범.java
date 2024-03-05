import java.util.*;

class Solution {
    class Song implements Comparable<Song> {
        int no;
        int play;

        public Song(int no, int play) {
            this.no = no;
            this.play = play;
        }

        public int compareTo(Song other) {
            if (this.play == other.play) {
                return this.no - other.no;
            } else {
                return -(this.play - other.play);
            }
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, PriorityQueue<Song>> songMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            int play = plays[i];
            String genre = genres[i];

            genreMap.put(genre, genreMap.getOrDefault(genre, 0) + play);
            if (!songMap.containsKey(genre)) {
                songMap.put(genre, new PriorityQueue<>());
            }

            songMap.get(genre).offer(new Song(i, play));
        }

        List<String> keySetList = new ArrayList<>(genreMap.keySet());
        Collections.sort(keySetList, (value1, value2) -> (genreMap.get(value2).compareTo(genreMap.get(value1))));

        List<Integer> bestAlbum = new ArrayList<>();
        for (String key : keySetList) {
            PriorityQueue<Song> temp = songMap.get(key);
            bestAlbum.add(temp.poll().no);
            if (!temp.isEmpty()) {
                bestAlbum.add(temp.poll().no);
            }
        }

        int[] answer = new int[bestAlbum.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = bestAlbum.get(i);
        }

        return answer;
    }
}