import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생 횟수를 저장하는 Map
        Map<String, Integer> genrePlayCount = new HashMap<>();
        // 장르별 노래 정보를 저장하는 Map
        Map<String, ArrayList<Song>> genreSongs = new HashMap<>();
        
        // 데이터 처리
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            // 장르별 총 재생 횟수 계산
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + play);
            
            // 장르별 노래 정보 저장
            if (!genreSongs.containsKey(genre)) {
                genreSongs.put(genre, new ArrayList<>());
            }
            genreSongs.get(genre).add(new Song(i, play));
        }
        
        // 장르를 총 재생 횟수 내림차순으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((a, b) -> genrePlayCount.get(b) - genrePlayCount.get(a));
        
        // 결과 리스트
        ArrayList<Integer> answer = new ArrayList<>();
        
        // 장르별로 노래 선택
        for (String genre : sortedGenres) {
            ArrayList<Song> songs = genreSongs.get(genre);
            songs.sort((a, b) -> b.play - a.play); // 재생 횟수 내림차순 정렬
            
            answer.add(songs.get(0).id); // 가장 많이 재생된 노래
            if (songs.size() > 1) {
                answer.add(songs.get(1).id); // 두 번째로 많이 재생된 노래
            }
        }
        
        // ArrayList를 int 배열로 변환
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    // 노래 정보를 저장하는 내부 클래스
    class Song {
        int id;
        int play;
        
        Song(int id, int play) {
            this.id = id;
            this.play = play;
        }
    }
}