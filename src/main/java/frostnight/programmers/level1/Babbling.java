package frostnight.programmers.level1;

public class Babbling {

    public int solution(String[] babbling) {
        int answer = 0;
        return answer;
    }

    public static void main(String[] args) {
        String[][] babbling = {
                {"aya", "yee", "u", "maa"},
                {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"},
        };
        int[] except = {1, 2};
        Babbling b = new Babbling();
        for (int i = 0; i < babbling.length; i++) {
            int result = b.solution(babbling[i]);
            if (result != except[i]) {
                System.out.println("i = " + i);
                System.out.println("result = " + result);
                System.out.println("except = " + except[i]);
            }
        }
    }
}
