package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FindingPrimeNumber {

    static int solution(int n) {


//        int sqrt = (int) Math.sqrt((double) n);
//
//        HashSet<Integer> primeNumbers = new HashSet<>();
//
//        List<Integer> sqrtPrimes = new ArrayList<>();
//
//        IntStream.range(2, sqrt + 1).forEach( num -> {
//            boolean isPrime = true;
//            for(int i=2; i < sqrt + 1; i++){
//                if(num % i == 0 && num != i) {
//                    isPrime = false;
//                    break;
//                }
//            }
//            if(isPrime) {
//                sqrtPrimes.add(num);
//            }
//        });
//
//        IntStream.range(2, n + 1).forEach(num -> {
//            if(num == 2 || num == 3 || num == 5 || num == 7) {
//                primeNumbers.add(num);
//            } else if (num > 10) {
//                int findNum = sqrtPrimes.stream().filter(sqrtNum -> num % sqrtNum == 0 && num != sqrtNum).findFirst().orElse(0);
//                if(findNum == 0) {
//                    primeNumbers.add(num);
//                }
//            }
//        });

//        return primeNumbers.size();
        List<Integer> primeNumbers = new ArrayList<>();
        int sqrt = (int) Math.sqrt((double) n);
        IntStream.range(2, sqrt + 1).forEach(num -> {
            boolean isPrime = true;
            for(int i=2; i < sqrt +1; i++){
                if(num % i == 0 && num != i) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                primeNumbers.add(num);
            }
        });
        List<Integer> addPrimeNumbers = new ArrayList<>();
        IntStream.range(sqrt + 1, n + 1).forEach(num -> {
            boolean isPrime = true;
            for(int i=0; i < primeNumbers.size(); i++){
                int num_ = primeNumbers.get(i);
                if(num % num_ == 0 && num != num_) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                addPrimeNumbers.add(num);
            }
        });
        return primeNumbers.size() + addPrimeNumbers.size();

    }


    public static void main(String[] args){
        int number = 1000000;
        long start_time = System.currentTimeMillis();
        int result = FindingPrimeNumber.solution(number);
        System.out.println("result = " + result);
        long end_time = System.currentTimeMillis();
        System.out.println("end_time-start_time = " + ((end_time-start_time)));
        // 78498
        // 78330
        // 437ms
    }
}
