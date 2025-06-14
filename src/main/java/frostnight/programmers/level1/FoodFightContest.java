package frostnight.programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class FoodFightContest {

  public String solution(int[] food) {
    String answer = "";
    // food에서 각 배열의 숫자만큼 꺼낸다
    // 물은 항상 0번 배열에 있으므로 1번 부터 시작
    // 각 배열의 아이템 개수 반복 마다 남은 양이 2개 이상인지 확인 후 그렇지 않으면 다음 아이템으로 이동
    // A선수 리스트로 저장하고 하나 더 복사해서 역순으로 결합시킨다.
    List<Integer> players = new ArrayList<>();
    AtomicInteger counter = new AtomicInteger(1);
    Arrays.stream(food)
        .skip(1)
        .forEach(
            f -> {
              int item = f;
              while (item > 1) {
                players.add(counter.get());
                item -= 2;
              }
              counter.incrementAndGet();
            });
    List<String> playerItems = players.stream().map(Object::toString).collect(Collectors.toList());
    answer = String.join("", playerItems) + "0";
    answer += playerItems.stream().sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    return answer;
  }

  public static void main(String[] args) {
    FoodFightContest foodFightContest = new FoodFightContest();
    int[] food = {1, 3, 4, 6};
    foodFightContest.solution(food);
  }
}
