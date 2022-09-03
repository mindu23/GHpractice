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
        // 현재 주차중인 차:시간(분)
        Map<String, Integer> parkingCar = new HashMap<>();
        // 주차된 차:누적 시간(분)
        Map<String, Integer> timeCar = new HashMap<>();
        for (String record : records) {
            StringTokenizer st = new StringTokenizer(record);
            String time = st.nextToken();
            String carN = st.nextToken();
            if (parkingCar.containsKey(carN)){
                // OUT
                timeCar.put(carN, timeCar.getOrDefault(carN, 0) + getTime(time) - parkingCar.get(carN));
                parkingCar.remove(carN);
            }else {
                // IN
                parkingCar.put(carN, getTime(time));
            }
        }

        // 아직 안나간 차
        for(String s: parkingCar.keySet()){
            timeCar.put(s, timeCar.getOrDefault(s, 0) + getTime("23:59") - parkingCar.get(s));
        }

        List<String> keySet = new ArrayList<>(timeCar.keySet());
        Collections.sort(keySet); // 차번호 오름차순

        int[] answer = new int[keySet.size()];
        for (int i = 0; i < keySet.size(); i++) {
            int r = timeCar.get(keySet.get(i));
            answer[i] = getPay(r, fees);
        }

        return answer;
    }

    private static int getPay(int r, int[] fees) {
        if (r-fees[0] <= 0) return fees[1];
        return fees[1] + (int)(Math.ceil((r-fees[0])/(double)fees[2]) * fees[3]);
    }

    private static Integer getTime(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60 + Integer.parseInt(t[1]);
    }


}
