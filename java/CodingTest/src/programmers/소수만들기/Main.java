package programmers.소수만들기;

public class Main {

    static int result = 0;
    public int solution(int[] nums) {
        int answer = 0;
        boolean[] primes = getPrime();
        boolean[] checked = new boolean[nums.length];
        combination(nums, checked, 0, nums.length, 3, primes);
        answer = result;
        return answer;
    }

    private void combination(int[] nums, boolean[] checked, int index, int n, int r, boolean[] primes) {
        if (r == 0) {
            int sum = 0;
            for (int i=0; i<nums.length; i++) {
                if (checked[i] == true) {
                    sum += nums[i];
                }
            }
            if (primes[sum] == false)
               result++;
            return;
        }

        for (int i=index; i<n; i++) {
            checked[i] = true;
            combination(nums, checked, i + 1, n, r - 1, primes);
            checked[i] = false;
        }
    }

    private boolean[] getPrime() {
        boolean[] primes = new boolean[50001];
        primes[1] = true;
        for (int i=2; i<=50000; i++) {
            if (primes[i] == true)
                continue;
            for (int j = i + i; j <= 50000; j += i) {
                primes[j] = true;
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(new Main().solution(new int[] {1, 2, 3, 4}));
    }
}
