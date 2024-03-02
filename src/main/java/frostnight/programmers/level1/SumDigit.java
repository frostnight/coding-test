package frostnight.programmers.level1;

public class SumDigit {

    static public int solution(int n) {
        int answer = 0;

        String str_n = String.valueOf(n);
        for(int i=0; i < str_n.length(); i++){
            answer += Integer.parseInt(String.valueOf(str_n.charAt(i)));
        }

        return answer;
    }

    static public void main(String[] args){
        int n = 987;
        System.out.println("solution(n) = " + solution(n));
    }
}
