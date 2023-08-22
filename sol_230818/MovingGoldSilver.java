package sol_230818;

public class MovingGoldSilver {
    public static void main(String[] args) {

    }

    public static long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = -1;

        long maxTime = 400000000000000L;
        long minTime = 0L;

        // 이분탐색
        while (minTime + 1 < maxTime) {
            long midTime = (minTime + maxTime) / (long) 2;

            if (_isPossible(midTime, a, b, g, s, w, t)) {
                maxTime = midTime;
            } else {
                minTime = midTime;
            }
        }

        answer = maxTime;

        return answer;
    }

    public static boolean _isPossible(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long totalW = 0L;
        long totalG = 0L;
        long totalS = 0L;

        for (int i = 0; i < t.length; i++) {
            // 주어진 시간 당 옮길수 있는 최대 횟수
            long cnt = time / (2L * t[i]);
            if (time % (2L * t[i]) >= t[i]) cnt++;

            // 도시당 시간 내에 옮길 수 있는 무게
            long capa = Math.min(cnt * w[i], g[i] + s[i]);

            // 전체 무게 누적
            totalW += capa;

            // 전체 금 무게 누적(보유량, 운송가능량 중 작은 값)
            totalG += Math.min(g[i], capa);

            // 전체 은 무게 누적
            totalS = Math.min(s[i], capa);

        }
        // 운송가능?
        return totalW >= a + b && totalG >= a && totalS >= b;
    }
}
