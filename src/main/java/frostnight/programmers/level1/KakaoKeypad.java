package frostnight.programmers.level1;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * [1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5]	"right"	"LRLLLRLLRRL"
 * [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	"left"	"LRLLRRLLLRR"
 * [1, 2, 3, 4, 5, 6, 7, 8, 9, 0]	"right"	"LLRLLRLLRL"
 */
public class KakaoKeypad {

    public String solution(int[] numbers, String hand) {
        // 키패드 배열 생성
        String[][] keyPad = {{"1", "2", "3"},{"4", "5", "6"},{"7", "8", "9"}, {"*", "0", "#"}};
        // 입력한 손가락
        StringBuilder pressFingers = new StringBuilder();
        int[] leftFingerIndex = {3, 0};
        int[] rightFingerIndex = {3, 2};
        for (int number : numbers) {
            // 해당 숫자의 키패드의 인덱스를 찾는다.
            int[] findPadNumberIndex = findPadNumberIndex(keyPad, number);
            String findFinger = press(number, hand, findPadNumberIndex, leftFingerIndex, rightFingerIndex);
            pressFingers.append(findFinger);
        }
        return pressFingers.toString();
    }

    public String press(int number, String hand, int[] findPadNumberIndex, int[] leftFingerIndex, int[] rightFingerIndex) {
        // 누를 손가락 결정
        String finger = selectFinger(number, hand, findPadNumberIndex, leftFingerIndex, rightFingerIndex);
        if ("L".equals(finger)) {
            moveIndex(findPadNumberIndex, leftFingerIndex);
        } else if ("R".equals(finger)) {
            moveIndex(findPadNumberIndex, rightFingerIndex);
        } else {
            throw new NoSuchElementException("FINGER NOT FOUND");
        }
        return finger;
    }

    public String selectFinger(int number, String hand, int[] findPadNumberIndex, int[] leftFingerIndex, int[] rightFingerIndex) {
        if (number == 1 || number == 4 || number == 7) {
            return "L";
        } else if (number == 3 || number == 6 || number == 9) {
            return "R";
        } else {
            // 왼쪽, 오른쪽 중에 가장 가까운 것 찾기
            if (findPadNumberIndex != null) {
                int diffX = Math.abs(findPadNumberIndex[0] - leftFingerIndex[0]);
                int diffY = Math.abs(findPadNumberIndex[1] - leftFingerIndex[1]);
                int leftDiff = Math.abs(diffX + diffY);

                diffX = Math.abs(findPadNumberIndex[0] - rightFingerIndex[0]);
                diffY = Math.abs(findPadNumberIndex[1] - rightFingerIndex[1]);
                int rightDiff = Math.abs(diffX + diffY);
                if (leftDiff > rightDiff) {
                    return "R";
                } else if (leftDiff < rightDiff) {
                    return "L";
                } else {
                    return hand.substring(0, 1).toUpperCase();
                }
            }
            return "";
        }
    }

    public void moveIndex(int[] findPadNumberIndex, int[] fingerIndex) {
        fingerIndex[0] = findPadNumberIndex[0];
        fingerIndex[1] = findPadNumberIndex[1];
    }

    public int[] findPadNumberIndex(String[][] keyPad, int number) {
        // 해당 숫자의 키패드의 인덱스를 찾는다.
        int[] findIndex = null;
        for (int i = 0; i < keyPad.length; i++) {
            for (int j = 0; j < keyPad[i].length; j++) {
                if (keyPad[i][j].equals(String.valueOf(number))) {
                    findIndex = new int[2];
                    findIndex[0] = i;
                    findIndex[1] = j;
                    break;
                }

                if (findIndex != null) {
                    break;
                }
            }
        }
        return findIndex;
    }

    public static void main(String[] args) {
        int[][] numbers = {
                {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5},
                {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2},
                {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}
        };
        String[] hands = {"right", "left", "right"};
        String[] except = {"LRLLLRLLRRL", "LRLLRRLLLRR", "LLRLLRLLRL"};
        KakaoKeypad kakaoKeypad = new KakaoKeypad();
        for (int i = 0; i < numbers.length; i++) {
            String result = kakaoKeypad.solution(numbers[i], hands[i]);
            System.out.println("result=>" + result);
            if (!result.equals(except[i])) {
                System.out.println("i = " + i);
                System.out.println("number[i] = " + Arrays.toString(numbers[i]));
                System.out.println("hands = " + hands[i]);
                System.out.println("result = " + result);
                System.out.println("except = " + except[i]);
            }
        }
    }
}
