package leetcode.stack_queue.prev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Queue1700 {
    /*
        학교 급식실에서는 점심시간에 동그란 샌드위치와, 사각형 샌드위치를 제공하며, 이는 각각 숫자 0과 1로 표시됩니다. 모든 학생들은 줄을 서 있습니다.
        각 학생은 사각형 또는 원형 샌드위치 중 하나를 선호합니다.
        급식실의 샌드위치 수는 학생 수와 같습니다. 샌드위치들은 스택에 쌓여 있습니다. 각 단계마다:

        만약 줄의 맨 앞에 있는 학생이 스택의 맨 위에 있는 샌드위치를 선호한다면, 그 학생은 샌드위치를 가져가고 줄에서 나갑니다.
        그렇지 않다면, 그 학생은 샌드위치를 그대로 두고 줄의 맨 뒤로 갑니다.

        이 과정은 줄에 서 있는 학생들 중 아무도 스택 맨 위의 샌드위치를 가져가기를 원하지 않아 먹을 수 없게 될 때까지 계속됩니다.
        두 개의 정수 배열 students와 sandwiches가 주어집니다.
        여기서 sandwiches[i]는 스택에 있는 i번째 샌드위치의 종류를 나타내고(i = 0은 스택의 맨 위), students[j]는 초기 줄에서 j번째 학생이 선호하는 샌드위치 종류를 나타냅니다(j = 0은 줄의 맨 앞).
        먹을 수 없는 학생의 수를 반환하세요.

        학생이 스택의 맨 위의 샌드위치를 선호하면 제거(sandwiches.pop) / 그렇지 않다면 그대로 두고 학생은 줄의 맨 뒤로 (students.remove(0), students.push(studentes[0])
     */

    public static int countStudents(int[] students, int[] sandwiches) {


        List<Integer> studentsList = new ArrayList<>(Arrays.stream(students).boxed().toList());
        List<Integer> sandwichesList = new ArrayList<>(Arrays.stream(sandwiches).boxed().toList());

        /*
            현재 학생의 배열,
            unmatched Loop가 학생 배열과 같아지면 break;

            만약 일치하는게 나타난다면, studentSize - 1
            unmatchedSize 0;
         */
        int studentListSize = studentsList.size();
        int unmatchedSize = 0;

        while (studentListSize != unmatchedSize) {

            if (Objects.equals(studentsList.get(0), sandwichesList.get(0))) {
                studentsList.remove(0);
                sandwichesList.remove(0);

                studentListSize--;
                unmatchedSize = 0;

            } else {

                int temp = studentsList.get(0);
                studentsList.remove(0);
                studentsList.add(temp);

                unmatchedSize++;
            }

        }

        return studentsList.size();
    }
}
