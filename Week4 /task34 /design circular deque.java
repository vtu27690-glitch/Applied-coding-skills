class MyCircularDeque {

    int[] arr;
    int front;
    int rear;
    int size;
    int capacity;

    public MyCircularDeque(int k) {
        arr = new int[k];
        capacity = k;
        front = 0;
        rear = 0;
        size = 0;
    }

    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        // Move front backward circularly
        front = (front - 1 + capacity) % capacity;

        arr[front] = value;

        size++;

        return true;
    }

    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        arr[rear] = value;

        // Move rear forward
        rear = (rear + 1) % capacity;

        size++;

        return true;
    }

    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        front = (front + 1) % capacity;

        size--;

        return true;
    }

    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        // Move rear backward
        rear = (rear - 1 + capacity) % capacity;

        size--;

        return true;
    }

    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return arr[front];
    }

    public int getRear() {

        if (isEmpty()) {
            return -1;
        }

        return arr[(rear - 1 + capacity) % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}



Input
["MyCircularDeque","insertLast","insertLast","insertFront","insertFront","getRear","isFull","deleteLast","insertFront","getFront"]
[[3],[1],[2],[3],[4],[],[],[],[4],[]]
Output
[null,true,true,true,false,2,true,true,true,4]
Expected
[null,true,true,true,false,2,true,true,true,4]
