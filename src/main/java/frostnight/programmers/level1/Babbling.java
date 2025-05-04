package frostnight.programmers.level1;

import java.util.List;

public class Babbling {
    static final List<String> canPronunciations = List.of("aya", "ye", "woo", "ma");
    public int solution(String[] babblings) {
        int answer = 0;
        for (String babbling : babblings) {
            if (findPronunciation(babbling, "")) {
                answer++;
            }
        }
        return answer;
    }

    public boolean findPronunciation(String babbling, String prevPronunciation) {

        if ("".equals(babbling)) return true;

        for (int i = 0; i < canPronunciations.size(); i++) {
            String canPronunciation = canPronunciations.get(i);
            if (babbling.startsWith(canPronunciation) && !prevPronunciation.equals(canPronunciation)) {
                String substring = babbling.substring(canPronunciation.length());
                return findPronunciation(substring, canPronunciation);
            }
        }
        return false;
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
