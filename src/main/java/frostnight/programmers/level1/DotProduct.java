package frostnight.programmers.level1;

/**
 * 길이가 같은 두 1차원 정수 배열 a, b가 매개변수로 주어집니다. a와 b의 내적을 return 하도록 solution 함수를 완성해주세요.
 *
 * 이때, a와 b의 내적은 a[0]*b[0] + a[1]*b[1] + ... + a[n-1]*b[n-1] 입니다. (n은 a, b의 길이)
 */
public class DotProduct {

    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        DotProduct dotProduct = new DotProduct();
        int[][] a = {{1,2,3,4},{-1,0,1},{3,4,-5,7,-10,9}};
        int[][] b = {{-3,-1,0,2},{1,0,-1},{9,15,-30,2,11,0}};
        int[] except = {3, -2, 141};

        for (int i = 0; i < a.length; i++) {
            int result = dotProduct.solution(a[i], b[i]);
            if (result != except[i]) {
                System.out.println("i = " + i);
                System.out.println("except[i] = " + except[i]);
                System.out.println("result = " + result);
            }
        }
    }
}
