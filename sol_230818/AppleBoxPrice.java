package sol_230818;

import java.util.Arrays;

public class AppleBoxPrice {
    public static void main(String[] args) {
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

        System.out.println(solution(k, m, score));
    }

    public static int solution(int k, int m, int[] score) {
        int answer = 0;

        // 이익이 발생하지 않는 경우
        if (score.length < m) {
            return 0;
        }

        // score 정렬
        int[] sortedScore = Arrays.stream(score).sorted().toArray();
        int startIdx = score.length % m == 0 ? 0 : score.length % m;

        for (int i = startIdx; i < sortedScore.length; i+=m) {
            System.out.printf("[%d] : %d\n", i, sortedScore[i]);
            answer += sortedScore[i] * m;
        }

        // 다른 방법
        Arrays.sort(score);

        for (int j = score.length; j >= m; j -= m) {
            answer += score[j - m] * m;
        }
        // 유레카.......

        return answer;
    }
}
