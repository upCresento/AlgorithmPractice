package sol_230818;

import java.util.ArrayList;
import java.util.List;

public class TagWords {
    public static void main(String[] args) {
        int n = 3;
        String[] words = {"tank", "tick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};

        int[] answer = solution(n, words);
        System.out.println(answer[0] + "," + answer[1]);
    }

    public static int[] solution(int n, String[] words) {
        int[] answer = {};

        List<String> list = new ArrayList<>();

        int failIdx = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() <= 1) {
                failIdx = i;
                break;
            }

            if (i > 0) {
                if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                    failIdx = i;
                    break;
                }
            }

            if (list.contains(words[i])) {
                failIdx = i;
                break;

            }

            list.add(words[i]);
        }

        int person = 0;
        int turn = 0;

        if (failIdx != 0) {
            person = failIdx % n + 1;
            turn = failIdx / n + 1;
        }

        answer = new int[]{person, turn};

        return answer;
    }
}

