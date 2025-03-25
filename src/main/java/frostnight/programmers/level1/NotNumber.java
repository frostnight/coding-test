package frostnight.programmers.level1;

import java.util.Arrays;

public class NotNumber {
    public int solution(int[] numbers) {
        int answer = 0;
        for (int i = 0; i <= 9; i++) {
            int findNumber = i;
            if (Arrays.stream(numbers).noneMatch(num -> num == findNumber)) {
                answer += findNumber;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        NotNumber n = new NotNumber();
        int[][] numbers = {{1,2,3,4,6,7,8,0}, {5,8,4,0,6,7,9}};
        int[] except = {14, 6};

        for (int i=0; i < numbers.length; i++) {
            int result = n.solution(numbers[i]);
            if (result != except[i]) {
                System.out.println("i = " + i);
                System.out.println("except[i] = " + except[i]);
                System.out.println("result = " + result);
            }
        }
    }
}
