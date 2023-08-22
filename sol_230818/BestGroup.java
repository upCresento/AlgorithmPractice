package sol_230818;

public class BestGroup {
    public static void main(String[] args) {
        for(int i : solution(2, 9)) {
            System.out.print(i + " ");
        }
    }
    public static int[] solution(int n, int s) {
        if (n > s) return new int[]{-1};

        int[] answer = new int[n];
        int i = 0;
        while (n > 0) {
            int mid = s / n;
            System.out.println(n + " : " + mid);
            answer[i] = mid;
            s -= mid;
            n--;
            i++;
        }
        return answer;
    }
}
