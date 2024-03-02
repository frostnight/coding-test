package frostnight.programmers.level1;

/**
 * 1-1. 입력된 수가 짝수라면 2로 나눕니다.
 * 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
 * 2. 결과로 나온 수에 같은 작업을 1이 될 때까지 반복합니다
 */
public class CollatzConjecture {
	public static void main(String[] args) {
		int num = 1;
		System.out.println(solution(num));
	}

	public static int solution(int num) {
		int answer = 0;
		long long_num = (long)num;
		while(true){
			if(answer > 500){
				return -1;
			}

			if(long_num == 1){
				break;
			}

			long_num = conjecture(long_num);

			answer++;
		}
		return answer;
	}

	public static long conjecture(long num){

		if(num > 1 && num % 2 == 0){
			num = num / 2;
		} else {
			num = num * 3 + 1;
		}

		return num;
	}
}
