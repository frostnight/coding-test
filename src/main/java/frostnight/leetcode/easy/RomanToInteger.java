package frostnight.leetcode.easy;

public class RomanToInteger {

	public static void main(String[] args) {
		String s = "LVIII";
		System.out.println("romanToInt(s) = " + romanToInt(s));
	}

	static int romanToInt(String s) {
		String[] split = s.split("");
		int sum = 0;
		for (int i = 0; i < split.length; i++) {

			String left = split[i];
			String right = i == split.length - 1 ? "ZERO" : split[i + 1];

			RomanNumber leftRoman = RomanNumber.valueOf(left);
			RomanNumber rightRoman = RomanNumber.valueOf(right);

			if (leftRoman.equals(RomanNumber.I) &&
					(rightRoman.equals(RomanNumber.V) || rightRoman.equals(RomanNumber.X))) {
				sum += rightRoman.getNumber() - 1;
				i++;

			} else if (leftRoman.equals(RomanNumber.X) &&
					(rightRoman.equals(RomanNumber.L) || rightRoman.equals(RomanNumber.C))) {
				sum += (rightRoman.getNumber() - 10);
				i++;
			} else if (leftRoman.equals(RomanNumber.C) &&
					(rightRoman.equals(RomanNumber.D) || rightRoman.equals(RomanNumber.M))) {
				sum += (rightRoman.getNumber() - 100);
				i++;
			} else {
				sum += leftRoman.getNumber();
			}
		}
		return sum;
	}

	public enum RomanNumber {
		ZERO(0),
		I(1),
		V(5),
		X(10),
		L(50),
		C(100),
		D(500),
		M(1000);

		private final int number;

		RomanNumber(int number) {
			this.number = number;
		}

		public int getNumber() {
			return number;
		}
	}
}