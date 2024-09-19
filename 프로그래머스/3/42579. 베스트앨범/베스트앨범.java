import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        class Song {
            int index; // 노래의 고유 번호
            int plays; // 노래의 재생 횟수

            Song(int index, int plays) {
                this.index = index;
                this.plays = plays;
            }
        }

        HashMap<String, Integer> genreTotalPlays = new HashMap<>();

        HashMap<String, List<Song>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i]; 
            int play = plays[i]; 

            genreTotalPlays.put(genre, genreTotalPlays.getOrDefault(genre, 0) + play);

            List<Song> list = genreSongs.getOrDefault(genre, new ArrayList<>());
            list.add(new Song(i, play)); 
            genreSongs.put(genre, list); 
        }

        // 장르를 총 재생 횟수로 내림차순 정렬
        List<String> genreOrder = new ArrayList<>(genreTotalPlays.keySet());
        genreOrder.sort((g1, g2) -> genreTotalPlays.get(g2) - genreTotalPlays.get(g1));

        List<Integer> result = new ArrayList<>();

        // 정렬된 장르 순서대로 노래 선택
        for (String genre : genreOrder) {
            List<Song> songs = genreSongs.get(genre);
            songs.sort((s1, s2) -> {
                if (s2.plays != s1.plays) {
                    return s2.plays - s1.plays; 
                } else {
                    return s1.index - s2.index; 
                }
            });
            // 최대 두 개의 노래를 결과 리스트에 추가
            int count = 0;
            for (Song song : songs) {
                result.add(song.index); 
                count++;
                if (count >= 2) break; 
            }
        }

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
