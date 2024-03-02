package frostnight.programmers.level1;

public class ReminderOne {

    public static int solution(int n) {
        int answer = 1;

        while(true){

            if( n % answer == 1){
                return answer;
            }
            answer++;
        }

    }

    public static void main(String[] args){
        int n = 10;
        System.out.println("solution(n) = " + solution(n));
    }
}
