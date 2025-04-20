package frostnight.programmers.level1;


import java.util.*;

// 신고 횟수에 제한은 없습니다. 서로 다른 유저를 계속해서 신고할 수 있습니다.
// 한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
// 유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.
public class ReceiveReportResult {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        // 신고한 사람을 기준으로 신고 대상 집합 구성
        Map<String, List<String>> reportMap = new HashMap<String, List<String>>();
        Map<String, Integer> reportTargetCountMap = new HashMap<>();

        for (String reportItem: report) {
            String[] reportInfo = reportItem.split(" ");
            String reportBy = reportInfo[0];
            String reportTarget = reportInfo[1];
            if (reportMap.containsKey(reportBy)) {
                // 신고한 적 있는 경우
                List<String> reportList = reportMap.get(reportBy);
                if (!reportList.contains(reportTarget)) {
                    // 같은 ID로 중복 신고 X
                    reportList.add(reportTarget);
                    reportTargetCountMap.put(reportTarget, reportTargetCountMap.getOrDefault(reportTarget, 0) + 1);
                }
            } else {
                // 최초 신고
                List<String> reportList = new ArrayList<>();
                reportList.add(reportTarget);
                reportTargetCountMap.put(reportTarget, reportTargetCountMap.getOrDefault(reportTarget, 0) + 1);
                reportMap.put(reportBy, reportList);
            }
        }

        for (int i=0; i < id_list.length; i ++) {
            String id = id_list[i];
            List<String> reportList = reportMap.get(id);
            // 정지 대상
            if (reportList != null) {
                long count = reportList.stream()
                        .filter(targetId -> reportTargetCountMap.getOrDefault(targetId, 0) >= k)
                        .count();
                answer[i] = (int) count;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        ReceiveReportResult rr =  new ReceiveReportResult();
        String[][] idList = {
                {"muzi", "frodo", "apeach", "neo"},
                {"con", "ryan"},
        };
        String[][] report = {
                {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},
                {"ryan con", "ryan con", "ryan con", "ryan con"},
        };
        int[] k = {2, 3};
        int[][] except = {
                {2,1,1,0},
                {0,0},
        };
        for (int i=0; i < idList.length; i ++) {
            int[] result = rr.solution(idList[i], report[i], k[i]);
            for (int j=0; j < result.length; j ++) {
                if (except[i][j] != result[j]) {
                    System.out.println("i = " + i);
                    System.out.println("j = " + j);
                    System.out.println("result = " + result[j]);
                }
            }
        }
    }
}
