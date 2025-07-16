package leetcode.stack_queue.prev;

import java.util.LinkedList;
import java.util.Queue;

public class RE_Queue649_Dota2_Senate {
    /*
        Dota2 세계에는 Radiant와 Dire, 두 진영이 있습니다.
        Dota2의 의회는 이 두 진영에서 온 의원들로 구성되어 있습니다. 현재 의회는 Dota2 게임의 변경 사항을 결정하려고 합니다.
        이 투표는 라운드 기반으로 진행됩니다. 각 라운드에서 각 의원은 다음 두 가지 권리 중 하나를 행사할 수 있습니다:

        다른 의원의 권리 박탈: 한 의원이 다른 의원의 모든 권리를 현재 라운드와 이후의 모든 라운드에서 박탈할 수 있습니다.
        승리 선언: 만약 한 의원이 투표권을 가진 남은 의원들이 모두 같은 진영이라는 것을 발견하면, 승리를 선언하고 게임의 변경 사항을 결정할 수 있습니다.

        각 의원의 진영을 나타내는 문자열 senate가 주어집니다. 문자 'R'은 Radiant 진영을, 'D'는 Dire 진영을 나타냅니다. n명의 의원이 있다면, 주어진 문자열의 길이는 n이 됩니다.
        라운드 기반 절차는 주어진 순서대로 첫 번째 의원부터 마지막 의원까지 진행됩니다.
        이 절차는 투표가 끝날 때까지 계속됩니다. 권리를 잃은 모든 의원들은 이 절차 동안 건너뛰게 됩니다.
        모든 의원이 충분히 현명하여 자신의 진영을 위한 최선의 전략을 구사한다고 가정합니다.
        어느 진영이 최종적으로 승리를 선언하고 Dota2 게임을 변경하게 될지 예측하세요. 출력은 "Radiant" 또는 "Dire"이어야 합니다.
     */

    public static String predictPartyVictory(String senate) {

        if(senate.length() == 1){

            return senate.equals("R") ? "Radiant" : "Dire";
        }

        Queue<Integer> rList = new LinkedList<>();
        Queue<Integer> dList = new LinkedList<>();

        String[] strings = senate.split("");

        for (int i = 0; i < strings.length; i++) {
            if(strings[i].equals("R")){
                rList.add(i);
            } else {
                dList.add(i);
            }
        }

        if(dList.isEmpty()) {
            return "Radiant";
        }

        if(rList.isEmpty()) {
            return "Dire";
        }

        while(!rList.isEmpty() && !dList.isEmpty()){
            int r = rList.poll();
            int d = dList.poll();

            if(r < d) {
                rList.offer(r + senate.length());
            } else {
                dList.offer(d + senate.length());
            }
        }

        return rList.isEmpty() ? "Dire" : "Radiant";
    }
}
