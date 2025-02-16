package leetcode.stack_queue;

import java.util.Objects;

public class Deque641 {

    /*
        원형 양방향 큐(덱)를 직접 구현해보세요.
        MyCircularDeque 클래스를 다음과 같이 구현하세요:

        MyCircularDeque(int k) 최대 크기가 k인 덱을 초기화합니다.
        boolean insertFront() 덱의 앞쪽에 항목을 추가합니다. 작업이 성공하면 true를, 그렇지 않으면 false를 반환합니다.
        boolean insertLast() 덱의 뒤쪽에 항목을 추가합니다. 작업이 성공하면 true를, 그렇지 않으면 false를 반환합니다.
        boolean deleteFront() 덱의 앞쪽에서 항목을 삭제합니다. 작업이 성공하면 true를, 그렇지 않으면 false를 반환합니다.
        boolean deleteLast() 덱의 뒤쪽에서 항목을 삭제합니다. 작업이 성공하면 true를, 그렇지 않으면 false를 반환합니다.
        int getFront() 덱의 앞쪽 항목을 반환합니다. 덱이 비어있으면 -1을 반환합니다.
        int getRear() 덱의 마지막 항목을 반환합니다. 덱이 비어있으면 -1을 반환합니다.
        boolean isEmpty() 덱이 비어있으면 true를, 그렇지 않으면 false를 반환합니다.
        boolean isFull() 덱이 가득 찼으면 true를, 그렇지 않으면 false를 반환합니다.
     */
    static class MyCircularDeque {

        Integer[] deque;
        Integer front;
        Integer rear;

        public MyCircularDeque(int k) {
            deque = new Integer[k];
            front = -1;
            rear = -1;
        }

        public boolean insertFront(int value) {

            if(isFull()) return false;

            /*
                deque이기 때문에, 일반적인 순환 큐와 다릅니다.
                덱이 비어 있다면 머리는 0, 꼬리는 1이 됩니다.
                만약 프론트에서 추가하게 되면 -1이 되는데, 0에서 더 줄일 수 없기 때문에 front가 0이라면
                front는 length -1 됩니다.
             */
            if(front == -1) {
                front = 0;
                rear = 0;
            } else {
                front = front == 0 ? deque.length - 1 : front - 1;
            }

            deque[front] = value;

            return true;
        }

        public boolean insertLast(int value) {

            if(isFull()) return false;

            if(rear == -1) {
                front = 0;
                rear = 0;
            } else {
                rear = (rear + 1) % deque.length;
            }

            deque[rear] = value;

            return true;
        }

        public boolean deleteFront() {

            if(isEmpty()) return false;

            /*
                앞에서부터 논리적으로 삭제 합니다. 기존 순환 큐의 dequeue작업과 같습니다.
                삭제 될 때 큐가 비게 된다면 -1로 초기화 합니다.
                일반적으로는 논리적으로 삭제된 값이 return 됩니다.
                삭제할 때 기본적으로, 값이 먼저 빠진다는 개념으로 생각하는 것이 좋습니다.
             */

            int element = deque[front];

            if(Objects.equals(front, rear)){
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % deque.length;
            }

            return true;
        }

        public boolean deleteLast() {

            if(isEmpty()) return false;
            /*
                뒤에서부터 논리적으로 삭제 합니다.
                삭제 될 때 큐가 비게 된다면 -1로 초기화 합니다.
                일반적으로는 논리적으로 삭제된 값이 return 됩니다.
             */

            int element = deque[rear];

            if(Objects.equals(front, rear)){
                front = -1;
                rear = -1;
            } else {
                rear = rear == 0 ? deque.length - 1 : rear - 1;
            }

            return true;
        }

        public int getFront() {

            if(isEmpty()) return -1;

            return deque[front];
        }

        public int getRear() {

            if(isEmpty()) return -1;

            return deque[rear];
        }

        public boolean isEmpty() {

            return front == -1;
        }

        public boolean isFull() {

            return (rear + 1) % deque.length == front;
        }
    }
}
