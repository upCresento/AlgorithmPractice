package sol_230818;

public class PrimeNumber {
    static int primeNumber = 0;

    public static void main(String[] args) {
        solution(new int[] {1, 2, 7, 6, 4});
    }

    public static int solution(int[] nums) {
        int numsCnt = nums.length;
        boolean[] visited = new boolean[numsCnt];


        _combination(nums, visited, numsCnt, 3, 0);

        return primeNumber;
    }

    private static void _combination(int[] nums, boolean[] visited, int numsCnt, int round, int depth) {
        for (int i = 0; i < numsCnt; i++) {
            if (visited[i]) {
                System.out.printf("%d ", nums[i]);
            }
        }
        System.out.printf("\nround : %d / depth : %d\n", round, depth);

        if (round == 0) {
            // 조합 하나 완성
            int sum = 0;
            for (int i = 0; i < numsCnt; i++) {
                sum = visited[i] ? sum + nums[i] : sum;
            }
            if (isPrime(sum)) {
                primeNumber++;
            }
            return;
        } else {
            for (int i = depth; i < numsCnt; i++) {
                visited[i] = true;
                _combination(nums, visited, numsCnt, round - 1, i+1);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int number) {
        int n = 2;
        int sqrt = (int) Math.sqrt(number);

        while (n <= sqrt) {
            if (number % n == 0) {
                return false;
            } else {
                n++;
            }
        }

        return true;
    }
}

