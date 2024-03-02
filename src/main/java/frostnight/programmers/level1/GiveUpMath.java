package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GiveUpMath {

	public static void main(String[] args){

		int[] answers = {1,3,2,4,2};
		int[] result = new GiveUpMath().solution(answers);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
	}

	public int[] solution(int[] answers){
		List<Student> students = new ArrayList<>();
		students.add(new Student(new int[] {1, 2, 3, 4, 5}));
		students.add(new Student(new int[] {2, 1, 2, 3, 2, 4, 2, 5}));
		students.add(new Student(new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}));

		int maxPoint = 0;
		List<Integer> studentRank = new ArrayList<>();

		for (int i=0; i < students.size(); i++) {
			Student student = students.get(i);
			markTest(student, answers);

			int studentPoint = student.getPoint();
			System.out.println("studentPoint = " + studentPoint);
			if(studentPoint > maxPoint){
				studentRank.clear();
				studentRank.add((i+1));
				maxPoint = studentPoint;
			} else if (studentPoint == maxPoint && studentPoint > 0){
				studentRank.add((i+1));
			}
		}

		return studentRank.stream().mapToInt(i->i).toArray();
	}

	public int markTest(Student student, int[] answers){
		for(int i=0; i < answers.length; i++){
			student.addPoint(student.isCorrect(answers[i]));
		}
		return student.getPoint();
	}

	static class Student {
		private List<Integer> selectCycle = new ArrayList<>();
		private int nowIndex = 0;
		private int point = 0;

		public Student(int[] selectArr){
			this.selectCycle = Arrays.stream(selectArr).boxed().collect(Collectors.toList());
		}

		public int isCorrect(int answer){
			int point = 0;
			if(selectCycle.size() == nowIndex) {
				nowIndex = 0;
			}

			if(selectCycle.get(nowIndex++) == answer){
				point++;
				return point;
			}
			return point;
		}

		public void addPoint(int point){
			this.point += point;
		}

		public int getPoint() {
			return point;
		}
	}
}
