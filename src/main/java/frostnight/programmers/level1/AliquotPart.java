package frostnight.programmers.level1;

import java.util.HashSet;
import java.util.Set;

public class AliquotPart {
    public int solution(int left, int right) {
        int answer = 0;
        Set<Integer> aliquots = new HashSet<Integer>();
        for (int i = left; i <= right; i++) {
            aliquots.clear();
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    aliquots.add(j);
                    aliquots.add(i / j);
                }
            }
            if (aliquots.size() % 2 == 0)  {
                answer += i;
            } else {
                answer -= i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        AliquotPart aliquotPart = new AliquotPart();
        int[] left = {13, 24};
        int[] right = {17, 27};
        int[] except = {43, 52};

        for (int i = 0; i < left.length; i++) {
            int result = aliquotPart.solution(left[i], right[i]);
            if (result != except[i]) {
                System.out.println("i = " + i);
                System.out.println("except[i] = " + except[i]);
                System.out.println("result = " + result);
            }
        }
    }
}
