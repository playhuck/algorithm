package leetcode.array;

public class JumpGame2 {

    /*
        최소 점프 횟수를 구해야 합니다. JumpGame과 같은 조건입니다.
        뛸 수 있는 최대 거리 안에 있는, 숫자 들 중 가장 큰 값을 선택해서 다시 뛰었을 때 최소 뜀박질 카운트
        항상 엔드포인트에 닿도록 테스트 케이스가 준비됨

        1. 일단 뛰어서 max치를 구한다. ( 최대 뛸 수 있는 인덱스 )
        2. 최대 뛸 수 있는 인덱스 사이의 최대 값을 구합니다. ( while문으로 index 관리 )
        3. max치 까지 최대 값을 구한 뒤, 최대 값을 구한 인덱스를 기준으로 다시 뜁니다.

        1 <= nums.length <= 104
        0 <= nums[i] <= 1000
     */
    public int jump(int[] nums) {

        final int len = nums.length;
        int curMax = 0;
        int nextMax = 0;
        int jump = 0;

        if(len == 1) return 0;

        for(int i = 0; i < len - 1; i++) {

            nextMax = Math.max(nextMax, i + nums[i]);

            if(i == curMax) {
                jump ++;
                curMax = nextMax;
            }

            if(curMax >= len - 1) break;
        }

        return jump;

    }

}
