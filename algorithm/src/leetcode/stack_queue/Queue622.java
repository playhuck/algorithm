package leetcode.stack_queue;

import java.util.Objects;

public class Queue622 {

    /*
        순환 큐를 직접 구현해보세요. 순환 큐는 FIFO(First In First Out, 선입선출) 원칙에 따라 동작하는 선형 자료구조이며,
        마지막 위치가 첫 번째 위치와 연결되어 원을 이루는 구조입니다. "링 버퍼"라고도 불립니다.
        순환 큐의 장점 중 하나는 큐의 앞쪽 공간을 활용할 수 있다는 것입니다.
        일반적인 큐에서는 큐가 가득 찼을 때 큐의 앞쪽에 공간이 있더라도 새로운 원소를 삽입할 수 없습니다.
        하지만 순환 큐를 사용하면 이 공간을 새로운 값을 저장하는 데 활용할 수 있습니다.
        MyCircularQueue 클래스를 다음과 같이 구현하세요:

        MyCircularQueue(k) 큐의 크기를 k로 하여 객체를 초기화합니다.
        int Front() 큐의 맨 앞 항목을 가져옵니다. 큐가 비어있다면 -1을 반환합니다.
        int Rear() 큐의 마지막 항목을 가져옵니다. 큐가 비어있다면 -1을 반환합니다.
        boolean enQueue(int value) 순환 큐에 원소를 삽입합니다. 작업이 성공하면 true를 반환합니다.
        boolean deQueue() 순환 큐에서 원소를 삭제합니다. 작업이 성공하면 true를 반환합니다.
        boolean isEmpty() 순환 큐가 비어있는지 확인합니다.
        boolean isFull() 순환 큐가 가득 찼는지 확인합니다.

        이 문제는 프로그래밍 언어에 내장된 큐 자료구조를 사용하지 않고 해결해야 합니다.
     */
    static class MyCircularQueue {

        int[] circularQueue;
        Integer front;
        Integer rear;

        public MyCircularQueue(int k) {

            /*
                MyCircularQueue(k) 큐의 크기를 k로 하여 객체를 초기화
             */
            this.circularQueue = new int[k];

            /*
                Queue가 비어있다는 것을 명확히 하기 위해 front(앞단), rear(뒷단)을 -1로 지정합니다.
             */
            this.front = -1;
            this.rear = -1;

        }

        public boolean enQueue(int value) {

            /*
                1. 가득찼다면, false를 return
             */
            if(isFull()){
                return false;
            }

            /*
                2. 꼬리가 -1부터 시작하기 때문에 +1된 값이 큐에 새로 추가된 값이 됩니다.
                   단, length로 나눴을 때 나머지가 0이 됐다는 것은 배열을 한바퀴 다 돌아서 index가 0으로
                   다시 가야한다는 의미입니다.

                   추가적으로, 가득차지 않았을 때 front가 -1이라면 rear -> 0으로 초기화 시켜줍니다.
             */
            rear = (rear + 1) % circularQueue.length;
            if(front == -1){
                front = rear;
            }

            circularQueue[rear] = value;

            return true;
        }

        public boolean deQueue() {

            /*
                1. 비어있다면 false
             */
            if(isEmpty()){
                return false;
            }

            /*
                2. front와 rear가 같다면, 마지막으로 제거된 값으로 반영된 front가 rear를 따라잡아
                   큐 안의 모든 데이터가 삭제 됐다는 의미기 때문에 front와 rear를 empty 상태로 초기화 시켜줍니다.

                   //

                   그게 아니라면 머리를 + 1하여, 기존 데이터를 논리적으로 삭제시켜줍니다.
                   해당 인덱스에 rear가 다시 도착했을 때는 새로운 값을 할당하기 때문에
                   논리적으로 제거된 데이터가 다시 사용될일은 없습니다. 여기서, 일반적으로는 dequeue된 데이터들을
                   return하여 사용하게 됩니다. 즉, 꺼낸 데이터를 사용하게 됩니다.
             */
            if(front.equals(rear)) {
                front = -1;
                rear = -1;
            } else {
                front = (front + 1) % circularQueue.length;
            }

            return true;

        }

        public int Front() {

            if(isEmpty()){
                return -1;
            }
            return circularQueue[front];
        }

        public int Rear() {

            if(isEmpty()){
                return -1;
            }

            return circularQueue[rear];
        }

        public boolean isEmpty() {

            /*
                rear와 front가 같다면 -1을 return합니다. 모든 큐가 비워졌다는 의미입니다.
             */
            return Objects.equals(rear, front) && front == -1;
        }

        public boolean isFull() {

            if(isEmpty()) {
                return false;
            }

            /*
                현재 꼬리의 값에 + 1 된 값을 length만큼 나눴을 때 front와 같다는 것은
                큐가 가득 찼다는 의미가 됩니다.
             */
            return (rear + 1) % circularQueue.length == front;

        }
    }
}
