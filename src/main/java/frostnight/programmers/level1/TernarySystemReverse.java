package frostnight.programmers.level1;

public class TernarySystemReverse {

    public int solution(int n) {
        String ternary = Integer.toString(n, 3);
        String reverseTernary = new StringBuffer(ternary).reverse().toString();
        return Integer.parseInt(reverseTernary, 3);
    }

    public static void main(String[] args) {
        TernarySystemReverse ternarySystemReverse = new TernarySystemReverse();
        int[] numbers = {45, 125};
        int[] except = {7, 229};

        for (int i = 0; i < numbers.length; i++) {
            int result = ternarySystemReverse.solution(numbers[i]);
            if (result != except[i]) {
                System.out.println("i = " + i);
                System.out.println("except[i] = " + except[i]);
                System.out.println("result = " + result);
            }
        }
    }
}
