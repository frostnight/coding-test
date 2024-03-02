package frostnight.programmers.level1;

public class HidePhoneNumber {

	public static void main(String[] args){
		String phone_number = "027778888";

		String answer = solution(phone_number);
		System.out.println("answer = " + answer);
	}

	public static String solution(String phone_number) {
		String[] phone_number_arr = phone_number.split("");
		StringBuilder sbuilder = new StringBuilder();
		for(int i=0; i < phone_number_arr.length; i++){
			if(i >= phone_number_arr.length - 4){
				sbuilder.append(phone_number_arr[i]);
			} else {
				sbuilder.append("*");
			}
		}

		return sbuilder.toString();
	}
}
