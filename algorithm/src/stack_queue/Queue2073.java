package stack_queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Queue2073 {
    /*
        n명의 사람들이 티켓을 구매하기 위해 줄을 서 있습니다. 여기서 0번째 사람은 줄의 맨 앞에 있고, (n - 1)번째 사람은 줄의 맨 뒤에 있습니다.
        길이가 n인 0부터 시작하는 정수 배열 tickets가 주어지며, 여기서 i번째 사람이 구매하고 싶은 티켓의 수는 tickets[i]입니다.
        각 사람은 티켓 한 장을 구매하는 데 정확히 1초가 걸립니다. 한 사람은 한 번에 1장의 티켓만 구매할 수 있으며,
        추가 티켓을 구매하기 위해서는 줄의 맨 뒤로 가야 합니다(이는 즉시 이루어집니다). 만약 더 이상 구매할 티켓이 없다면, 그 사람은 줄을 떠납니다.
        처음에 위치 k(0부터 시작하는 인덱스)에 있던 사람이 티켓 구매를 모두 완료하는 데 걸리는 시간을 반환하세요.
     */

    public static int timeRequiredToBuy(int[] tickets, int k) {

        List<Integer> ticketList = new ArrayList<>(Arrays.stream(tickets).boxed().toList());

        int paySec = 0;

        int kIdx = k;

        while (ticketList.get(kIdx) > 0) {

            if(ticketList.get(0) > 0) {

                paySec ++;

                int tmp = ticketList.get(0) - 1;

                ticketList.add(tmp);
                ticketList.remove(0);

                if(kIdx > 0) kIdx --;
                else {

                    if(tmp == 0) break;
                    else {
                        kIdx = ticketList.size() - 1;
                    }
                }

            } else {

                int tmp = ticketList.get(0);

                ticketList.add(tmp);
                ticketList.remove(0);

                if(kIdx > 0) kIdx --;
            }

        }

        return paySec;
    }
}
