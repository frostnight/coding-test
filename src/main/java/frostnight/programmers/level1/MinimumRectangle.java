package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class MinimumRectangle {

    // 1. 가로, 세로가 모든 지갑 크기보다는 커야 한다.

    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0, maxHeight = 0;
        List<int[]> newSizes = new ArrayList<int[]>();
        // 우선 제일 큰 지갑 사이즈를 구한다.
        for (int[] size : sizes) {
            int width = size[0];
            int height = size[1];
            newSizes.add(size);
            newSizes.add(new int[] {height, width});
        }

        for (int i = 0; i < newSizes.size(); i++) {
            int width = newSizes.get(i)[0];
            int height = newSizes.get(i)[1];
            for (int j = 0; j < newSizes.size(); j++) {
                if (i != j) {
                    int compWidth = newSizes.get(j)[0];
                    int compHeight = newSizes.get(j)[1];
                }
            }
        }
//        for (int i = 0; i < newSizes.size(); i++) {
//            int width = newSizes.get(i)[0];
//            int height = newSizes.get(i)[1];
//            if ((width >= maxWidth || height >= maxHeight) && width * height < answer) {
//                maxWidth = width;
//                maxHeight = height;
//                answer = width * height;
//            }
//        }
//        System.out.println("answer2 = " + answer);

        return answer;
    }

    public static void main(String[] args) {

        MinimumRectangle minimumRectangle = new MinimumRectangle();
        int[][][] numbers = {
                {{60, 50}, {30, 70}, {60, 30}, {80, 40}},
//                {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
//                {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}},
        };
        int[] except = {4000, 120, 133};
        for (int i = 0; i < numbers.length; i++) {
            int result = minimumRectangle.solution(numbers[i]);
            System.out.println("result = " + result);
        }
    }
}
