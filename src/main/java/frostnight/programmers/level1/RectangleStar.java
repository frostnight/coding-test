package frostnight.programmers.level1;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * 직사각형 별찍기
 */
public class RectangleStar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();

		for(int i=0; i < b; i++){
			for (int j=0; j < a; j++){
				System.out.print("*");
			}
			System.out.println("");
		}
		System.out.println("====================");
		// 다른 사람 풀이
		StringBuilder sb = new StringBuilder();
		IntStream.range(0, a).forEach(s -> sb.append("*"));
		IntStream.range(0, b).forEach(s -> System.out.println(sb.toString()));
	}
}
