package frostnight.programmers.level1;

public class Cola {

    public int solution(int a, int b, int n) {
        int answer = 0;
        int emptyCola = n;
        while (emptyCola >= a) {
            int[] changeColaArr = market(emptyCola, a, b);
            answer += changeColaArr[0];
            emptyCola = changeColaArr[0] + changeColaArr[1];
        }
        return answer;
    }

    public int[] market(int emptyCola, int givenColaUnit, int changeColaUnit) {
        // 새로 받은 모든 콜라수와 교환하고 남은 콜라 반환
        int changeCount = emptyCola / givenColaUnit;
        int remainCount = emptyCola % givenColaUnit;
        int filledCola = changeColaUnit * changeCount;
        return new int[]{filledCola, remainCount};
    }

    public static void main(String[] args) {
        int[] aList = {3};
        int[] bList = {1};
        int[] nList = {20};

        Cola cola = new Cola();
        for (int i = 0; i < nList.length; i++) {
            int result = cola.solution(aList[i], bList[i], nList[i]);
            System.out.println("result = " + result);
        }

    }
}
