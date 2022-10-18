package L2_연습문제;

import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class D11_캐시 {

    public static void main(String[] args) {
        Assertions.assertEquals(50, solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        Assertions.assertEquals(25, solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
    }

    /**
     * 캐시 범위는 0<=cacheSize<=30
     * 최대 도시 수는 100,000
     * 캐시 알고리즘은 LRU(Least Recently Used) 가장 오래 쓰이지 않은 것 삭제
     * cache hit = 1
     * cache miss = 5
     * @param cacheSize
     * @param cities
     * @return 실행시간 측정
     */
    private static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        if (cacheSize == 0) return cities.length*5;
        for(String city: cities){
            city = city.toUpperCase();
            cnt++;
            if (map.containsKey(city)){
                map.put(city, cnt);
                answer += 1;
            }else{
                answer += 5;
                if (map.size() < cacheSize){
                    map.put(city, cnt);
                }else{
                    String remove = "";
                    int removeCnt = 100000;
                    for(String k: map.keySet()){
                        int kk = map.get(k);
                        if (removeCnt > kk){
                            removeCnt = kk;
                            remove = k;
                        }
                    }
                    map.remove(remove);
                    map.put(city, cnt);
                }
            }
        }
        return answer;
    }
}
