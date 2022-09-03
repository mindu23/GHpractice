package KAKAO_BLIND;

import java.util.*;

public class D21_주차요금계산 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"})));
    }

    /**
     * // 입차 후 출차된 내역이 없다면 23:59 출차
     * @param fees 기본 시간(분), 기본 요금(원), 단위 시간(분), 단위 요금(원)
     * @param records String: 시각(24) 차량번호 내역(IN/OUT)
     * @return
     */
    private static int[] solution(int[] fees, String[] records) {
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, Integer> carT = new HashMap<>();
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            Integer carN = Integer.parseInt(st.nextToken());
            String command = st.nextToken();
            if (command.equals("IN")){
                map.put(carN, time);
            }else { // OUT
                int t = carTime(map.get(carN), time);
                carT.put(carN, carT.getOrDefault(carN, 0) + t);
                map.remove(carN);
            }
        }

        for(Integer carN: map.keySet()){
            int pay = carTime(map.get(carN), "23:59");
            carT.put(carN, carT.getOrDefault(carN, 0) + pay);
            map.remove(carN);
        }

        List<Integer> keySet = new ArrayList<>(carT.keySet());
        Collections.sort(keySet);

        int[] answer = new int[carT.size()];
        for(int i = 0; i < keySet.size(); i++){
            int key = keySet.get(i);
            answer[i] = carOut(carT.get(key), fees);
        }
        return answer;
    }

    private static int carTime(String s, String time){
        String[] inTime = s.split(":");
        String[] outTime = time.split(":");
        int h = Integer.parseInt(outTime[0]) - Integer.parseInt(inTime[0]);
        int m = Integer.parseInt(outTime[1]) - Integer.parseInt(inTime[1]);
        return h*60 + m;
    }

    private static int carOut(int p, int[] fees){
        int pay = 0;
        double allM = p;
        allM = allM - fees[0];
        if (allM <= 0) return fees[1];
        pay += fees[1] + Math.ceil(allM/fees[2])*fees[3];
        return pay;
    }
}
