package frostnight.programmers.level1;

public class RecommendedNewId {

	public static void main(String[] args){
		String newId = "...!@BaT#*..y.abcdefghijklm";
		String result = solution(newId);
		System.out.println("result[" + result+"]");
	}

	public static String solution(String new_id) {
		String answer = new_id;

		for(int level=1; level <= 7; level++){
			answer = change(level, answer);
		}
		return answer;
	}

	public static String change(int level, String id){

		String level2Match = "[^a-z0-9-_.]";
		String level3Match = "[.]{2,}";

		switch (level) {
			case 1:
				return id.toLowerCase();
			case 2:
				return id.replaceAll(level2Match, "");
			case 3:
				return id.replaceAll(level3Match, ".");
			case 4:
				if(id.startsWith(".")){
					id = id.substring(1);
				}
				if(id.endsWith(".")){
					id = id.substring(0, id.length() - 1);
				}
				return id;
			case 5:
				if("".equals(id)){
					id = "a";
				}
				return id;
			case 6:
				if(id.length() >= 16){
					id = id.substring(0, 15);
					if(id.endsWith(".")){
						id = id.substring(0, id.length() - 1);
					}
				}
				return id;
			case 7:
				if(id.length() <= 2){
					String addId = id.substring(id.length() - 1);
					while(id.length() < 3){
						id += addId;
					}

				}
				return id;
		}
		return id;
	}

}
