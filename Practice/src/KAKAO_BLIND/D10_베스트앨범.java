package KAKAO_BLIND;

import java.util.*;

/**
 * 장르별로 많이 재생된 노래 두 개씩 뽑기
 * 수록 기준
 * - 속한 노래가 많이 재생된 장르 먼저 수록
 * - 장르 내에서 많이 재생된 노래 먼저 수록
 * - 장르 내에서 재생 횟수가 같다면 고유먼호 오름차순
 */
public class D10_베스트앨범 {

    public static void main(String[] args) {

        int[] solution = solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500});
        System.out.println(Arrays.toString(solution));
    }

    private static int[] solution(String[] genres, int[] plays) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0)+plays[i]);
        }

        List<Genre> list = new LinkedList<>();
        map.forEach((s, integer) -> {
            list.add(new Genre(s, integer));
        });

        Collections.sort(list);

        Map<String, Integer> genreNum = new HashMap<>();
        int k = 0;
        for(Genre g: list){
            genreNum.put(g.genre, k++);
        }
        // 장르 번호가 작을 수록 빈도수 높음
        int[] genreCnt = new int[k];

        List<Music> musicList = new LinkedList<>();
        for (int i = 0; i < genres.length; i++) {
            int no = i; //고유 번호
            int genreNo = genreNum.get(genres[i]);
            int cnt = plays[i];
            musicList.add(new Music(no, genreNo, cnt));
        }

        Collections.sort(musicList);
        List<Integer> res = new LinkedList<>();
        for(Music m: musicList){
            int no = m.no;
            int genreNo = m.genreNo;
            int cnt = m.cnt;
            if (genreCnt[genreNo] >= 2) continue;
            res.add(no);
            genreCnt[genreNo]++;
        }

        int[] answer = new int[res.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    static class Music implements Comparable<Music>{
        int no;
        int genreNo;
        int cnt;

        public Music(int no, int genreNo, int cnt) {
            this.no = no;
            this.genreNo = genreNo;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Music o) {
            if (this.genreNo == o.genreNo) {
                if (this.cnt == o.cnt){
                    return Integer.compare(this.no, o.no);
                }
                // 내림차순
                return Integer.compare(o.cnt, this.cnt);
            }
            // 오름차순
            return Integer.compare(this.genreNo, o.genreNo);
        }
    }

    static class Genre implements Comparable<Genre>{
        String genre;
        int cnt;

        public Genre(String genre, int cnt){
            this.genre = genre;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Genre o){
            // 내림차순
            return Integer.compare(o.cnt, this.cnt);
        }
    }
}
