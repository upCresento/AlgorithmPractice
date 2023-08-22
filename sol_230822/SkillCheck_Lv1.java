package sol_230822;

public class SkillCheck_Lv1 {

    public static void main(String[] args) {

        solution2(3);
        solution2(121);

    }

    static boolean solution1(String s) {
        boolean answer = true;

        String str = s.toLowerCase();
        int cnt = 0;

        for (char c : str.toCharArray()) {
            cnt = c == 'y' ? cnt + 1 : cnt;
            cnt = c == 'p' ? cnt - 1 : cnt;
        }

        return cnt == 0;
    }

    public static long solution2(long n) {
        double sqrt = Math.sqrt(n);
        long rePow = (long) Math.pow(Math.floor(sqrt), 2);

        return Math.pow(Math.floor(sqrt), 2) == n ? (long) Math.pow((sqrt + 1), 2) : -1;
    }
}
