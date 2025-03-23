package frostnight.programmers.level1;

public class InsufficientAmount {

    public long solution(int price, int money, int count) {
        long answer = 0;
        long totalPayment = 0;
        for (long i = 1; i <= count; i++) {
            totalPayment += (long)price * i;
        }
        answer = (long) (totalPayment - money);
        return answer < 0L ? 0 : answer;
    }

    public static void main(String[] args) {
        InsufficientAmount insufficientAmount = new InsufficientAmount();
        int[] prices = {3, 10, 100};
        int[] moneys = {20, 10000, 3000};
        int[] counts = {4, 6, 10};
        long[] except = {10L, 0L, 2500L};

        for (int i=0; i < prices.length; i++) {
            long result = insufficientAmount.solution(prices[i], moneys[i], counts[i]);
            if (result != except[i]) {
                System.out.println("i = " + i);
                System.out.println("except[i] = " + except[i]);
                System.out.println("result = " + result);
            }
        }
    }
}
