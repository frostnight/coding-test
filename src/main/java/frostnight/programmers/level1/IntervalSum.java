package frostnight.programmers.level1;

import java.util.stream.LongStream;

public class IntervalSum {

    public static long solution(int a, int b) {
        return LongStream.rangeClosed((long)Math.min(a, b), (long)Math.max(a, b)).sum();
    }

    public static void main(String[] args){
        int a = -5;
        int b = 5;
        System.out.println("solution(a, b) = " + solution(a, b));
    }
}
