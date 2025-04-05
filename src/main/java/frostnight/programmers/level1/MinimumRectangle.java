package frostnight.programmers.level1;

import java.util.*;
import java.util.stream.Collectors;

public class MinimumRectangle {

    public int solution(int[][] sizes) {
        int answer = 0;
        int maxWidth = 0, maxHeight = 0;
        TreeSet<Integer> widthSet = new TreeSet<>(Comparator.reverseOrder());
        TreeSet<Integer> heightSet = new TreeSet<>(Comparator.reverseOrder());
        /**
         * {
         * index
         * number
         * }
         */

        // 1. 가로, 세로 각 각 리스트로 변환
        for (int[] size : sizes) {
            widthSet.add(size[0]);
            heightSet.add(size[1]);
        }
        // 역순 정렬 및 첫 번째 값 max으로 SET
        maxWidth = widthSet.first();
        maxHeight = heightSet.first();
        for (int[] size : sizes) {
            if ((size[0] >= maxWidth || size[1] >= maxHeight) &&
                    (size[1] <= maxWidth && size[0] <= maxHeight)) {
                System.out.println("maxWidth = " + maxWidth);
                System.out.println("maxHeight = " + maxHeight);
                System.out.println("size = " + size[0] + "," + size[1]);
                // 서로 위치 변환 후 둘 다 최대치 보다 낮은 경우 서로 값을 바꿔서 계산
                if (size[0] >= maxWidth) {
                    widthSet.pollFirst();
                    maxWidth = Optional.ofNullable(widthSet.first()).orElse(0);
                }
                if (size[1] >= maxHeight) {
                    heightSet.pollFirst();
                    maxHeight = Optional.ofNullable(heightSet.first()).orElse(0);
                }
            }
        }
        answer = maxHeight * maxWidth;
        return answer;
    }

    public static void main(String[] args) {

        MinimumRectangle minimumRectangle = new MinimumRectangle();
        int[][][] numbers = {
//                {{60, 50}, {30, 70}, {60, 30}, {80, 40}},
                {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}},
//                {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}},
        };
        int[] except = {4000, 120, 133};
        for (int i = 0; i < numbers.length; i++) {
            int result = minimumRectangle.solution(numbers[i]);
            System.out.println("result = " + result);
        }
    }
}
