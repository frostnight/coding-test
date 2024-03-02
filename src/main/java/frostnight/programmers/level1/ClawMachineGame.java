package frostnight.programmers.level1;


import java.util.Stack;

public class ClawMachineGame {

	public static void main(String[] args){

		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};

		int answer = new ClawMachineGame().solution(board, moves);

		System.out.println("answer = " + answer);
	}

	public int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> bucket = new Stack<>();
		for(int i=0; i < moves.length; i++){
			int item = getItem(board, moves[i] - 1);
			if(item > 0){
				answer += checkItem(bucket, item);
			}
		}
		return answer;
	}

	public int getItem(int[][] board, int y){
		int result = 0;
		for(int x = 0; x < board.length; x++){
			if(board[x][y] != 0){
				result = board[x][y];
				board[x][y] = 0;
				break;
			}
		}
		return result;
	}

	public int checkItem(Stack<Integer> bucket, int item){
		int remove_count = 0;

		if(bucket.size() > 0 && bucket.peek() == item){
			bucket.pop();
			remove_count = 2;
		} else {
			bucket.push(item);
		}
		return remove_count;
	}

}
