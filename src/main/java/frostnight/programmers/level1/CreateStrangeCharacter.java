package frostnight.programmers.level1;

public class CreateStrangeCharacter {

    /*
        문자열 s는 한 개 이상의 단어로 구성되어 있습니다.
        각 단어는 하나 이상의 공백문자로 구분되어 있습니다.
        각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
    */

    public String solution(String s) {
        char[] charArray = s.toCharArray();
        StringBuffer result = new StringBuffer();
        int wordIndex = 0;

        for(char c: charArray) {
            if( c == ' ') {
                wordIndex = 0;
                result.append(c);
                continue;
            }

            if(wordIndex % 2 == 0 && wordIndex != 1){
                result.append(Character.toUpperCase(c));
            } else {
                result.append(Character.toLowerCase(c));
            }
            wordIndex++;

        }
        return result.toString();
    }

    public static void main(String[] args){
        String[] s = {"AA aa ZZ zz", "  abc de   fghi   "};
        CreateStrangeCharacter csc = new CreateStrangeCharacter();

        for(String ss: s) {
            String result = csc.solution(ss);
            System.out.println("result = [" + result +"]");
        }
    }
}
