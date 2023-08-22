package sol_230818;

public class Bracket {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }

    public static boolean solution(String s) {
        char openBracket = '(';

        char[] brackets = s.toCharArray();

        int pair = 0;
        for (char bracket : brackets) {
            pair += bracket == openBracket ? 1 : -1;
            if (pair < 0) return false;
        }

        return pair == 0;
    }
}
